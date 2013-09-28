package cn.ohyeah.gameclient.message;

import io.netty.channel.Channel;

public class MessageSender {
	
	//public static Queue<Message> msgQueue = new LinkedList<Message>();
	
	private Channel channel;
	
	private static MessageSender instance;
	
	private MessageSender(Channel channel){
		this.channel = channel;
	}
	
	public static void initMessageSender(Channel channel, int bufsize){
		if(channel == null){
			throw new RuntimeException("connection is already interrupt");
		}
		if(instance == null){
			instance = new MessageSender(channel);
		}
	}
	
	public static MessageSender getInstance(){
		return instance;
	}
	
	public void sendMessage(Object obj){
		channel.writeAndFlush(obj);
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
}
