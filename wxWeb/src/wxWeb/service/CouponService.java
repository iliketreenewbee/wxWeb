package wxWeb.service;

import java.util.List;

import wxWeb.domain.Coupon;

public interface CouponService {
	
	//��ѯ�����Ż�ȯ
	List<Coupon> SelectAll();
	
	//�����û���ѯ�Ż�ȯ
	List<Coupon> SelectCouponWithBuyerServ(int buyerId);
		
	//�����Ż�ȯ
	int InsertCouponServ(float discountMoney,String discountType,String condition,
			String situation,String type,float fullMoney);
		
	//�޸��Ż�ȯʹ�����
	int UpdateSituationServ(int id,String situation);
		
	//��������ѯ�Ż�ȯ
	List<Coupon> SelectWitnTypeServ(String type);
		
	//�����Ż�����ѯ�Ż�ȯ
	List<Coupon> SelectWitnDiscountTypeServ(String discountType);
	
	//ɾ���Ż�ȯ
	int Delete(int id);
}
