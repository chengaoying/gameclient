package cn.ohyeah.gameclient.service.request;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import cn.ohyeah.gameclient.global.Constant;
import cn.ohyeah.gameclient.global.HeadWrapper;

public class SystemRequestService extends AbstractRequestService {

	/**
	 * 发送心跳包方法，系统自动调用
	 */
	public void sendBreakHeart(){
		HeadWrapper head = createHead(Constant.PROTOCOL_TAG_SYS_SERV,Constant.SYS_SERV_BREAK_HREAT);
		ByteBuf buf = Unpooled.buffer(256);
		buf.writeInt(head.getHead());   
		request(buf);
	}
}
