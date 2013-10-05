package cn.ohyeah.gameclient.test;

import cn.ohyeah.gameclient.bootstrap.GameClient;
import cn.ohyeah.gameclient.model.UserInfo;
import cn.ohyeah.gameclient.request.UserRequest;

public class Test {
	
	private boolean hasMessage;

	public static void main(String args[]) {
		
		String host = "localhost";
		int port = 8090;
		GameClient.init(host, port);

		UserRequest us = new UserRequest();
		UserInfo user = new UserInfo();
		user.setName("jackey-33");
		user.setPassword("123321");
		/*
		 * user.setEmail("jackeychen100@gmail.com"); user.setArea("上海");
		 * user.setTel("186****");
		 */
		us.user_register(user);

	}
}
