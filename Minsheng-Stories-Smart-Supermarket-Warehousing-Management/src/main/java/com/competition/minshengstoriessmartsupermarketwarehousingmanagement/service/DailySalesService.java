package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.order.Order;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.order.OrderInfo;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.sales.DailySales;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.DailySalesMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.items.ItemsMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.orders.OrdersInfoMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.orders.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@EnableScheduling
public class DailySalesService {
    @Autowired
    private DailySalesMapper dailySalesTableMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrdersInfoMapper ordersInfoMapper;
    @Autowired
    private ItemsMapper itemsMapper;

    //手动写入昨日销售数据
    public String generateDailySaleManually(){
        List<DailySales> dailySales = ordersMapper.generateDailySales();
        for (DailySales dailySale : dailySales) {
            dailySalesTableMapper.insert(dailySale);
        }
        return "生成成功";
    }

    //创建定时任务每日0点写入数据
    @Scheduled(cron = "0 0 0 * * ?")
    private String generateDailySale(){
        List<DailySales> dailySales = ordersMapper.generateDailySales();
        for (DailySales dailySale : dailySales) {
            dailySalesTableMapper.insert(dailySale);
        }
        return "生成成功";
    }


    //根据日期筛选距今一个月的销售数据，并且按照商品种类给出销售额百分比
    public List<Map<String, Object>> getPastMonthSalesPercentage() {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1);

        QueryWrapper<Order> ordersTableQueryWrapper = new QueryWrapper<>();
        ordersTableQueryWrapper.ge("orderTime", oneMonthAgo);

        List<Order> ordersTableList = ordersMapper.selectList(ordersTableQueryWrapper);

        List<Long> orderIds = ordersTableList.stream().map(Order::getOrderID).collect(Collectors.toList());

        QueryWrapper<OrderInfo> ordersInfoTableQueryWrapper = new QueryWrapper<>();
        ordersInfoTableQueryWrapper.in("orderID", orderIds);
        ordersInfoTableQueryWrapper.select("itemType", "SUM(actuallyPrice * amount) as sales");
        ordersInfoTableQueryWrapper.groupBy("itemType");

        List<Map<String, Object>> salesByItemType = ordersInfoMapper.selectMaps(ordersInfoTableQueryWrapper);

        double totalSales = salesByItemType.stream().mapToDouble(item -> (double) item.get("sales")).sum();

        salesByItemType.forEach(item -> {
            double sales = (double) item.get("sales");
            double salesPercentage = (sales / totalSales) * 100;
            item.put("sales_percentage", salesPercentage);
        });

        return salesByItemType;
    }

    //根据日期筛选昨天的销售数据，并且按照商品种类和商品id给出商品的销售信息
    public Map<String, Object> getYesterdaySalesAndProfit(String itemType, int itemID) {
        String tableName = itemsMapper.getTableNameByTypeName(itemType);
        System.out.println(tableName);
        return dailySalesTableMapper.getYesterdaySalesAndProfit(tableName,itemType,itemID);
    }

    //根据日期筛选昨天的销售数据，并且按照货柜id给出货柜的销量
    public Map<String, Object> getYesterdaySalesAndProfitByContainerID(Long containerID) {
        return dailySalesTableMapper.getYesterdaySalesAndProfitByContainerID(containerID);
    }

    //查询所有销售数据
    public List<DailySales> getAllSales() {
        return dailySalesTableMapper.selectList(null);
    }
}
