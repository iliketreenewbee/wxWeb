package wxWeb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONArray;
import wxWeb.domain.PickPoint;
import wxWeb.service.PickPService;

@Controller
@RequestMapping("/WXPcikP")
public class WXPcikPCtrl {
	@Autowired
	@Qualifier("PickPService")
	private PickPService pickPService;
	
	@RequestMapping("/SelectAll")
	public void selectAll (HttpServletResponse response) throws IOException {
		List<PickPoint> pickP_list = pickPService.SelectAllv("true");
		JSONArray json = JSONArray.fromObject(pickP_list);
		String str = json.toString(); 
		response.getWriter().write(str);
	}
	
	@RequestMapping("/SelectWithKey")
	public void selectWithKey (HttpServletResponse response,String key) throws IOException {
		List<PickPoint> pickP_list = pickPService.SelectPickPointServ(key);
		JSONArray json = JSONArray.fromObject(pickP_list);
		String str = json.toString(); 
		response.getWriter().write(str);
	}
}
