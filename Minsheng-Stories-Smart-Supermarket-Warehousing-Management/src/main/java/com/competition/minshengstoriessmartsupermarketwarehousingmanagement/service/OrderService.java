package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.service;

import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.order.Order;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.containers.ContainersMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.orders.OrdersInfoMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.orders.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    private ContainersMapper containersMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrdersInfoMapper ordersInfoMapper;

    //根据订单号等创建订单信息
    public String createOrder(Long orderID, Long containerID, String orderStatus, Long customerID, String paymentInfo, String orderName){
        Order order = new Order(orderID, containerID, orderStatus, customerID, paymentInfo, orderName);
        ordersMapper.insert(order);
        return "添加成功";
    }

    //汇集订单信息制表
    public List<Map<String,Object>> getOrdersTable() {
        return ordersMapper.getOrdersTable();
    }

    //根据查询订单号查询订单信息
    public List<Map<String,Object>> getOrdersTableByOrderID(Long orderID) {
        return ordersInfoMapper.selectOrderInfoByOrderID(orderID);
    }

    //根据订单号删除订单信息
    public String deleteOrderByOrderID(Long orderID){
        ordersInfoMapper.deleteOrderInfoByOrderID(orderID);
        ordersMapper.deleteOrderById(orderID);
        return "删除成功";
    }
}
