package cn.ohyeah.gameclient.response;

import io.netty.buffer.ByteBuf;
import cn.ohyeah.gameclient.global.Constant;
import cn.ohyeah.gameclient.global.HeadWrapper;
import cn.ohyeah.gameclient.global.IResponse;
import cn.ohyeah.gameclient.global.ProcessFrame;

public class DefaultResponse{
	
	private IResponse response;
	
	public void process(ProcessFrame frame){
		ByteBuf rsp = frame.getResponse();
		HeadWrapper head = new HeadWrapper(rsp.readInt());
		frame.setHead(head);
		switch (head.getTag()) {
		case Constant.PROTOCOL_TAG_SYS_SERV:
			response = new SystemResponse();
			response.process(frame);
			break;
		case Constant.PROTOCOL_TAG_USER_SERV:
			response = new UserResponse();
			response.process(frame);
			break;
		default:
			break;
		}
	}
}
