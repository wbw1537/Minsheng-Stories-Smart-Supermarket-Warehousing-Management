package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.service;

import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.order.Order;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.containers.ContainersMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.orders.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private ContainersMapper containersMapper;
    @Autowired
    private OrdersMapper ordersMapper;

    //根据订单号等创建订单信息
    public String createOrder(Long orderID, Long containerID, String orderStatus, Long customerID, String paymentInfo, String orderName){
        Order order = new Order(orderID, containerID, orderStatus, customerID, paymentInfo, orderName);
        ordersMapper.insert(order);
        return "添加成功";
    }
}
