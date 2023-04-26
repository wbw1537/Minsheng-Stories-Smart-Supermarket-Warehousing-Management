package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.orders;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.order.Order;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.order.OrderInfo;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.sales.DailySales;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrdersMapper extends BaseMapper<Order> {
//    //增添一条新的订单记录
//    @Insert("insert into ordersTable (orderID,containerID,orderStatus,customerID,paymentInfo,orderTime,orderName) values (#{orderID},#{containerID},#{orderStatus},#{customerID},#{paymentInfo},#{orderTime},#{orderName})")
//    public int insertOrder(Order order);
//
//    //修改订单信息
//    @Update("update ordersTable set containerID = #{containerID}, orderStatus = #{orderStatus}, customerID = #{customerID}, paymentInfo = #{paymentInfo}, orderTime = #{orderTime}, orderName = #{orderName} where orderID = #{orderID}")
//    public int updateOrder(Order order);
//
    //根据订单号删除订单信息
    @Delete("delete from ordersTable where orderID = #{orderID}")
    public void deleteOrderById(Long orderID);
//
//    //根据订单号查询订单信息
//    @Select("select * from ordersTable where orderID = #{orderID}")
//    public Order selectOrderById(Long orderID);
//
    //根据货柜号查询该货柜所有订单信息
    @Select("select * from ordersTable where containerID = #{containerID}")
    public List<Order> selectOrderByContainerId(Long containerID);

    //查询所有订单信息
    @Select("select * from ordersTable")
    public List<Order> selectAllOrders();

    //增加一条订单内容记录
    @Insert("insert into ordersInfoTable (orderID,itemID,itemType,containerID,amount,actuallyPrice,purchasePrice) values (#{orderID},#{itemID},#{itemType},#{containerID},#{amount},#{actuallyPrice},#{purchasePrice})")
    public int insertOrderInfo(OrderInfo order);

    //修改订单内容信息
    @Update("update ordersInfoTable set itemID = #{itemID}, itemType = #{itemType}, containerID = #{containerID}, amount = #{amount}, actuallyPrice = #{actuallyPrice}, purchasePrice = #{purchasePrice} where orderID = #{orderID}")
    public int updateOrderInfo(OrderInfo order);

    //根据订单号删除订单内容信息
    @Delete("delete from ordersInfoTable where orderID = #{orderID}")
    public int deleteOrderInfoById(Long orderID);

    //根据订单号查询订单内容信息
    @Select("select * from ordersInfoTable where orderID = #{orderID}")
    public List<OrderInfo> selectOrderInfoById(Long orderID);

    //查询昨天产生的订单信息
    @Select("select * from ordersTable where to_days(orderTime) = to_days(now())-1")
    public List<Order> selectYesterdayOrders();

    //查询近一周的订单信息
    @Select("select * from ordersTable where orderTime between DATE_SUB(NOW(), INTERVAL 7 DAY) and NOW()")
    public List<Order> selectOrdersByWeek();

    //查询近一个月的订单信息
    @Select("select * from ordersTable where orderTime between DATE_SUB(NOW(), INTERVAL 1 MONTH) and NOW()")
    public List<Order> selectOrdersByMonth();

    //根据订单表及订单信息表生成每日销售信息
    @Select("SELECT ordersTable.containerID, ordersInfoTable.itemType, ordersInfoTable.itemID, SUM(ordersInfoTable.actuallyPrice * ordersInfoTable.amount) AS sales, SUM(ordersInfoTable.amount) AS amount, ordersInfoTable.actuallyPrice, ordersInfoTable.purchasePrice\n" +
            "FROM ordersTable\n" +
            "INNER JOIN ordersInfoTable ON ordersTable.orderID = ordersInfoTable.orderID AND ordersTable.containerID = ordersInfoTable.containerID\n" +
            "WHERE to_days(ordersTable.orderTime) = to_days(now())-1\n" +
            "GROUP BY ordersTable.containerID, ordersInfoTable.itemType, ordersInfoTable.itemID, ordersInfoTable.actuallyPrice, ordersInfoTable.purchasePrice;\n")
    public List<DailySales> generateDailySales();

    //汇集订单信息制表
    @Select("select ot.orderID as 订单编号, ot.containerID as 货柜编号, ot.orderStatus as 订单状态, ot.customerID as 用户编号, ot.paymentInfo as 支付信息, ot.orderTime as 订单完成时间 , sum(oit.amount) as 商品数, sum(oit.actuallyPrice) as 订单总价 from ordersTable ot\n" +
            "inner join ordersInfoTable oit on oit.orderID = ot.orderID\n" +
            "group by ot.orderID;")
    public List<Map<String,Object>> getOrdersTable();


}
