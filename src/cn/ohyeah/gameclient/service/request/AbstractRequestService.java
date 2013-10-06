package cn.ohyeah.gameclient.service.request;

import io.netty.buffer.ByteBuf;
import cn.ohyeah.gameclient.global.Constant;
import cn.ohyeah.gameclient.global.HeadWrapper;
import cn.ohyeah.gameclient.message.Message;
import cn.ohyeah.gameclient.message.MessageQueue;
import cn.ohyeah.gameclient.message.Sender;


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
		Sender sender = Sender.getInstance();
		sender.sendMessage(buf);
	}
	
	/**
	 * 响应服务器请求
	 * @return
	 */
	protected Message response(){
		boolean hasMessage = false;
		Message msg = null;
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
}
