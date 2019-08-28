package wxWeb.service;

import java.util.List;

import wxWeb.domain.Order;

public interface OrderService {
	
	
	//��ѯ���ж���
	List<Order> SelectAllServ();
		
	//�������id��ѯ����
	List<Order> SelectWithBuyerIdServ(int buyerId);
		
	//���ݶ���״̬��ѯ����
	List<Order> SelectWithOrderSituationServ(String orderSituation);
		
	//��������,id������contactPhoneĬ�ϲ���
	int InsertOrderServ(String buyerName,int buyerId,String content,float totalPrice,String orderTime,
			String orderSituation,String sendTime,String address,String pickCode);
		
	//���¶���״̬
	int UpdateOrderSituationServ(int id,String orderSituation);
}
