package com.xiaolee.netty.im.common.protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class MessageEncoder extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (msg instanceof Message) {
            Message message = (Message) msg;
            byte[] msgBytes = MessageIOUtil.serialize(message);
            ctx.writeAndFlush(msgBytes);
        }
    }
}
