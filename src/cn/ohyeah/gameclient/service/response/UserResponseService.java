package cn.ohyeah.gameclient.service.response;

import io.netty.buffer.ByteBuf;
import cn.ohyeah.gameclient.global.Constant;
import cn.ohyeah.gameclient.global.HeadWrapper;
import cn.ohyeah.gameclient.global.IResponse;
import cn.ohyeah.gameclient.global.ProcessFrame;
import cn.ohyeah.gameclient.message.Message;
import cn.ohyeah.gameclient.message.MessageQueue;
import cn.ohyeah.gameclient.util.BytesUtil;

public class UserResponseService implements IResponse {

	@Override
	public void process(ProcessFrame frame) {
		HeadWrapper head = frame.getHead();
		switch (head.getCommand()) {
		case Constant.USER_SERV_REGISTER:
			userRegister(frame);
			break;
		case Constant.USER_SERV_LOGIN:
			useLogin(frame);
			break;
		default:
			break;
		}
	}
	
	private void useLogin(ProcessFrame frame) {
		ByteBuf rsp = frame.getResponse();
		int code = rsp.readInt();
		String message = BytesUtil.readString(rsp);
		String data = BytesUtil.readString(rsp);
		Message msg = new Message();
		msg.setCode(code);
		msg.setMessage(message);
		msg.setData(data);
		MessageQueue.msgQueue.add(msg);
	}

	private void userRegister(ProcessFrame frame){
		ByteBuf rsp = frame.getResponse();
		int code = rsp.readInt();
		String message = BytesUtil.readString(rsp);
		String data = BytesUtil.readString(rsp);
		Message msg = new Message();
		msg.setCode(code);
		msg.setMessage(message);
		msg.setData(data);
		MessageQueue.msgQueue.add(msg);
	}

}
