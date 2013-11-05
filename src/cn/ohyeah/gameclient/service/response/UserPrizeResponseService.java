package cn.ohyeah.gameclient.service.response;

import io.netty.buffer.ByteBuf;
import cn.ohyeah.gameclient.global.Constant;
import cn.ohyeah.gameclient.global.HeadWrapper;
import cn.ohyeah.gameclient.global.ProcessFrame;
import cn.ohyeah.gameclient.message.MessageQueue;
import cn.ohyeah.gameclient.message.ResultMsg;
import cn.ohyeah.gameclient.util.BytesUtil;

public class UserPrizeResponseService implements IResponseService{

	@Override
	public void process(ProcessFrame frame) {
		HeadWrapper head = frame.getHead();
		switch (head.getCommand()) {
		case Constant.USER_PRIZE_RECORD_SAVE:
			save(frame);
			break;
		case Constant.USER_PRIZE_RECORD_LOAD:
			load(frame);
			break;
		default:
			break;
		}
	}

	private void load(ProcessFrame frame) {
		ByteBuf rsp = frame.getResponse();
		int code = rsp.readInt();
		String message = BytesUtil.readString(rsp);
		String data = BytesUtil.readString(rsp);
		ResultMsg msg = new ResultMsg();
		msg.setCode(code);
		msg.setMessage(message);
		msg.setData(data);
		MessageQueue.msgQueue.add(msg);
	}

	private void save(ProcessFrame frame) {
		ByteBuf rsp = frame.getResponse();
		int code = rsp.readInt();
		String message = BytesUtil.readString(rsp);
		String data = BytesUtil.readString(rsp);
		ResultMsg msg = new ResultMsg();
		msg.setCode(code);
		msg.setMessage(message);
		msg.setData(data);
		MessageQueue.msgQueue.add(msg);
	}

}
