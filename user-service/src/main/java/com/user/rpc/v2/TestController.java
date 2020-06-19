package com.user.rpc.v2;

import com.order.rpc.IOrderService;
import com.order.rpc.ITestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前端控制器
 * 2020-06-19
 */
@RestController
public class TestController {
    @GPReference
    private IOrderService orderService;
    @GPReference
    private ITestService testService;

    @GetMapping("/test")
    public String test(){
        return orderService.queryOrderList();
    }

    @GetMapping("/get")
    public String get(){
        return testService.sayHello();
    }
}
