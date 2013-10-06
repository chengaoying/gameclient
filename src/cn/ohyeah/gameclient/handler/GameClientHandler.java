/*
 * 
 */
package cn.ohyeah.gameclient.handler;

import java.util.logging.Logger;

import cn.ohyeah.gameclient.global.ProcessFrame;
import cn.ohyeah.gameclient.service.response.DefaultResponseService;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class GameClientHandler extends ChannelInboundHandlerAdapter {

	private static Logger logger = Logger.getLogger(GameClientHandler.class.getName());
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf)msg;
		ProcessFrame frame = new ProcessFrame();
		frame.setChannel(ctx.channel());
		frame.setResponse(buf);
		DefaultResponseService rsp = new DefaultResponseService();
		rsp.process(frame);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		super.channelReadComplete(ctx);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("client active");
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.info("client inactive");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)throws Exception {
		logger.warning("client exception==>"+cause);
	}

}
