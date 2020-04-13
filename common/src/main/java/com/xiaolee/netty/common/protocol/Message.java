package com.xiaolee.netty.common.protocol;

import io.protostuff.Tag;

import java.util.Map;

public class Message {
    @Tag(1)
    private Head head;

    @Tag(2)
    private byte[] body;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

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


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Map<String, Object> getExtend() {
            return extend;
        }

        public void setExtend(Map<String, Object> extend) {
            this.extend = extend;
        }
    }
}
