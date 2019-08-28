package wxWeb.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONArray;
import wxWeb.domain.Good;
import wxWeb.domain.Order;
import wxWeb.service.GoodService;
import wxWeb.service.OrderService;

@Controller
@RequestMapping("/WXOrder")
public class WXOrderCtrl {
	@Autowired
	@Qualifier("OrderService")
	private OrderService orderService;
	
	@Autowired
	@Qualifier("GoodService")
	private GoodService goodService;
	
	@RequestMapping("/SelectAll")
	public void selectAllControl (HttpServletResponse response) throws IOException {
		System.out.println("开始查询");
		List<Order> order_list = orderService.SelectAllServ();
		if(order_list.isEmpty()==false) {
			System.out.println(order_list.size());
		}
		JSONArray json = JSONArray.fromObject(order_list);
		String str = json.toString(); 
		response.getWriter().write(str);
	}
	
	@RequestMapping("/SelectWithBuyerId")
	public void selectWithBuyerId(int buyerId,HttpServletResponse response) throws IOException {
		List<Order> order_list = orderService.SelectWithBuyerIdServ(buyerId);
		JSONArray json = JSONArray.fromObject(order_list);
		String str = json.toString(); 
		response.getWriter().write(str);
	}
	
	@RequestMapping("/SelectWithSituation")
	public void selectWithSituation(String orderSituation,HttpServletResponse response) throws IOException {
		List<Order> order_list = orderService.SelectWithOrderSituationServ(orderSituation);
		JSONArray json = JSONArray.fromObject(order_list);
		String str = json.toString(); 
		response.getWriter().write(str);
	}
	
	@RequestMapping("/InsertOrder") 
	public void insertOrder(HttpServletRequest request,@RequestBody Order order,HttpServletResponse response) throws IOException { 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String orderTime = sdf.format(new Date().getTime()); 
		String pickCode = null;
		//生成随机提货码
		Random random = new Random();
        for ( int i = 0; i < 6; i++ )
        {
            String str = random.nextInt( 2 ) % 2 == 0 ? "num" : "char";
            if ( "char".equalsIgnoreCase( str ) )
            { // 产生字母
                pickCode += (char) ( 65 + random.nextInt( 26 ) );
            }
            else if ( "num".equalsIgnoreCase( str ) )
            { // 产生数字
            	pickCode += String.valueOf( random.nextInt( 10 ) );
            }
        }
        System.out.println("生成随机提货码："+pickCode);
		int flag = orderService.InsertOrderServ(order.getBuyerName(), order.getBuyerId(), order.getContent(), order.getTotalPrice(),
				orderTime, order.getOrderSituation(), "", order.getAddress(), pickCode);
		if(flag == 1) {
			String temp[] = order.getContent().split(";");
			for(int i=0;i<temp.length;i++) {
				String goodInfo[] = temp[i].split(",");
				try {
				    int id_int = Integer.parseInt(goodInfo[0]);
				    int count_int = Integer.parseInt(goodInfo[1]);
				    Good good = goodService.selectWithIdServ(id_int);
				    int inventory = good.getInventory()-count_int;
				    int flag2 = goodService.UpdateInventoryServ(inventory, id_int);
				    if(flag2 == 1) {
				    	response.getWriter().write("下单成功");
				    }
				} catch (NumberFormatException e) {
				    e.printStackTrace();
				}
			}
		}
	}
	
	@RequestMapping("/UpdateSituation")
	public void updateSituation(String orderSituation,int id,HttpServletResponse response) throws IOException {
		int flag = orderService.UpdateOrderSituationServ(id, orderSituation);
		if(flag == 1) {
			response.getWriter().write("更新成功");
		}
	}
	
	//json测试，有错误
	@RequestMapping("/ccc")
	public void ir(HttpServletRequest request,@RequestBody Order order,HttpServletResponse response) throws IOException {
		System.out.println(order.getBuyerName());
	}
}
