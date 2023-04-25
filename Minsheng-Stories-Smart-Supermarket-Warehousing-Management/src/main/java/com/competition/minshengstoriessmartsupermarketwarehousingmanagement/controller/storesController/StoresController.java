package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.controller.storesController;

import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

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
}
