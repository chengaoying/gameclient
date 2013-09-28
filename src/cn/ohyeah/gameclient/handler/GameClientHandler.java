/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package cn.ohyeah.gameclient.handler;

import java.util.logging.Logger;

import cn.ohyeah.gameclient.protocol.HeadWrapper;
import cn.ohyeah.gameclient.util.BytesUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class GameClientHandler extends ChannelInboundHandlerAdapter {

	private static Logger logger = Logger.getLogger(GameClientHandler.class.getName());
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf)msg;
		int head = buf.readInt();
		HeadWrapper headWrapper = new HeadWrapper(head);
		int code = buf.readInt();
		String message = BytesUtil.readString(buf);
		String data = BytesUtil.readString(buf);
		System.out.println("client head:"+head);
		System.out.println("client code:"+code);
		System.out.println("client message:"+message);
		System.out.println("client data:"+data);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		super.channelReadComplete(ctx);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("client active");
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("client inactive");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)throws Exception {
		logger.warning("client exception==>"+cause);
	}

}
