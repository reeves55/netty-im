package com.xiaolee.netty.common.message;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractAppMsg implements AppMsg{
    String from;
    String to;
    Map<String, Object> extendMap;

    AbstractAppMsg() {
        extendMap = new ConcurrentHashMap<>();
    }

    /**
     * subclass to implement
     * @return
     */
    public abstract byte[] getBytes();

    /**
     * subclass to implement
     * @return
     */
    public abstract String contentType();

    /**
     * subclass to implement
     * @return
     */
    public abstract Object getObject();


    public String msgFrom() {
        return from;
    }

    public String msgTo() {
        return to;
    }

    public Map<String, Object> extendMap() {
        return extendMap;
    }
}
