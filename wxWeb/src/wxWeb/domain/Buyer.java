package wxWeb.domain;

import java.io.Serializable;

public class Buyer implements Serializable {
	
	private int id;        //���id
	private String name;   //�������
	private String password; //����
	private String phone;  //��ҵ绰
	private String address;//��ҵ�ַ
	private String level;  //�ȼ�
	
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	
}
