package wxWeb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import wxWeb.domain.Buyer;
import wxWeb.service.BuyerService;

public class LoginController {
	
	//�Զ�ע��BuyerService
	@Autowired
	private BuyerService buyerService;
	
	//����Ա��¼
	@RequestMapping
	public String UserLogin(String name,String password,HttpServletRequest request) {
		Buyer User = buyerService.SelectLoginServ(name, password);
		if(User != null) {
			if(User.getLevel().equals("����Ա") ) {
				request.setAttribute("massage", "���˺Ų��ǹ���Ա�����������룡");
				return "success";
			}else {
				request.setAttribute("massage", "���˺Ų��ǹ���Ա�����������룡");
				return "fail";
			}
		}else {
			request.setAttribute("massage", "�˺������벻ƥ�䣬���������룡");
			return "fail";
		}
	}
}
