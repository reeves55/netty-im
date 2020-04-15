package com.xiaolee.netty.im.client;

import com.xiaolee.netty.im.common.message.AppMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyIMClientHandler extends ChannelInboundHandlerAdapter {
    private NettyIMClient client;

    NettyIMClientHandler(NettyIMClient client) {
        this.client = client;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof AppMsg) {
            AppMsg appMsg = (AppMsg) msg;
            client.getDispatcher().dispatch(appMsg);
        }
    }
}
