package com.xiaolee.netty.common.message;

import java.nio.charset.StandardCharsets;

/**
 * 简单文本消息
 */
public class PlainTextOutMessage implements OutMessage{
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private String content;

    public PlainTextOutMessage(String content) {
        this.content = content;
    }

    /**
     * 获取消息内容字节数组
     */
    public byte[] getContent() {
        if (content == null) {
            return EMPTY_BYTE_ARRAY;
        }

        return content.getBytes(StandardCharsets.UTF_8);
    }
}
