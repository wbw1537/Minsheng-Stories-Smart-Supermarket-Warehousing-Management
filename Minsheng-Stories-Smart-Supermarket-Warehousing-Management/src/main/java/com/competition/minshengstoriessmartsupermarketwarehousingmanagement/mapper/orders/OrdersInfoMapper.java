package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.orders;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.order.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrdersInfoMapper extends BaseMapper<OrderInfo> {
    //根据订单号查询订单信息
    @Select("select oit.orderID as 订单编号, oit.itemID as 商品编号, ist.itemName as 商品名称, oit.itemType as 商品类型, oit.containerID as 货柜编号, oit.amount as 数量, oit.actuallyPrice as 总价, oit.purchasePrice as 成本, (oit.actuallyPrice-oit.amount*oit.purchasePrice) as 利润\n" +
            "from ordersInfoTable oit\n" +
            "inner join itemsSummaryTable ist on ist.itemType = oit.itemType and ist.itemID = oit.itemID\n" +
            "where oit.orderID = #{orderID}")
    public List<Map<String,Object>> selectOrderInfoByOrderID(Long orderID);

    //根据订单号删除订单信息
    @Select("delete from ordersInfoTable where orderID = #{orderID}")
    public void deleteOrderInfoByOrderID(Long orderID);
}
