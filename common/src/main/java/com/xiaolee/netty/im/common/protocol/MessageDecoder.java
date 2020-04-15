package com.xiaolee.netty.im.common.protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class MessageDecoder extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        byte[] msgBytes = (byte[]) msg;
        Message message = MessageIOUtil.deserialize(msgBytes);
        ctx.fireChannelRead(message);
    }
}
