package wxWeb.service;

import java.util.List;

import wxWeb.domain.Good;

public interface GoodService {
	
	//��ѯ������Ʒ
	List<Good> selectAllServ ();	
	
	//����id��ѯ��Ʒ
	Good selectWithIdServ (int id);	
	
	//����ɾ����Ʒ
	int DeleteGoodServ(int id);	
	
	//ģ����ѯ���ɲ�ѯ��Ʒ���������������ı���
	List<Good> SelectWithKeyServ(String key);	
	
	//������Ʒ
	int InsertGoodServ(String name,String pictrue,float price,float discount,float newPrice,String detail,
			String hot,String type,int inventory,int dailySaled,String isValue,String salePlace);
	
	//������Ʒ�۸�
	int UpdatePriceServ(float price,float newPrice,float discount,int id);	
	
	//������Ʒ���
	int UpdateInventoryServ(int inventory,int id);
	
	//������Ʒ������
	int UpdateDailySaledServ(int dailySaled,int id);
	
	//�޸���Ʒ����
	int UpdateTypeServ(String type,int id);
	
	//�޸���Ʒ����
    int UpdateNameServ(String name,int id);
    
    //�޸���Ʒ����
  	int UpdateDetailServ(String Detail,int id);
  	
    //������Ʒ�ȶ�
  	int UpdateHotServ(String hot,int id);
  	
    //������Ʒ���¼�
  	int UpdateIsValueServ(String isValue,int id);
}
