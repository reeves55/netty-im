package com.xiaolee.netty.common.message;

/**
 * 文件消息
 */
public class FileOutMessage implements OutMessage{

    /**
     * 获取消息内容字节数组
     */
    @Override
    public byte[] getContent() {
        return new byte[0];
    }

    /**
     * 消息内容类型
     *
     * @return
     */
    @Override
    public MessageTypeEnum type() {
        return MessageTypeEnum.FILE;
    }
}
