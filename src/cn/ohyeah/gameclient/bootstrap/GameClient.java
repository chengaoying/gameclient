package cn.ohyeah.gameclient.bootstrap;

import cn.ohyeah.gameclient.handler.GameClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 客户端通讯层启动类
 * @author xiao chen
 *
 */
public class GameClient {
	private static String host;
	private static int port;
	
	public static EventLoopGroup group;
	public static Channel channel;
	
	public static void init(String host, int port){
		if(host.equals("") || host == null){
			throw new RuntimeException("Game server host is invalid");
		}
		if(port <= 0){
			throw new RuntimeException("Game server port is invalid");
		}
		
		GameClient.host = host;
		GameClient.port = port;
		
		Sender.initMessageSender(getChannel(),256);
	}

	private static Bootstrap getBootstrap() {
		group = new NioEventLoopGroup();
		Bootstrap b = new Bootstrap();
		b.group(group).channel(NioSocketChannel.class)
				.option(ChannelOption.TCP_NODELAY, true)
				.handler(new ChannelInitializer<SocketChannel>() {
					@Override
					public void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast(
								//new StringEncoder(),
								//new StringDecoder(), 
								new ChunkedWriteHandler(),
								//new LoadResourcesHandler(),
								new GameClientHandler()
								);
					}
				});

		return b;
	}
	
	private static Channel getChannel(){
		try {
			channel = getBootstrap().connect(host, port).sync().channel();
		} catch (Exception e) {
			return null;
		}
		return channel;
	}
	
	public static class Sender {
		
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
	}
}
