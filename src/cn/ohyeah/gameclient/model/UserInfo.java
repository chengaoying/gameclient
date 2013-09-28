package cn.ohyeah.gameclient.model;

import cn.ohyeah.gameclient.util.BytesUtil;
import io.netty.buffer.ByteBuf;


public class UserInfo{

	private String name;

	private String password;

	private String tel;

	private String email;

	private String area;

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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void write(ByteBuf buff){
		BytesUtil.writeString(buff, name);
		BytesUtil.writeString(buff, password);
		BytesUtil.writeString(buff, tel);
		BytesUtil.writeString(buff, email);
		BytesUtil.writeString(buff, area);
	}
	
	public UserInfo read(ByteBuf buff){
		UserInfo user = new UserInfo();
		user.setName(BytesUtil.readString(buff));
		user.setPassword(BytesUtil.readString(buff));
		user.setTel(BytesUtil.readString(buff));
		user.setEmail(BytesUtil.readString(buff));
		user.setArea(BytesUtil.readString(buff));
		return user;
	}
}
