package cn.ohyeah.gameclient.service.request;

import io.netty.buffer.ByteBuf;
import cn.ohyeah.gameclient.bootstrap.GameClient;
import cn.ohyeah.gameclient.global.Constant;
import cn.ohyeah.gameclient.global.HeadWrapper;
import cn.ohyeah.gameclient.message.PrizeMsg;
import cn.ohyeah.gameclient.message.ResultMsg;
import cn.ohyeah.gameclient.message.MessageQueue;
import cn.ohyeah.gameclient.model.Prize;

public abstract class AbstractRequestService {

	protected HeadWrapper createHead(int tag,int cmd) {
        return new HeadWrapper.Builder().version(Constant.PROTOCOL_VERSION).type(1)
                .tag(tag).command(cmd).build();
    }
	
	/**
	 * 发送请求给服务器
	 * @param buf
	 */
	protected void request(ByteBuf buf){
		GameClient.Sender sender = GameClient.Sender.getInstance();
		sender.sendMessage(buf);
	}
	
	/**
	 * 响应服务器请求
	 * @return
	 */
	protected ResultMsg response(){
		boolean hasMessage = false;
		ResultMsg msg = null;
		while(!hasMessage){
			if(MessageQueue.hasMessage()){
				hasMessage = true;
				msg = MessageQueue.msgQueue.poll();
				System.out.println("code="+msg.getCode());
				System.out.println("message="+msg.getMessage());
				System.out.println("data="+msg.getData());
			}
			System.out.println();
		}
		return msg;
	}
	
	/**
	 * 响应服务器请求
	 * @return
	 */
	protected PrizeMsg response2(){
		boolean hasMessage = false;
		PrizeMsg msg = null;
		while(!hasMessage){
			if(MessageQueue.hasPrizeMsg()){
				hasMessage = true;
				msg = MessageQueue.PrizeMsgQueue.poll();
				System.out.println("code="+msg.getCode());
				System.out.println("message="+msg.getMessage());
				for(int i=0;i<msg.getPrizes().size();i++){
					Prize prize = msg.getPrizes().get(i);
					System.out.println("prize==>"+prize.getPicName());
				}
			}
			System.out.println();
		}
		return msg;
	}
}
