package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.controller.storesController;

import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.storeInfo.StoreInfo;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@Api(tags = "库存接口")
@RestController
public class StoresController {
    @Autowired
    private StoreService storeService;

    //根据商品类型和id进货
    @ApiOperation("根据商品类型和id进货")
    @PostMapping("/insertStore")
    public String insertStore(String itemsType, Long itemsId, Long amount) throws ParseException {
        return storeService.storeItems(itemsType,itemsId,amount);
    }

    //选出保质期小于一周的商品库存
    @ApiOperation("选出保质期小于一周的商品库存")
    @GetMapping("/getWarningOfPerishableItems")
    public List<StoreInfo> getWarningOfPerishableItems(){
        return storeService.getWarningOfPerishableItems();
    }

    //获取所有库存信息
    @ApiOperation("获取所有库存信息")
    @GetMapping("/getAllStores")
    public List<StoreInfo> getAllStores(){
        return storeService.getAllStoreInfo();
    }
}
