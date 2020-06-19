package com.order.rpc.v1;

/**
 * RPC服务端发布
 * 2020-06-18
 */
public class BootStrap {
    public static void main(String[] args) {
        OrderServiceImpl orderService = new OrderServiceImpl();
        RPCProxyServer rpcProxyServer = new RPCProxyServer();
        rpcProxyServer.publisher(orderService, 8080);
    }
}
