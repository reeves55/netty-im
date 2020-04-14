package com.xiaolee.netty.im.common.message;

import com.xiaolee.netty.im.common.protocol.Message;

public class AppMsgUtil {
    /**
     * 判断消息是否是普通文本消息
     */
    public static boolean isPlainTextMsg(Message message) {
        if (message == null) {
            return false;
        }

        return message.getHead().getContentType().equals(MsgTypeConstant.PLAIN_TEXT);
    }

    /**
     * 把 message 封装成 plain text application message
     */
    public static PlainTextAppMsg wrapperPlainTextMsg(Message message) {
        return new PlainTextAppMsg(message.getBody());
    }


}
