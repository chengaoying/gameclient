package cn.ohyeah.gameclient.service.response;

import cn.ohyeah.gameclient.global.Constant;
import cn.ohyeah.gameclient.global.HeadWrapper;
import cn.ohyeah.gameclient.global.IResponse;
import cn.ohyeah.gameclient.global.ProcessFrame;
import cn.ohyeah.gameclient.service.request.SystemRequestService;

public class SystemResponseService implements IResponse {

	@Override
	public void process(ProcessFrame frame) {
		HeadWrapper head = frame.getHead();
		switch (head.getCommand()) {
		case Constant.SYS_SERV_BREAK_HREAT:
			SystemRequestService sr = new SystemRequestService();
			sr.sendBreakHeart();
			break;
		default:
			break;
		}
	}

}
