package wxWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import wxWeb.service.BuyerService;

@Controller
@RequestMapping("/WXBuyer")
public class WXBuyerCtrl {
	@Autowired
	@Qualifier("BuyerService")
	private BuyerService buyerService;
}
