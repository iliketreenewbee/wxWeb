package wxWeb.domain;

import java.io.Serializable;

public class Good implements Serializable {
	
	private int id;           //��Ʒid
	private String name;      //��Ʒ����
	private String pictrue;   //��ƷͼƬ·��
	private float price;      //�۸�
	private float discount;   //�ۿ�
	private float newPrice;   //���¼۸�
	private String detail;    //����
	private String hot;       //�ȶ�
	private String type;      //����
	private int inventory;    //���
	private int dailySaled;   //����
	private String isVlaue;   //��Ʒ�Ƿ��ϼ�
	private String salePlace; //�ܹ���������Ʒ�ĵص�
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPictrue() {
		return pictrue;
	}
	public void setPictrue(String pictrue) {
		this.pictrue = pictrue;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(float newPrice) {
		this.newPrice = newPrice;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getHot() {
		return hot;
	}
	public void setHot(String hot) {
		this.hot = hot;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public int getDailySaled() {
		return dailySaled;
	}
	public void setDailySaled(int dailySaled) {
		this.dailySaled = dailySaled;
	}
	public String getIsVlaue() {
		return isVlaue;
	}
	public void setIsVlaue(String isVlaue) {
		this.isVlaue = isVlaue;
	}
	public String getSalePlace() {
		return salePlace;
	}
	public void setSalePlace(String salePlace) {
		this.salePlace = salePlace;
	}
	
}
