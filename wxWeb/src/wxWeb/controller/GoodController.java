package wxWeb.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import wxWeb.domain.Good;
import wxWeb.service.GoodService;

@Controller
@RequestMapping("/PCGood")
public class GoodController {
	
	@Autowired
	@Qualifier("GoodService")
	private GoodService goodService;
	
	@RequestMapping("/SelectAll")
	public String selectAllControl (Model model) {
		System.out.println("开始查询");
		List<Good> good_list = goodService.selectAllServ();
		if(good_list.isEmpty()==false) {
			System.out.println(good_list.size());
		}
		model.addAttribute("good_list",good_list);
		return "success";
	}
		
	@RequestMapping("/SelectWithId")
	public String selectWithId(String id,Model model) {
		int id_int = 0;
		try {
		    id_int = Integer.parseInt(id);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		Good good = goodService.selectWithIdServ(id_int);
		model.addAttribute("good",good);
		return "success";
	}
	
	@RequestMapping("/SelectWithKey")
	public String selectWithKey(String key,Model model) {
		if(key.isEmpty()) {
			//获取失败
			return "fail";
		}
		List<Good> key_good_list = goodService.SelectWithKeyServ(key);
		model.addAttribute("key_good_list", key_good_list);
		return "success";
	}
	
	@RequestMapping("/UpdatePrice")
	public String updatePrice(Good good,Model model) {
		if(good == null) {
			//获取数据失败
			return "fail";
		}
		int flag = goodService.UpdatePriceServ(good.getPrice(), good.getNewPrice(), good.getDiscount(), good.getId());
		if(flag == 0) {
			//修改失败
			return "fail";
		}
		//修改成功
		return "success";
	}
	
	@RequestMapping("/UpdateDetail")
	public String updateDetail(String Detail,String id) {
		int id_int = 0;
		try {
		    id_int = Integer.parseInt(id);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		int flag = goodService.UpdateDetailServ(Detail, id_int);
		//int flag = 1;
		if(flag == 0) {
			//修改失败
			return "fail";
		}
		//修改成功
		System.out.println("更改详情成功");
		return "success";
	}
	
	@RequestMapping("/UpdateInventory")
	public String updateInventory(String inventory,String id) {
		int inventory_int= 0;
		int id_int = 0;
		int flag = 0;
		try {
		    id_int = Integer.parseInt(id);
		    inventory_int = Integer.parseInt(inventory);
		    flag = goodService.UpdateInventoryServ(inventory_int, id_int);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		//int flag = 1;
		if(flag == 0) {
			//修改失败
			return "fail";
		}
		return "success";
	}
	
	@RequestMapping("/UpdateName")
	public String updateName(String name,String id) {
		int id_int = 0;
		int flag = 0;
		try {
		    id_int = Integer.parseInt(id);
		    flag = goodService.UpdateNameServ(name, id_int);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		//int flag = 1;
		if(flag == 0) {
			//修改失败
			return "fail";
		}
		return "success";
	}
	
	@RequestMapping("/UpdateType")
	public String updateType(String type,String id) {
		int id_int = 0;
		int flag = 0;
		try {
		    id_int = Integer.parseInt(id);
		    flag = goodService.UpdateTypeServ(type, id_int);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		//int flag = 1;
		if(flag == 0) {
			//修改失败
			return "fail";
		}
		return "success";
	}
	
	@RequestMapping("/UpdateIsValue")
	public String updateIsValue(String isValue,String id) {
		int id_int = 0;
		int flag = 0;
		try {
		    id_int = Integer.parseInt(id);
		    flag = goodService.UpdateIsValueServ(isValue, id_int);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		//int flag = 1;
		if(flag == 0) {
			//修改失败
			return "fail";
		}
		return "success";
	}
	
	@RequestMapping("/InsertGood")
	public String insertGood(
			@RequestParam("image") CommonsMultipartFile image,
			@RequestBody Good good,
			HttpServletRequest request) {
		if(image.getSize()!=0) {
			String path = "D:/WXGoodImage/";
			File TempFile = new File(path);
			if (TempFile.exists()) {
				if (TempFile.isDirectory()) {
					System.out.println("该文件夹存在。");
				}else {
					 System.out.println("同名的文件存在，不能创建文件夹。");
				}
			}else {
				 System.out.println("文件夹不存在，创建该文件夹。");
				 TempFile.mkdir();
			}
			String imagename = image.getOriginalFilename();
			String imagename_extension = imagename.substring(imagename
					.lastIndexOf(".") + 1);
			System.out.println("视频的后缀名:"+imagename_extension);
			if(imagename_extension.equals("jpg")
					||imagename_extension.equals("png")
					||imagename_extension.equals("jpeg")) {
				long imagename1 = new Date().getTime();
				imagename = "G"+Long.toString(imagename1)+"."+imagename_extension;
				try {
					System.out.println("写入本地磁盘/服务器");
					InputStream is = image.getInputStream();
					OutputStream os = new FileOutputStream(new File(path, imagename));
					int len = 0;
					byte[] buffer = new byte[2048];
					
					while ((len = is.read(buffer)) != -1) {
						os.write(buffer, 0, len);
					}
					os.close();
					os.flush();
					is.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String pictrue = path+imagename;
				int flag = goodService.InsertGoodServ(good.getName(), pictrue, good.getPrice(), good.getDiscount(), good.getNewPrice(),
						good.getDetail(), good.getHot(), good.getType(), good.getInventory(), 0, "true", "all");
				if(flag == 1) {
					return "success";
				}else {
					return "fail";
				}
				
			}else {
				return "fail";
			}
		}else {
			return "fail";
		}
	}
}
