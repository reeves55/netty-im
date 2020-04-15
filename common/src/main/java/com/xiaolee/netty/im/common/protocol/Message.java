package com.xiaolee.netty.im.common.protocol;

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

    public static class Head {
        @Tag(1)
        private String id;

        @Tag(2)
        private int category;

        @Tag(3)
        private String contentType;

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

        private Head() {
        }

        public Head(Builder builder) {
            Head head = new Head();
            head.id = builder.id;
            head.category = builder.category;
            head.contentType = builder.contentType;
            head.from = builder.from;
            head.to = builder.to;
            head.timestamp = builder.timestamp;
            head.status = builder.status;
            head.extend = builder.extend;
        }

        public static Builder builder() {
            return new Builder();
        }


        public static class Builder {
            private String id;
            private int category;
            private String contentType;
            private String from;
            private String to;
            private long timestamp;
            private int status;
            private Map<String, Object> extend;

            private Builder() {
            }

            public Head build() {
                return new Message.Head(this);
            }

            public Builder id(String id) {
                this.id = id;
                return this;
            }

            public Builder category(int category) {
                this.category = category;
                return this;
            }

            public Builder contentType(String contentType) {
                this.contentType = contentType;
                return this;
            }

            public Builder from(String from) {
                this.from = from;
                return this;
            }

            public Builder to(String to) {
                this.to = to;
                return this;
            }

            public Builder timestamp(long timestamp) {
                this.timestamp = timestamp;
                return this;
            }

            public Builder status(int status) {
                this.status = status;
                return this;
            }

            public Builder extend(Map<String, Object> extend) {
                this.extend = extend;
                return this;
            }
        }

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

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
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
