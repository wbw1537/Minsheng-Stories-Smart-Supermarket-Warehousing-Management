package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.controller;

import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.ItemsMapper;

@RestController
public class UpdateItemsController {

    @Autowired
    private ItemsMapper itemsMapper;

    //更新饮料信息
    @PostMapping("/updateDrinks")
    public String updateDrinks(Drinks drinks){
        int i = itemsMapper.updateDrinks(drinks);
        if(i > 0) return "更新成功";
        else return "更新失败";
    }

    //更新饼干信息
    @PostMapping("/updateBiscuits")
    public String updateBiscuits(Biscuits biscuits){
        int i = itemsMapper.updateBiscuits(biscuits);
        if(i > 0) return "更新成功";
        else return "更新失败";
    }

    //更新即食食品信息
    @PostMapping("/updateInstantFoods")
    public String updateInstantFoods(InstantFoods instantFoods){
        int i = itemsMapper.updateInstantFoods(instantFoods);
        if(i > 0) return "更新成功";
        else return "更新失败";
    }

    //更新防护用品信息
    @PostMapping("/updateProtectiveGears")
    public String updateProtectiveGears(ProtectiveGears protectiveGears){
        int i = itemsMapper.updateProtectiveGears(protectiveGears);
        if(i > 0) return "更新成功";
        else return "更新失败";
    }

    //更新膨化食品信息
    @PostMapping("/updatePuffedFoods")
    public String updatePuffedFoods(PuffedFoods puffedFoods){
        int i = itemsMapper.updatePuffedFoods(puffedFoods);
        if(i > 0) return "更新成功";
        else return "更新失败";
    }
}
