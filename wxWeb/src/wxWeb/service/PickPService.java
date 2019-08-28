package wxWeb.service;

import java.util.List;

import wxWeb.domain.PickPoint;

public interface PickPService {
	
	//��ѯ��Ч�����
	List<PickPoint> SelectAllv(String isValue);
		
	//ģ����ѯ��Ч�����
	List<PickPoint> SelectPickPointServ(String key);
		
	//���������
	int InsertPickPointServ(String name);
		
	//�޸������
	int UpdatePickPointServ(int id,String name);
		
	//ɾ������㣺��isValue��Ϊflase
	int UpdatePickPointValueServ(int id,String isValue);
		
	//����ɾ�������
	int DeletePickPointServ(int id);
}
