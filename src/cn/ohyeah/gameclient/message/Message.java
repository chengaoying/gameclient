package cn.ohyeah.gameclient.message;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class Message {
	
	private int type;
	
	private ByteBuf byteBuf;
	
	public Message(int size){
		byteBuf = Unpooled.buffer(size);
	}

	public ByteBuf getByteBuf() {
		return byteBuf;
	}

	public void setByteBuf(ByteBuf byteBuf) {
		this.byteBuf = byteBuf;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
