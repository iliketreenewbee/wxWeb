package wxWeb.service;

import wxWeb.domain.ShoppingCar;

public interface ShopCService {
	
	
	//�������ﳵ��ÿ���û�һ�����ﳵ
	int InsertShopCServ(int buyerId);
		
	//���¹��ﳵ�������Ʒ
	int UpdateShopCServ(int buyerId,String content);
		
	//���ҹ��ﳵ
	ShoppingCar SelectShopCServ(int buyerId);
}
