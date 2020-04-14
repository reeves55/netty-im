package com.xiaolee.netty.im.common.message;

import java.nio.charset.StandardCharsets;

/**
 * 简单文本消息
 */
public class PlainTextAppMsg extends AbstractAppMsg {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private String content;

    public PlainTextAppMsg(String content) {
        this.content = content;
    }

    public PlainTextAppMsg(byte[] bytes) {
        this.content = new String(bytes, StandardCharsets.UTF_8);
    }

    /**
     * 获取消息内容字节数组
     */
    @Override
    public byte[] getBytes() {
        if (content == null) {
            return EMPTY_BYTE_ARRAY;
        }

        return content.getBytes(StandardCharsets.UTF_8);
    }

    /**
     * 消息内容类型
     */
    @Override
    public String contentType() {
        return MsgTypeConstant.PLAIN_TEXT;
    }

    /**
     * 获取实际的消息内容对象
     */
    @Override
    public Object getObject() {
        return content;
    }
}
