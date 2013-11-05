package cn.ohyeah.gameclient.service.response;

import io.netty.buffer.ByteBuf;
import cn.ohyeah.gameclient.global.Constant;
import cn.ohyeah.gameclient.global.HeadWrapper;
import cn.ohyeah.gameclient.global.ProcessFrame;
import cn.ohyeah.gameclient.message.MessageQueue;
import cn.ohyeah.gameclient.message.Notice;
import cn.ohyeah.gameclient.service.request.SystemRequestService;
import cn.ohyeah.gameclient.util.BytesUtil;

public class SystemResponseService implements IResponseService {

	@Override
	public void process(ProcessFrame frame) {
		HeadWrapper head = frame.getHead();
		switch (head.getCommand()) {
		case Constant.SYS_SERV_BREAK_HREAT:
			SystemRequestService sr = new SystemRequestService();
			sr.sendBreakHeart();
			break;
		case Constant.SYS_SERV_NOTICE:
			receiveNotice(frame);
			break;
		default:
			break;
		}
	}

	private void receiveNotice(ProcessFrame frame) {
		ByteBuf rsp = frame.getResponse();
		Notice notice = new Notice();
		String msg = BytesUtil.readString(rsp);
		notice.setContent(msg);
		MessageQueue.noticeQueue.add(notice);
		System.out.println("用户中奖信息==>"+msg);
	}

}
