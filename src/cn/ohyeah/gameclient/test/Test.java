package cn.ohyeah.gameclient.test;

import cn.ohyeah.gameclient.bootstrap.GameClient;
import cn.ohyeah.gameclient.message.PrizeMsg;
import cn.ohyeah.gameclient.message.ResultMsg;
import cn.ohyeah.gameclient.model.User;
import cn.ohyeah.gameclient.service.request.PrizeRequestService;
import cn.ohyeah.gameclient.service.request.RecordRequestService;
import cn.ohyeah.gameclient.service.request.UserRequestService;

public class Test {
	
	public static void main(String args[]) {
		
		//String host = "101.66.253.154";
		String host = "localhost";
		int port = 8090;
		GameClient.init(host, port);

		PrizeRequestService ps = new PrizeRequestService();
		UserRequestService us = new UserRequestService();
		RecordRequestService rs = new RecordRequestService();
		User user = new User();
		user.setName("jackey-3d33d");
		user.setPassword("123321");
		//user.setEmail("jackeychen100@gmail.com"); 
		//user.setArea("上海");
		//user.setTel("186****");
		 

		/* 
		 * 1、用户注册，返回boolean值，true为注册成功，false为注册失败
		 */
		/*boolean b = us.user_register(user);
		System.out.println(b);*/
		
		/*
		 * 2、用户登入，返回ResultInfo对象
		 */
		/*ResultMsg msg = us.user_login(user);
		System.out.println("msg.code=="+msg.getCode());*/
		
		/*
		 * 3、加载奖品信息
		 */
		//PrizeMsg info = ps.loadPrizes(1);
		
		/*
		 * 4、保存游戏记录 
		 */
		//ResultMsg msg = rs.save(3, "gamerecord");
		
		/*
		 *  5、读取游戏记录
		 */
		//ResultMsg msg = rs.load(2);
	}
}
