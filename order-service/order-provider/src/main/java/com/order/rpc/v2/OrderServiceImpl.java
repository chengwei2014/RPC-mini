package com.order.rpc.v2;

import com.order.rpc.IOrderService;

/**
 * 订单服务
 * 2020-06-18
 */
@GPRemoteService
public class OrderServiceImpl implements IOrderService {
    @Override
    public String queryOrderList() {
        return "订单列表查询服务。";
    }

    @Override
    public String orderById(String id) {
        return "根据id查询订单服务。";
    }
}
