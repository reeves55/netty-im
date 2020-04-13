package com.xiaolee.netty.common.message;

/**
 *
 */
public interface AppMsg {
    /**
     * 获取消息内容字节数组
     *
     * @return
     */
    byte[] getBytes();

    /**
     * 消息内容类型
     *
     * @return
     */
    String contentType();

    /**
     * 获取实际的消息内容对象
     *
     * @return
     */
    Object getObject();
}
