package com.xiaolee.netty.im.common;

import com.xiaolee.netty.im.common.util.MsgIdGenerator;
import com.xiaolee.netty.im.common.message.AppMsg;
import com.xiaolee.netty.im.common.protocol.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class AppMsgOutboundHandler extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (msg instanceof AppMsg) {
            AppMsg appMsg = (AppMsg) msg;

            Message message = new Message();
            Message.Head head = Message.Head.builder()
                    .id(MsgIdGenerator.nextId())
                    .timestamp(System.currentTimeMillis())
                    // todo: category?
                    .category(0)
                    .from(appMsg.msgFrom())
                    .to(appMsg.msgTo())
                    .contentType(appMsg.contentType())
                    .build();

            message.setBody(appMsg.getBytes());

            ctx.writeAndFlush(message);
        }
    }
}
