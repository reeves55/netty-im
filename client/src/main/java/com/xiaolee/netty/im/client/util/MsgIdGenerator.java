package com.xiaolee.netty.im.client.util;

import java.util.UUID;

public class MsgIdGenerator {
    public static String nextId() {
        return "Msg_" + UUID.randomUUID().toString().replace("-", "");
    }
}
