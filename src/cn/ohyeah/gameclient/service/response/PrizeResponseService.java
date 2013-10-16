package cn.ohyeah.gameclient.service.response;

import java.util.ArrayList;
import java.util.List;

import io.netty.buffer.ByteBuf;
import cn.ohyeah.gameclient.global.Constant;
import cn.ohyeah.gameclient.global.HeadWrapper;
import cn.ohyeah.gameclient.global.ProcessFrame;
import cn.ohyeah.gameclient.message.MessageQueue;
import cn.ohyeah.gameclient.message.PrizeMsg;
import cn.ohyeah.gameclient.model.Prize;
import cn.ohyeah.gameclient.util.BytesUtil;

public class PrizeResponseService implements IResponseService{

	@Override
	public void process(ProcessFrame frame) {
		HeadWrapper head = frame.getHead();
		switch (head.getCommand()) {
		case Constant.PRIZE_SERV_LOAD_INFO:
			loadPrizes(frame);
			break;
		default:
			break;
		}
	}

	private void loadPrizes(ProcessFrame frame) {
		ByteBuf rsp = frame.getResponse();
		System.out.println("client byteBuf.size==>"+rsp.capacity());
		int code = rsp.readInt();
		String message = BytesUtil.readString(rsp);
		PrizeMsg msg = new PrizeMsg();
		msg.setCode(code);
		msg.setMessage(message);
		int nodesize = rsp.readInt();
		List<Prize> list = new ArrayList<Prize>();
		for(int i=0;i<nodesize;i++){
			Prize prize = new Prize();
			prize.setActivityid(Integer.parseInt(BytesUtil.readString(rsp)));
			prize.setPrice(Integer.parseInt(BytesUtil.readString(rsp)));
			prize.setProductid(Integer.parseInt(BytesUtil.readString(rsp)));
			prize.setName(BytesUtil.readString(rsp));
			prize.setPicName(BytesUtil.readString(rsp));
			byte[] bytes = new byte[rsp.readableBytes()];
			while(rsp.readBoolean()){
				bytes[rsp.readerIndex()] = rsp.readByte();
			}
			prize.setBytes(bytes);
			list.add(prize);
		}
		msg.setPrizes(list);
		MessageQueue.PrizeMsgQueue.add(msg);
	}

}
