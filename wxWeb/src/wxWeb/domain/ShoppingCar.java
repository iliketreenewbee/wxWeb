package wxWeb.domain;

import java.io.Serializable;

public class ShoppingCar implements Serializable{
	
	private int buyerId;     //���id��Ϊ���ﳵid
	private String content;  //���ﳵ���ݣ����ַ����洢��Ʒ
	
	
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
