package com.order.rpc.v2;

import com.order.rpc.ITestService;

/**
 * 服务测试
 * 2020-06-18
 */
@GPRemoteService
public class TestServiceImpl implements ITestService {
    @Override
    public String sayHello() {
        return "Hello！";
    }
}
