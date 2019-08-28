package wxWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import wxWeb.domain.PickPoint;
import wxWeb.service.PickPService;

@Controller
@RequestMapping("/PCPickP")
public class PickPointCtrl {
	@Autowired
	@Qualifier("PickPService")
	private PickPService pickPService;
	
	@RequestMapping("/SelectAll")
	public String selectAll (Model model) {
		System.out.println("¿ªÊ¼²éÑ¯");
		List<PickPoint> pickP_list = pickPService.SelectAllv("true");
		if(pickP_list.isEmpty()==false) {
			System.out.println(pickP_list.size());
		}
		model.addAttribute("pickP_list",pickP_list);
		return "success";
	}
	
	@RequestMapping("/SelectWithKey")
	public String selectWithKey(Model model,String key) {
		List<PickPoint> pickP_list = pickPService.SelectPickPointServ(key);
		if(pickP_list.isEmpty()==false) {
			System.out.println(pickP_list.size());
		}
		model.addAttribute("pickP_list",pickP_list);
		return "success";
	}
	
	@RequestMapping("/InsertPickP")
	public String insertPcikP(String name,Model model) {
		int flag = pickPService.InsertPickPointServ(name);
		if(flag == 1) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@RequestMapping("/UpdateName")
	public String updateName(String id,String name) {
		int id_int = 0;
		int flag = 0;
		try {
		    id_int = Integer.parseInt(id);
		    flag = pickPService.UpdatePickPointServ(id_int, name);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		if(flag == 1) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@RequestMapping("/ClosePickP")
	public String closePickP(String id,String isValue) {
		int id_int = 0;
		int flag = 0;
		try {
		    id_int = Integer.parseInt(id);
		    flag = pickPService.UpdatePickPointValueServ(id_int, isValue);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		if(flag == 1) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@RequestMapping("/DeletePcikP")
	public String deletePcikP(String id) {
		int id_int = 0;
		int flag = 0;
		try {
		    id_int = Integer.parseInt(id);
		    flag = pickPService.DeletePickPointServ(id_int);
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
