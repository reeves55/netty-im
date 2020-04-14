package com.xiaolee.netty.im.common.message;

import java.util.Map;

/**
 * 应用层消息接口
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

    /**
     * 消息发送者
     *
     * @return
     */
    String msgFrom();

    /**
     * 消息接受者
     *
     * @return
     */
    String msgTo();

    /**
     * 自定义拓展消息字段
     *
     * @return
     */
    Map<String, Object> extendMap();
}
