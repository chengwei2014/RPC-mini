package com.order.rpc;

/**
 * 订单服务接口
 * 2020-06-18
 */
public interface IOrderService {
    String queryOrderList();
    String orderById(String id);
}
