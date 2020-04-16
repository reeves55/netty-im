package com.xiaolee.netty.im.common.message;

public class MsgTypeConstant {
    private MsgTypeConstant(){}

    /**
     * 普通文本消息
     */
    public static final String PLAIN_TEXT = "plain_text";

    /**
     * 文件消息
     */
    public static final String FILE = "file";

    /**
     * 字节数组消息
     */
    public static final String BYTES = "bytes";
}
