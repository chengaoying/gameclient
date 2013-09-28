package cn.ohyeah.gameclient.test;

import cn.ohyeah.gameclient.bootstrap.GameClient;
import cn.ohyeah.gameclient.model.UserInfo;
import cn.ohyeah.gameclient.service.UserService;

public class Test {

	public static void main(String args[]){
		String host = "localhost";
		int port = 8090;
		GameClient.init(host, port);
		int i = 0;
		//while(true){
			UserService us = new UserService();
			UserInfo user = new UserInfo();
			user.setName("jackey-33");
			user.setPassword("123321");
			/*user.setEmail("jackeychen100@gmail.com");
			user.setArea("上海");
			user.setTel("186****");*/
			us.user_register(user);
			try {
				Thread.sleep(3000);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//}
	}
}
