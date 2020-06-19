package com.user.rpc.v1;

import com.order.rpc.IOrderService;

/**
 * 用户客户端调用
 * 2020-06-18
 */
public class UserClietnTest {
    public static void main(String[] args) {
        RPCProxyClient rpcProxyClient = new RPCProxyClient();
//        IOrderService orderService = rpcProxyClient.clientProxy(IOrderService.class, "localhost", 8080);
        IOrderService orderService = rpcProxyClient.clientProxy(IOrderService.class, "localhost", 8888);
        System.out.println(orderService.queryOrderList());
        System.out.println(orderService.orderById("1"));
    }
}
