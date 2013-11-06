package cn.ohyeah.gameclient.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class LoadResourcesHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		/*Object o = ctx.channel().read();
		System.out.println("--读取数据--");
		System.out.println(o);
		System.out.println(msg);
		if(o == null){ */
			ctx.fireChannelRead(msg);
		//}
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.fireChannelActive();
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		ctx.fireChannelInactive();
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.fireChannelReadComplete();
	}

}
