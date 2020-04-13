package com.xiaolee.netty.common.message;

public class BytesAppMsg extends AbstractAppMsg{
    /**
     * subclass to implement
     *
     * @return
     */
    @Override
    public byte[] getBytes() {
        return new byte[0];
    }

    /**
     * subclass to implement
     *
     * @return
     */
    @Override
    public String contentType() {
        return null;
    }

    /**
     * subclass to implement
     *
     * @return
     */
    @Override
    public Object getObject() {
        return null;
    }
}
