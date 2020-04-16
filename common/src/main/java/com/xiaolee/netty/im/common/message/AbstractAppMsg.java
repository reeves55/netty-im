package com.xiaolee.netty.im.common.message;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractAppMsg implements AppMsg{
    String from;
    String to;
    Map<String, Object> extendMap;

    AbstractAppMsg() {
        extendMap = new ConcurrentHashMap<>();
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setExtendMap(Map<String, Object> extendMap) {
        this.extendMap = extendMap;
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
