package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.controller.OrdersController;

import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.order.Order;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.order.OrderInfo;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.orders.OrdersMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "订单接口")
@RestController
public class OrdersController {
    @Autowired
    private OrderService orderService;

    //根据订单号等创建订单信息
    @ApiOperation(value = "根据订单号等创建订单信息")
    @PostMapping("/orders")
    public String createOrder(Long orderID, Long containerID, String orderStatus, Long customerID, String paymentInfo, String orderName){
        return orderService.createOrder(orderID, containerID, orderStatus, customerID, paymentInfo, orderName);
    }

    //汇集订单信息制表
    @ApiOperation(value = "汇集订单信息制表")
    @GetMapping("/orders")
    public List<Map<String,Object>> getOrdersTable() {
        return orderService.getOrdersTable();
    }

    //根据查询订单号查询订单信息
    @ApiOperation(value = "根据查询订单号查询订单信息")
    @GetMapping("/orders/{orderID}")
    public List<Map<String,Object>> getOrdersTableByOrderID(@PathVariable("orderID") Long orderID) {
        return orderService.getOrdersTableByOrderID(orderID);
    }

    //根据订单号删除订单信息
    @ApiOperation(value = "根据订单号删除订单信息")
    @DeleteMapping("/orders/{orderID}")
    public String deleteOrderByOrderID(@PathVariable("orderID") Long orderID){
        return orderService.deleteOrderByOrderID(orderID);
    }

//    //增添一条新的订单记录
//    @ApiOperation(value = "增添一条新的订单记录")
//    @PostMapping("/orders")
//    public String insertOrder(Order order){
//        System.out.println(order);
//        return ordersMapper.insert(order) > 0 ? "插入成功" : "插入失败";
//    }
//
//    //修改订单信息
//    @ApiOperation(value = "修改订单信息")
//    @PutMapping("/orders")
//    public String updateOrder(Order order){
//        System.out.println(order);
//        return ordersMapper.updateById(order) > 0 ? "更新成功" : "更新失败";
//    }
//
//    //根据订单号删除订单信息
//    @ApiOperation(value = "根据订单号删除订单信息")
//    @DeleteMapping("/orders/{orderNumber}")
//    public String deleteOrderById(Long orderID){
//        return ordersMapper.deleteById(orderID) > 0 ? "删除成功" : "删除失败";
//    }
//
//    //根据订单号查询订单信息
//    @ApiOperation(value = "根据订单号查询订单信息")
//    @GetMapping("/orders/{orderNumber}")
//    public Order selectOrderById(Long orderID){
//        Order order = ordersMapper.selectById(orderID);
//        System.out.println(order);
//        return order;
//    }
//
//    //根据货柜号查询该货柜所有订单信息
//    @ApiOperation(value = "根据货柜号查询该货柜所有订单信息")
//    @GetMapping("/orders/{containerNumber}")
//    public List selectOrderByContainerNumber(Long containerNumber){
//        List<Order> order = ordersMapper.selectOrderByContainerId(containerNumber);
//        System.out.println(order);
//        return order;
//    }
//
//    //查询所有订单信息
//    @ApiOperation(value = "查询所有订单信息")
//    @GetMapping("/orders")
//    public List selectAllOrders(){
//        List<Order> list = ordersMapper.selectAllOrders();
//        System.out.println(list);
//        return list;
//    }
//
//    //增加一条订单内容记录
//    @ApiOperation(value = "增加一条订单内容记录")
//    @PostMapping("/orders/items")
//    public String insertOrderItem(OrderInfo order){
//        return ordersMapper.insertOrderInfo(order) > 0 ? "插入成功" : "插入失败";
//    }
//
//    //修改订单内容信息
//    @ApiOperation(value = "修改订单内容信息")
//    @PutMapping("/orders/items")
//    public String updateOrderItem(OrderInfo order){
//        return ordersMapper.updateOrderInfo(order) > 0 ? "更新成功" : "更新失败";
//    }
//
//    //根据订单号删除订单内容信息
//    @ApiOperation(value = "根据订单号删除订单内容信息")
//    @DeleteMapping("/orders/items/{orderNumber}")
//    public String deleteOrderItemById(Long orderID){
//        return ordersMapper.deleteOrderInfoById(orderID) > 0 ? "删除成功" : "删除失败";
//    }
//
//    //根据订单号查询订单内容信息
//    @ApiOperation(value = "根据订单号查询订单内容信息")
//    @GetMapping("/orders/items/{orderNumber}")
//    public List selectOrderItemById(Long orderID){
//        List<OrderInfo> order = ordersMapper.selectOrderInfoById(orderID);
//        System.out.println(order);
//        return order;
//    }
//
//    //查询昨天的订单信息
//    @ApiOperation(value = "查询昨天的订单信息")
//    @GetMapping("/orders/yesterday")
//    public List selectYesterdayOrders(){
//        List<Order> list = ordersMapper.selectYesterdayOrders();
//        System.out.println(list);
//        return list;
//    }



}
