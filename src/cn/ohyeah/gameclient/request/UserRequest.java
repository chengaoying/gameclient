package cn.ohyeah.gameclient.request;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import cn.ohyeah.gameclient.global.Constant;
import cn.ohyeah.gameclient.global.HeadWrapper;
import cn.ohyeah.gameclient.message.Sender;
import cn.ohyeah.gameclient.model.UserInfo;

public class UserRequest extends AbstractRequest{
	
	public void user_register(UserInfo user){
		HeadWrapper head = createHead(Constant.USER_SERV_REGISTER);
		Sender sender = Sender.getInstance();
		ByteBuf buf = Unpooled.buffer(256);
		buf.writeInt(head.getHead());   
		user.write(buf);
		sender.sendMessage(buf);
	}

}
