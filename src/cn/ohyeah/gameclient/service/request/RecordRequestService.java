package cn.ohyeah.gameclient.service.request;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import cn.ohyeah.gameclient.global.Constant;
import cn.ohyeah.gameclient.global.HeadWrapper;
import cn.ohyeah.gameclient.message.ResultMsg;
import cn.ohyeah.gameclient.util.BytesUtil;

public class RecordRequestService extends AbstractRequestService{

	/**
	 * 保存游戏记录
	 * @param recordindex 游戏记录索引
	 * @param data 游戏记录数据（长度不大于1000个字符）
	 */
	public ResultMsg save(int recordindex, String data){
		HeadWrapper head = createHead(Constant.PROTOCOL_TAG_RECORD_SERV,Constant.RECORD_SERV_SAVE);
		ByteBuf buf = Unpooled.buffer(128 + data.length());
		buf.writeInt(head.getHead()); 
		buf.writeInt(recordindex);
		BytesUtil.writeString(buf, data);
		request(buf);
		
		ResultMsg msg = response();
		return msg;
	}
	
	/**
	 * 读取游戏记录
	 * @param recordindex 游戏记录索引
	 * @return
	 */
	public ResultMsg load(int recordindex){
		HeadWrapper head = createHead(Constant.PROTOCOL_TAG_RECORD_SERV,Constant.RECORD_SERV_LOAD);
		ByteBuf buf = Unpooled.buffer(256);
		buf.writeInt(head.getHead()); 
		buf.writeInt(recordindex);
		request(buf);
		
		ResultMsg msg = response();
		return msg;
	}
}
