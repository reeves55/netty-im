package com.xiaolee.netty.im.client;

import com.xiaolee.netty.im.client.config.PropertySource;
import com.xiaolee.netty.im.client.exception.ConnectException;
import com.xiaolee.netty.im.client.promise.ChannelFutureAdapter;
import com.xiaolee.netty.im.client.promise.CompleteListener;
import com.xiaolee.netty.im.client.promise.Promise;
import com.xiaolee.netty.im.common.AppMsgInboundHandler;
import com.xiaolee.netty.im.common.AppMsgOutboundHandler;
import com.xiaolee.netty.im.common.message.AppMsg;
import com.xiaolee.netty.im.common.protocol.Message;
import com.xiaolee.netty.im.common.protocol.MessageDecoder;
import com.xiaolee.netty.im.common.protocol.MessageEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class NettyIMClient implements IMClient {
    private static final int DISCONNECTED = 0;
    private static final int CONNECTING = 1;
    private static final int CONNECTED = 2;
    // 客户端连接状态
    private volatile int status = DISCONNECTED;
    // 属性配置源，用于获取配置属性值
    private PropertySource propertySource;
    // 消息分发器
    private Dispatcher dispatcher;
    // netty 网络连接
    private Channel connection;
    private Bootstrap bootstrap;
    // server address
    private InetSocketAddress server;

    public NettyIMClient(PropertySource propertySource) {
        this.propertySource = propertySource;

        // init bootstrap
        bootstrap = new Bootstrap();
        bootstrap.group(NettyEventLoopFactory.eventLoopGroup(propertySource.threads()))
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, Math.max(3000, propertySource.connectTimeout()))
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline()
                                // 使用netty自带长度解码器
                                .addLast("frame-encoder", new LengthFieldPrepender(2))
                                .addLast("frame-decoder", new LengthFieldBasedFrameDecoder(65535,
                                        0, 2, 0, 2))
                                .addLast(new MessageDecoder())
                                .addLast(new MessageEncoder())
                                .addLast(new AppMsgOutboundHandler())
                                .addLast(new AppMsgInboundHandler());
                    }
                });
    }

    /**
     * 连接到IM服务器
     */
    public Promise connect() throws ConnectException{
        if (status > DISCONNECTED) {
            throw new ConnectException("client is connecting or has already connected to server");
        }

        if (server == null) {
            InetSocketAddress[] servers = propertySource.serverUrls();
            if (servers == null || servers.length == 0) {
                throw new ConnectException("server urls are empty, please specify one available server url at least");
            }

            server = selectServer(servers, null);
            if (server == null) {
                throw new ConnectException("网络错误，无法连接到服务器，请检查");
            }
        }

        ChannelFuture future = bootstrap.connect(server);
        return new ChannelFutureAdapter(future).onComplete(new CompleteListener() {
            @Override
            public void success(Promise promise) {
                connection = future.channel();
                updateStatus(CONNECTED);
            }

            @Override
            public void error(Promise promise) {
                // 连接出错
                System.out.println("连接出错");
            }
        });
    }

    private void updateStatus(int status) {
        this.status = status;
    }

    private InetSocketAddress selectServer(InetSocketAddress[] servers, InetSocketAddress[] except) {
        InetSocketAddress selectedServer = null;
        long connTime = Integer.MAX_VALUE;
        for (InetSocketAddress address : servers) {
            try {
                Socket socket = new Socket();
                long start = System.currentTimeMillis();
                socket.connect(address, 3000);
                long end = System.currentTimeMillis();

                if ((end - start) < connTime) {
                    connTime = end - start;
                    selectedServer = address;
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return selectedServer;
    }

    /**
     * 发送消息
     */
    @Override
    public Promise sendTo(String receiver, AppMsg message) {
        return new ChannelFutureAdapter(connection.writeAndFlush(message));
    }

    /**
     * 添加事件监听器
     */
    @Override
    public void addOnEventListener(OnEventListener listener) {

    }

    /**
     * 关闭客户端，清理所有资源
     */
    @Override
    public void close() {

    }


}
