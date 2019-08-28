package wxWeb.domain;

import java.io.Serializable;

public class Coupon implements Serializable {
	
	private int id;           //�Ż�ȯid
	private int buyerId;      //���id
	private float discountMoney;  //�Żݽ��
	private String discountType;   //�Ż���Ʒ������
	private String condition;  //ʹ������˵��
	private String situation;  //ʹ�����
	private String type;       //�Ż݄�����
	private float fullMoney;   //�����Ľ��
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public float getDiscountMoney() {
		return discountMoney;
	}
	public void setDiscountMoney(float discountMoney) {
		this.discountMoney = discountMoney;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getFullMoney() {
		return fullMoney;
	}
	public void setFullMoney(float fullMoney) {
		this.fullMoney = fullMoney;
	}
}
