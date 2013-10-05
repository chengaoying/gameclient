package cn.ohyeah.gameclient.message;


import io.netty.channel.Channel;

public class Sender {
	
	private Channel channel;
	
	private static Sender instance;
	
	private Sender(Channel channel){
		this.channel = channel;
	}
	
	public static void initMessageSender(Channel channel, int bufsize){
		if(channel == null){
			throw new RuntimeException("connection is already interrupt");
		}
		if(instance == null){
			instance = new Sender(channel);
		}
	}
	
	public static Sender getInstance(){
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
