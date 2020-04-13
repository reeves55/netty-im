package com.xiaolee.netty.common.protocol;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

public class MessageIOUtil {
    private static final byte[] EMPTY_ARRAY = new byte[0];

    /**
     * message schema cache
     */
    private static final Schema<Message> MSG_SCHEMA = RuntimeSchema.createFrom(Message.class);

    /**
     * serialize message to byte array
     */
    public static byte[] serialize(Message message) {
        if (message == null) {
            return EMPTY_ARRAY;
        }

        return ProtobufIOUtil.toByteArray(message, MSG_SCHEMA, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
    }
}
