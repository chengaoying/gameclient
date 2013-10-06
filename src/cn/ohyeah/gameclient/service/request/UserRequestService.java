package cn.ohyeah.gameclient.service.request;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import cn.ohyeah.gameclient.bootstrap.GameClient;
import cn.ohyeah.gameclient.global.Constant;
import cn.ohyeah.gameclient.global.HeadWrapper;
import cn.ohyeah.gameclient.message.Message;
import cn.ohyeah.gameclient.message.Sender;
import cn.ohyeah.gameclient.model.UserInfo;

public class UserRequestService extends AbstractRequestService{
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public boolean user_register(UserInfo user){
		/**
		 * 向服务器发送请求
		 */
		HeadWrapper head = createHead(Constant.PROTOCOL_TAG_USER_SERV,Constant.USER_SERV_REGISTER);
		ByteBuf buf = Unpooled.buffer(256);
		buf.writeInt(head.getHead());   
		user.write(buf);
		request(buf);
		
		/**
		 * 接受服务器响应
		 */
		Message msg = response();
		
		return msg.getCode() == 0;
	}

	/**
	 * 用户登入
	 * @param user
	 * @return
	 */
	public Message user_login(UserInfo user){
		HeadWrapper head = createHead(Constant.PROTOCOL_TAG_USER_SERV,Constant.USER_SERV_LOGIN);
		ByteBuf buf = Unpooled.buffer(256);
		buf.writeInt(head.getHead());   
		user.write(buf);
		request(buf);
		
		Message msg = response();
		return msg;
	}
	
	/**
	 * 用户退出游戏，关闭连接
	 */
	public void user_logout(){
		try {
			Sender.getInstance().getChannel().closeFuture().sync();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}finally{
			GameClient.group.shutdownGracefully();
		}
	}
}
