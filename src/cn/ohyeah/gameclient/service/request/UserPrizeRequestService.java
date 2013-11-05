package cn.ohyeah.gameclient.service.request;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import cn.ohyeah.gameclient.global.Constant;
import cn.ohyeah.gameclient.global.HeadWrapper;
import cn.ohyeah.gameclient.message.ResultMsg;

public class UserPrizeRequestService extends AbstractRequestService{

	/**
	 * 保存用户中奖记录
	 * @param userid	用户id
	 * @param prizeid	奖品id
	 * @return
	 */
	public ResultMsg save(int userid, int prizeid){
		HeadWrapper head = createHead(Constant.PROTOCOL_TAG_USER_PRIZE_RECORD,Constant.USER_PRIZE_RECORD_SAVE);
		ByteBuf buf = Unpooled.buffer(256);
		buf.writeInt(head.getHead()); 
		buf.writeInt(userid);
		buf.writeInt(prizeid);
		request(buf);
		
		ResultMsg msg = response();
		
		return msg;
	}
	
	/**
	 * 读取用户中奖记录
	 * @param userid
	 * @return
	 */
	public ResultMsg load(int userid){
		HeadWrapper head = createHead(Constant.PROTOCOL_TAG_USER_PRIZE_RECORD,Constant.USER_PRIZE_RECORD_LOAD);
		ByteBuf buf = Unpooled.buffer(256);
		buf.writeInt(head.getHead()); 
		buf.writeInt(userid);
		request(buf);
		
		ResultMsg msg = response();
		
		return msg;
	}
}
