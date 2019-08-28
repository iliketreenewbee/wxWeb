package wxWeb.service;

import java.util.List;

import wxWeb.domain.Buyer;

public interface BuyerService {
	
	//�������
	List<Buyer> SelectAll();
	
	//��¼��֤
	Buyer SelectLoginServ(String name,String password);
	
	//��¼��֤��ʽ2
	List<Buyer> SelectLoginWithNameServ(String name);
		
	//�������
	int InsertBuyerServ(String name,String password,String phone,String address,String level);
		
	//�޸�����
	int UpdatePasswordServ(int id,String password);
		
	//�޸�����
	int UpdateNameServ(int id,String name);
		
	//�޸ĵ�ַ
	int UpdateAddressServ(int id,String address);
			
	//�޸���ϵ�绰
	int UpdatePhoneServ(int id,String phone);
}
