package com.xiaolee.netty.im.common.message;

import java.io.File;

/**
 * 文件消息
 */
public class FileAppMsg extends AbstractAppMsg {
    private File file;

    /**
     * 获取消息内容字节数组
     */
    @Override
    public byte[] getBytes() {
        return new byte[0];
    }

    /**
     * 消息内容类型
     *
     * @return
     */
    @Override
    public String contentType() {
        return MsgTypeConstant.FILE;
    }

    /**
     * 获取实际的消息内容对象
     */
    @Override
    public Object getObject() {
        return file;
    }
}
