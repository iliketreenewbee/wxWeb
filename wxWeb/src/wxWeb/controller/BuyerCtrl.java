package wxWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import wxWeb.domain.Buyer;
import wxWeb.service.BuyerService;

@Controller
@RequestMapping("/PCBuyer")
public class BuyerCtrl {
	@Autowired
	@Qualifier("BuyerService")
	private BuyerService buyerService;
	
	@RequestMapping("/SelectAll")
	public String selectAll (Model model) {
		System.out.println("¿ªÊ¼²éÑ¯");
		List<Buyer> buyer_list = buyerService.SelectAll();
		if(buyer_list.isEmpty()==false) {
			System.out.println(buyer_list.size());
		}
		model.addAttribute("buyer_list",buyer_list);
		return "success";
	}
}
