package cn.ohyeah.gameclient.service.request;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import cn.ohyeah.gameclient.global.Constant;
import cn.ohyeah.gameclient.global.HeadWrapper;
import cn.ohyeah.gameclient.message.PrizeMsg;

/**
 * 奖品服务类
 * @author Administrator
 *
 */
public class PrizeRequestService extends AbstractRequestService{

	/**
	 * 加载奖品资源
	 * @param activityid
	 * @return
	 */
	public PrizeMsg loadPrizes(int activityid){
		HeadWrapper head = createHead(Constant.PROTOCOL_TAG_PRIZE_SERV,Constant.PRIZE_SERV_LOAD_INFO);
		ByteBuf buf = Unpooled.buffer(256);
		buf.writeInt(head.getHead()); 
		buf.writeInt(activityid);
		request(buf);
		
		/**
		 * 接受服务器响应
		 */
		PrizeMsg msg = response2();
		
		return msg;
	}
}
