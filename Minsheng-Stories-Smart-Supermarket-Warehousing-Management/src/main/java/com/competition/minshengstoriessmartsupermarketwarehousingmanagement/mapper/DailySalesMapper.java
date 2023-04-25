package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.sales.DailySales;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface DailySalesMapper extends BaseMapper<DailySales> {
//    //根据日期筛选昨天的销售数据，并且按照商品种类给出销售额百分比
//    @Select("SELECT ordersTable.containerID, ordersInfoTable.itemType, ordersInfoTable.itemID, SUM(ordersInfoTable.actuallyPrice * ordersInfoTable.amount) AS sales, SUM(ordersInfoTable.amount) AS amount, ordersInfoTable.actuallyPrice\n" +
//            "FROM ordersTable\n" +
//            "INNER JOIN ordersInfoTable ON ordersTable.orderID = ordersInfoTable.orderID AND ordersTable.containerID = ordersInfoTable.containerID\n" +
//            "WHERE to_days(ordersTable.orderTime) = to_days(now())-1\n" +
//            "GROUP BY ordersTable.containerID, ordersInfoTable.itemType, ordersInfoTable.itemID, ordersInfoTable.actuallyPrice;\n" +
//            "WITH yesterday_sales AS (\n" +
//            "    SELECT ordersInfoTable.itemType, SUM(ordersInfoTable.actuallyPrice * ordersInfoTable.amount) AS sales\n" +
//            "    FROM ordersTable\n" +
//            "    INNER JOIN ordersInfoTable ON ordersTable.orderID = ordersInfoTable.orderID\n" +
//            "    WHERE to_days(ordersTable.orderTime) = to_days(now())-1\n" +
//            "    GROUP BY ordersInfoTable.itemType\n" +
//            "),\n" +
//            "total_sales AS (\n" +
//            "    SELECT SUM(sales) AS total_sales\n" +
//            "    FROM yesterday_sales\n" +
//            ")\n" +
//            "SELECT itemType, (sales / total_sales) * 100 AS percentage\n" +
//            "FROM yesterday_sales, total_sales;")
//    public List<TypeWithPercentage> getYesterdaySalesPercentage();
//
//    //根据日期筛选距今一周的销售数据，并且按照商品种类给出销售额百分比
//    @Select("WITH last_week_sales AS (\n" +
//            "    SELECT ordersInfoTable.itemType, SUM(ordersInfoTable.actuallyPrice * ordersInfoTable.amount) AS sales\n" +
//            "    FROM ordersTable\n" +
//            "    INNER JOIN ordersInfoTable ON ordersTable.orderID = ordersInfoTable.orderID\n" +
//            "    WHERE YEARWEEK(ordersTable.orderTime, 1) = YEARWEEK(CURDATE() - INTERVAL 1 WEEK, 1)\n" +
//            "    GROUP BY ordersInfoTable.itemType\n" +
//            "),\n" +
//            "total_sales AS (\n" +
//            "    SELECT SUM(sales) AS total_sales\n" +
//            "    FROM last_week_sales\n" +
//            ")\n" +
//            "SELECT itemType,(sales / total_sales) * 100 AS percentage\n" +
//            "FROM last_week_sales, total_sales;\n")
//    public List<TypeWithPercentage> getLastWeekSalesPercentage();
//
//    //根据日期筛选距今一个月的销售数据，并且按照商品种类给出销售额百分比
//    @Select("WITH past_month_sales AS (\n" +
//            "    SELECT ordersInfoTable.itemType, SUM(ordersInfoTable.actuallyPrice * ordersInfoTable.amount) AS sales\n" +
//            "    FROM ordersTable\n" +
//            "    INNER JOIN ordersInfoTable ON ordersTable.orderID = ordersInfoTable.orderID\n" +
//            "    WHERE ordersTable.orderTime >= DATE(NOW()) - INTERVAL 1 MONTH\n" +
//            "    GROUP BY ordersInfoTable.itemType\n" +
//            "),\n" +
//            "total_sales AS (\n" +
//            "    SELECT SUM(sales) AS total_sales\n" +
//            "    FROM past_month_sales\n" +
//            ")\n" +
//            "SELECT itemType,(sales / total_sales) * 100 AS percentage\n" +
//            "FROM past_month_sales, total_sales;\n")
//    public List<TypeWithPercentage> getLastMonthSalesPercentage();

    @Select("SELECT item.itemName, item.itemSupplier, item.itemPurchasePrice, sum(sales) as sales , sum(amount) as amount, sum((sales - (purchasePrice * amount))) as profit \n" +
            "FROM dailySalesTable \n" +
            "inner join ${tableName} item on dailySalesTable.itemID = item.itemID\n" +
            "WHERE dailySalesTable.itemType = #{itemType} AND dailySalesTable.itemID = #{itemID} AND date = DATE_SUB(CURDATE(), INTERVAL 1 DAY)")
    Map<String, Object> getYesterdaySalesAndProfit(@Param("tableName") String tableName, @Param("itemType") String itemType, @Param("itemID") int itemID);
}
