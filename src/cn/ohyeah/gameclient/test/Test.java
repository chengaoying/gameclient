package cn.ohyeah.gameclient.test;

import cn.ohyeah.gameclient.bootstrap.GameClient;
import cn.ohyeah.gameclient.message.ResultInfo;
import cn.ohyeah.gameclient.model.User;
import cn.ohyeah.gameclient.service.request.UserRequestService;

public class Test {
	
	public static void main(String args[]) {
		
		String host = "localhost";
		int port = 8090;
		GameClient.init(host, port);

		UserRequestService us = new UserRequestService();
		User user = new User();
		user.setName("jackey-3d33d");
		user.setPassword("123321");
		//user.setEmail("jackeychen100@gmail.com"); 
		//user.setArea("上海");
		//user.setTel("186****");
		 

		/* 
		 * 1、用户注册，返回boolean值，true为注册成功，false为注册失败
		 * boolean b = us.user_register(user);
		 */
		
		/*
		 * 2、用户登入，返回ResultInfo对象
		 */
		ResultInfo msg = us.user_login(user);
		System.out.println("msg.code=="+msg.getCode());
		
	}
}
