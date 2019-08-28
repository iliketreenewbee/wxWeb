package wxWeb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONArray;
import wxWeb.domain.Good;
import wxWeb.service.GoodService;

@Controller
@RequestMapping("/WXGood")
public class WXGoodCtrl {
	@Autowired
	@Qualifier("GoodService")
	private GoodService goodService;
	
	@RequestMapping("/SelectAll")
	public void WXselectAll (int message,HttpServletResponse response) throws IOException {
		System.out.println(message);
		List<Good> good_list = goodService.selectAllServ();
		if(good_list.isEmpty()==false) {
			System.out.println(good_list.size());
		}
		System.out.println("���ӳɹ�");
		JSONArray json = JSONArray.fromObject(good_list); //����ѯ����newsList����ת��Ϊjson����
		String str = json.toString(); //��json����ת��Ϊ�ַ���
		response.getWriter().write(str);
	}
	
	@RequestMapping("/SelectWithId")
	public void selectWithId(String id,HttpServletResponse response) throws IOException {
		int id_int = 0;
		try {
		    id_int = Integer.parseInt(id);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		Good good = goodService.selectWithIdServ(id_int);
		JSONArray json = JSONArray.fromObject(good); 
		String str = json.toString();
		response.getWriter().write(str);
	}
	
	@RequestMapping("/SelectWithKey")
	public void selectWithKey(String key,HttpServletResponse response) throws IOException {
		List<Good> key_good_list = goodService.SelectWithKeyServ(key);
		JSONArray json = JSONArray.fromObject(key_good_list); //����ѯ����newsList����ת��Ϊjson����
		String str = json.toString(); //��json����ת��Ϊ�ַ���
		response.getWriter().write(str);
	}
	
	@RequestMapping("/SelectSale")
	public void updateSale(int dailySaled,int inventory,int id,HttpServletResponse response) throws IOException {
		int flag = 0;
		flag = goodService.UpdateDailySaledServ(dailySaled, id);
		flag += goodService.UpdateInventoryServ(inventory, id);
		if(flag == 2) {
			response.getWriter().write("����ɹ�");
		}
	}
}
