package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper;

import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.order.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Mapper
public interface OrdersMapper {
    //增添一条新的订单记录
    @Insert("insert into ordersTable (orderID,containerID,orderStatus,customerID,paymentInfo,orderTime,orderName) values (#{orderID},#{containerID},#{orderStatus},#{customerID},#{paymentInfo},#{orderTime},#{orderName})")
    public int insertOrder(Order order);

    //修改订单信息
    @Update("update ordersTable set containerID = #{containerID}, orderStatus = #{orderStatus}, customerID = #{customerID}, paymentInfo = #{paymentInfo}, orderTime = #{orderTime}, orderName = #{orderName} where orderID = #{orderID}")
    public int updateOrder(Order order);

    //根据订单号删除订单信息
    @Delete("delete from ordersTable where orderID = #{orderID}")
    public int deleteOrderById(Long orderID);

    //根据订单号查询订单信息
    @Select("select * from ordersTable where orderID = #{orderID}")
    public Order selectOrderById(Long orderID);

    //根据货柜号查询该货柜所有订单信息
    @Select("select * from ordersTable where containerID = #{containerID}")
    public List<Order> selectOrderByContainerId(Long containerID);

    //查询所有订单信息
    @Select("select * from ordersTable")
    public List<Order> selectAllOrders();

    //增加一条订单内容记录
    @Insert("insert into ordersInfoTable (orderID,itemID,itemType,containerID,amount,actuallyPrice) values (#{orderID},#{itemID},#{itemType},#{containerID},#{amount},#{actuallyPrice})")
    public int insertOrderInfo(Order order);

    //修改订单内容信息
    @Update("update ordersInfoTable set itemID = #{itemID}, itemType = #{itemType}, containerID = #{containerID}, amount = #{amount}, actuallyPrice = #{actuallyPrice} where orderID = #{orderID}")
    public int updateOrderInfo(Order order);

    //根据订单号删除订单内容信息
    @Delete("delete from ordersInfoTable where orderID = #{orderID}")
    public int deleteOrderInfoById(Long orderID);

    //根据订单号查询订单内容信息
    @Select("select * from ordersInfoTable where orderID = #{orderID}")
    public List<Order> selectOrderInfoById(Long orderID);
}
