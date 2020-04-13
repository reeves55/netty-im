package com.xiaolee.netty.common.protocol;

import io.protostuff.Tag;
import lombok.Data;

import java.util.Map;

@Data
public class Message {
    @Tag(1)
    private Head head;

    @Tag(2)
    private byte[] body;

    @Data
    static class Head {
        @Tag(1)
        private String id;

        @Tag(2)
        private int category;

        @Tag(3)
        private int type;

        @Tag(4)
        private String from;

        @Tag(5)
        private String to;

        @Tag(6)
        private long timestamp;

        @Tag(7)
        private int status;

        @Tag(8)
        private Map<String, Object> extend;
    }
}
