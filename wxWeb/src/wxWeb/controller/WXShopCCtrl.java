package wxWeb.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import wxWeb.domain.ShoppingCar;
import wxWeb.service.ShopCService;

@Controller
@RequestMapping("/WXShopC")
public class WXShopCCtrl {
	@Autowired
	@Qualifier("ShopCService")
	private ShopCService shopCService;
	
	@RequestMapping("/SelectWithBuyerId")
	public void selectWithBuyerid(int BuyerId,HttpServletResponse response) throws IOException {	
		ShoppingCar shopC = shopCService.SelectShopCServ(BuyerId);
		JSONArray json = JSONArray.fromObject(shopC);
		String str = json.toString(); 
		response.getWriter().write(str);
	}
	
	@RequestMapping("/UpdateShopC")
	public void updateShopC(int BuyerId,String content,HttpServletResponse response) throws IOException {
		int flag = shopCService.UpdateShopCServ(BuyerId, content);
		if(flag == 1) {
			response.getWriter().write("更新成功");
		}else {
			response.getWriter().write("更新失败");
		}
	}
}
