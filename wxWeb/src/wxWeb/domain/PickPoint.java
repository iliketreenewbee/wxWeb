package wxWeb.domain;

import java.io.Serializable;

public class PickPoint implements Serializable {
	
	private int id;            //id
	private String name;       //���������
	private String isValue;    //��ǰ������Ƿ���Ч
	
	
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
	public String getIsValue() {
		return isValue;
	}
	public void setIsValue(String isValue) {
		this.isValue = isValue;
	}
}
