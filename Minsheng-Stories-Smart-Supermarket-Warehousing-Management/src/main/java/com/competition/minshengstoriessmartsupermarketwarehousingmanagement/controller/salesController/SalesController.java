package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.controller.salesController;


import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.DailySalesMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.orders.OrdersInfoMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.orders.OrdersMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.service.DailySalesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags = "销售数据接口")
@EnableScheduling
@RestController
public class SalesController {
    @Autowired
    private DailySalesMapper dailySalesMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrdersInfoMapper ordersInfoMapper;
    @Autowired
    private DailySalesService dailySalesService;

    //手动写入昨日销售数据
    @ApiOperation(value = "手动写入昨日销售数据")
    @PostMapping("/generateDailySaleManually")
    public String generateDailySaleManually(){
        return dailySalesService.generateDailySaleManually();
    }

//    //根据日期筛选昨天的销售数据，并且按照商品种类给出销售额百分比
//    @ApiOperation(value = "根据日期筛选昨天的销售数据，并且按照商品种类给出销售额百分比")
//    @GetMapping("/getYesterdaySale")
//    public List<TypeWithPercentage> getYesterdaySale(){
//        return dailySalesMapper.getYesterdaySalesPercentage();
//    }
//
//
//    //根据日期筛选距今一周的销售数据，并且按照商品种类给出销售额百分比
//    @ApiOperation(value = "根据日期筛选距今一周的销售数据，并且按照商品种类给出销售额百分比")
//    @GetMapping("/getLastWeekSale")
//    public List<TypeWithPercentage> getLastWeekSale(){
//        return dailySalesMapper.getLastWeekSalesPercentage();
//    }
//
//    //根据日期筛选距今一个月的销售数据，并且按照商品种类给出销售额百分比
//    @ApiOperation(value = "根据日期筛选距今一个月的销售数据，并且按照商品种类给出销售额百分比")
//    @GetMapping("/getLastMonthSale")
//    public List<TypeWithPercentage> getLastMonthSale(){
//        return dailySalesMapper.getLastMonthSalesPercentage();
//    }

    //根据日期筛选距今一个月的销售数据，并且按照商品种类给出销售额百分比
    @ApiOperation(value = "根据日期筛选距今一个月的销售数据，并且按照商品种类给出销售额百分比")
    @GetMapping("/getPastMonthSalesPercentage")
    public List<Map<String, Object>> getPastMonthSalesPercentage() {
        return dailySalesService.getPastMonthSalesPercentage();
    }

    //根据商品种类以及id获取商品销售信息
    @ApiOperation(value = "根据商品种类以及id获取商品销售信息")
    @GetMapping("/yesterday-sales-profit")
    public Map<String, Object> getYesterdaySalesAndProfit(@RequestParam("itemType") String itemType, @RequestParam("itemID") int itemID) {
        return dailySalesService.getYesterdaySalesAndProfit(itemType, itemID);
    }
}
