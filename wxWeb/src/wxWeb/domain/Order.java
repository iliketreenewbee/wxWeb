package wxWeb.domain;

import java.io.Serializable;

public class Order implements Serializable {
	
	private int id;                 //����id
	private int buyerId;            //���id
	private String buyerName;       //�������
	private String content;         //��������
	private float totalPrice;       //�����ܼ�
	private String orderTime;       //�µ�ʱ��
	private String orderSituation;  //����״̬
	private String sendTime;        //�ͻ�ʱ���
	private String address;         //�ͻ���ַ
	private String cntactPhone;     //��ϵ�绰
	private String pickCode;        //ȡ����
	
	
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
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderSituation() {
		return orderSituation;
	}
	public void setOrderSituation(String orderSituation) {
		this.orderSituation = orderSituation;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCntactPhone() {
		return cntactPhone;
	}
	public void setCntactPhone(String cntactPhone) {
		this.cntactPhone = cntactPhone;
	}
	public String getPickCode() {
		return pickCode;
	}
	public void setPickCode(String pickCode) {
		this.pickCode = pickCode;
	}
	
	
}
