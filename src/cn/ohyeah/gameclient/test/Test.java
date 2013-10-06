package cn.ohyeah.gameclient.test;

import cn.ohyeah.gameclient.bootstrap.GameClient;
import cn.ohyeah.gameclient.message.Message;
import cn.ohyeah.gameclient.message.MessageQueue;
import cn.ohyeah.gameclient.model.UserInfo;
import cn.ohyeah.gameclient.service.request.SystemRequestService;
import cn.ohyeah.gameclient.service.request.UserRequestService;

public class Test {
	
	public static void main(String args[]) {
		
		String host = "localhost";
		int port = 8090;
		GameClient.init(host, port);

		UserRequestService us = new UserRequestService();
		UserInfo user = new UserInfo();
		user.setName("jackey-3d33d");
		user.setPassword("123321");
		/*
		 * user.setEmail("jackeychen100@gmail.com"); 
		 * user.setArea("上海");
		 * user.setTel("186****");
		 */
		//boolean b = us.user_register(user);
		Message msg = us.user_login(user);
		System.out.println("msg.code=="+msg.getCode());
	}
}
