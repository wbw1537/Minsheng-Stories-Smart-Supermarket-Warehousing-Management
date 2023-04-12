package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.controller;

import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.*;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteItemsController {
    @Autowired
    private ItemsMapper itemsMapper;

    //删除饮料信息
    @DeleteMapping("/deleteDrinks")
    public String deleteDrinks(Drinks drinks){
        int i = itemsMapper.deleteDrinks(drinks);
        if(i > 0) return "删除成功";
        else return "删除失败";
    }

    //删除饼干信息
    @DeleteMapping("/deleteBiscuits")
    public String deleteBiscuits(Biscuits biscuits){
        int i = itemsMapper.deleteBiscuits(biscuits);
        if(i > 0) return "删除成功";
        else return "删除失败";
    }

    //删除即食食品信息
    @DeleteMapping("/deleteInstantFoods")
    public String deleteInstantFoods(InstantFoods instantFoods){
        int i = itemsMapper.deleteInstantFoods(instantFoods);
        if(i > 0) return "删除成功";
        else return "删除失败";
    }

    //删除防护用品信息
    @DeleteMapping("/deleteProtectiveGears")
    public String deleteProtectiveGears(ProtectiveGears protectiveGears){
        int i = itemsMapper.deleteProtectiveGears(protectiveGears);
        if(i > 0) return "删除成功";
        else return "删除失败";
    }

    //删除膨化食品信息
    @DeleteMapping("/deletePuffedFoods")
    public String deletePuffedFoods(PuffedFoods puffedFoods){
        int i = itemsMapper.deletePuffedFoods(puffedFoods);
        if(i > 0) return "删除成功";
        else return "删除失败";
    }
}
