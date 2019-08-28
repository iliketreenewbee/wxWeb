package wxWeb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONArray;
import wxWeb.domain.Coupon;
import wxWeb.service.CouponService;

@Controller
@RequestMapping("/WXCoupon")
public class WXCouponCtrl {
	@Autowired
	@Qualifier("CouponService")
	private CouponService couponService;
	
	@RequestMapping("/SelectWithBuyerId")
	public void selectAllControl (int buyerId,HttpServletResponse response) throws IOException {
		System.out.println("¿ªÊ¼²éÑ¯");
		List<Coupon> coupon_list = couponService.SelectCouponWithBuyerServ(buyerId);
		if(coupon_list.isEmpty()==false) {
			System.out.println(coupon_list.size());
		}
		JSONArray json = JSONArray.fromObject(coupon_list);
		String str = json.toString(); 
		response.getWriter().write(str);
	}
	
}
