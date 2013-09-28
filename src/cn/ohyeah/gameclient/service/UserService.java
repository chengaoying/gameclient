package cn.ohyeah.gameclient.service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import cn.ohyeah.gameclient.message.MessageSender;
import cn.ohyeah.gameclient.model.UserInfo;
import cn.ohyeah.gameclient.protocol.Constant;
import cn.ohyeah.gameclient.protocol.HeadWrapper;

public class UserService {
	
	private HeadWrapper createHead(int cmd) {
        return new HeadWrapper.Builder().version(Constant.PROTOCOL_VERSION).type(1)
                .tag(Constant.PROTOCOL_TAG_USER_SERV).command(cmd).build();
    }
	
	public void user_register(UserInfo user){
		HeadWrapper head = createHead(Constant.USER_SERV_REGISTER);
		MessageSender sender = MessageSender.getInstance();
		ByteBuf buf = Unpooled.buffer(256);
		buf.writeInt(head.getHead());   
		user.write(buf);
		sender.sendMessage(buf);
	}

}
