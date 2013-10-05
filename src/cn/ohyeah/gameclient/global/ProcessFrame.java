package cn.ohyeah.gameclient.global;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

public class ProcessFrame {
    private ByteBuf response;
    private Channel channel;
    private HeadWrapper head;

    public HeadWrapper getHead() {
		return head;
	}

	public void setHead(HeadWrapper head) {
		this.head = head;
	}

	public ByteBuf getResponse() {
        return response;
    }

    public void setResponse(ByteBuf response) {
        this.response = response;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

}
