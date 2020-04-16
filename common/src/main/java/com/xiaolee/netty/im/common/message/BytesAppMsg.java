package com.xiaolee.netty.im.common.message;

public class BytesAppMsg extends AbstractAppMsg{
    private byte[] content;

    public BytesAppMsg(byte[] body) {
        this.content = body;
    }

    /**
     * subclass to implement
     *
     * @return
     */
    @Override
    public byte[] getBytes() {
        return content;
    }

    /**
     * subclass to implement
     *
     * @return
     */
    @Override
    public String contentType() {
        return MsgTypeConstant.BYTES;
    }

    /**
     * subclass to implement
     *
     * @return
     */
    @Override
    public Object getObject() {
        return content;
    }
}
