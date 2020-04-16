package com.xiaolee.netty.im.common;

import com.xiaolee.netty.im.common.message.*;
import com.xiaolee.netty.im.common.protocol.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 将 Message 消息转换成 AppMsg
 */
public class AppMsgInboundHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof Message) {
            // Message to AppMsg
            Message message = (Message) msg;

            String contentType = message.getHead().getContentType();
            if (contentType == null) {
                // discard error message with uncorrected content type
                return;
            }

            AbstractAppMsg appMsg = null;
            switch (contentType) {
                case MsgTypeConstant.FILE:
                    FileAppMsg fileAppMsg = new FileAppMsg();
                    appMsg = fileAppMsg;
                    break;
                case MsgTypeConstant.PLAIN_TEXT:
                    PlainTextAppMsg textAppMsg = new PlainTextAppMsg(message.getBody());
                    appMsg = textAppMsg;
                    break;
                default:
                    BytesAppMsg bytesAppMsg = new BytesAppMsg(message.getBody());
                    appMsg = bytesAppMsg;
                    break;
            }

            appMsg.setFrom(message.getHead().getFrom());
            appMsg.setTo(message.getHead().getTo());
            ctx.fireChannelRead(appMsg);
        }
    }
}
