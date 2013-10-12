package cn.ohyeah.gameclient.model;

public class Prize {

	private int prizeid;
	
	private int productid;
	
	private String name;
	
	private int price;
	
	private String imagePath;
	
	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public void setPrizeid(int prizeid) {
		this.prizeid = prizeid;
	}

	public int getPrizeid() {
		return prizeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
