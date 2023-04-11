package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.controller;

import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class insertItemsController {
    @Autowired
    private com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.itemsMapper itemsMapper;

    //插入饮料信息
    @PostMapping("/insertDrinks")
    public String insertDrinks(Drinks drinks){
        int i = itemsMapper.insertDrinks(drinks);
        if(i > 0) return "插入成功";
        else return "插入失败";
    }

    //插入饼干信息
    @PostMapping("/insertBiscuits")
    public String insertBiscuits(Biscuits biscuits){
        int i = itemsMapper.insertBiscuits(biscuits);
        if(i > 0) return "插入成功";
        else return "插入失败";
    }

    //插入即食食品信息
    @PostMapping("/insertInstantFoods")
    public String insertInstantFoods(InstantFoods instantFoods){
        int i = itemsMapper.insertInstantFoods(instantFoods);
        if(i > 0) return "插入成功";
        else return "插入失败";
    }

    //插入防护用品信息
    @PostMapping("/insertProtectiveGears")
    public String insertProtectiveGears(ProtectiveGears protectiveGears){
        int i = itemsMapper.insertProtectiveGears(protectiveGears);
        if(i > 0) return "插入成功";
        else return "插入失败";
    }

    //插入膨化食品信息
    @PostMapping("/insertPuffedFoods")
    public String insertPuffedFoods(PuffedFoods puffedFoods){
        int i = itemsMapper.insertPuffedFoods(puffedFoods);
        if(i > 0) return "插入成功";
        else return "插入失败";
    }
}
