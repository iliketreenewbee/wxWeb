package wxWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import wxWeb.domain.Coupon;
import wxWeb.service.CouponService;

@Controller
@RequestMapping("/PCCoupon")
public class CouponCtrl {
	@Autowired
	@Qualifier("CouponService")
	private CouponService couponService;
	
	@RequestMapping("/SelectAll")
	public String selectAllControl (Model model) {
		System.out.println("¿ªÊ¼²éÑ¯");
		List<Coupon> coupon_list = couponService.SelectAll();
		if(coupon_list.isEmpty()==false) {
			System.out.println(coupon_list.size());
		}
		model.addAttribute("coupon_list",coupon_list);
		return "success";
	}
	
	@RequestMapping("/Insert")
	public String insertCoupon(Model model,@RequestBody Coupon coupon) {
		int flag = 0;
		flag = couponService.InsertCouponServ(coupon.getDiscountMoney(), coupon.getDiscountType(), 
				coupon.getCondition(),  coupon.getSituation(),  coupon.getType(),  coupon.getFullMoney());
		if(flag == 1) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@RequestMapping("/Delete")
	public String deleteCoupon(String id) {
		int id_int = 0;
		int flag = 0;
		try {
		    id_int = Integer.parseInt(id);
		    flag = couponService.Delete(id_int);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		if(flag == 1) {
			return "success";
		}else {
			return "fail";
		}
	}
}
