package com.xiaolee.netty.common.message;

public enum MessageTypeEnum {
    PLAIN_TEXT("文本消息"),
    FILE("文件消息");


    private String type;

    MessageTypeEnum(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }
}
