package cn.ohyeah.gameclient.model;

import io.netty.buffer.ByteBuf;

public class Prize {

	private int prizeid;
	
	private String name;
	
	private int productid;
	
	private int price;
	
	private int activityid;
	
	private String picName;
	
	private ByteBuf bytes;

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public int getPrizeid() {
		return prizeid;
	}

	public void setPrizeid(int prizeid) {
		this.prizeid = prizeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getActivityid() {
		return activityid;
	}

	public void setActivityid(int activityid) {
		this.activityid = activityid;
	}

	public ByteBuf getBytes() {
		return bytes;
	}

	public void setBytes(ByteBuf bytes) {
		this.bytes = bytes;
	}
	
}
