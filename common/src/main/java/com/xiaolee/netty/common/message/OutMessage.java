package com.xiaolee.netty.common.message;

/**
 *
 */
public interface OutMessage {
    /**
     * 获取消息内容字节数组
     *
     * @return
     */
    byte[] getContent();

    /**
     * 消息内容类型
     *
     * @return
     */
    MessageTypeEnum type();
}
