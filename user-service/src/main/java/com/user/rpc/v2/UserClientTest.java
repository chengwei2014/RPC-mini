package com.user.rpc.v2;

import com.order.rpc.IOrderService;
import com.order.rpc.ITestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 用户端调用测试
 * 2020-06-19
 */
@SpringBootApplication
public class UserClientTest {
    public static void main(String[] args) {
        SpringApplication.run(UserClientTest.class, args);

        RPCProxyClient rpcProxyClient = new RPCProxyClient();
        IOrderService iOrderService = rpcProxyClient.clientProxy(IOrderService.class, "localhost", 8888);
        System.out.println(iOrderService.queryOrderList());
        System.out.println(iOrderService.orderById("1"));
        ITestService iTestService = rpcProxyClient.clientProxy(ITestService.class, "localhost", 8888);
        System.out.println(iTestService.sayHello());
    }
}
