package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.controller;

import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.*;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.itemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class getInfoController {
    @Autowired
    private itemsMapper itemsMapper;

    //获取所有商品信息的通用属性
    @GetMapping("/items")
    public List findAll(){
        List<Items> list = itemsMapper.selectAllItems();
        System.out.println(list);
        return list;
    }

    //获取所有饮料信息
    @GetMapping("/drinks")
    public List findAllDrinks(){
        List<Drinks> list = itemsMapper.selectAllDrinks();
        System.out.println(list);
        return list;
    }

    //获取所有饼干信息
    @GetMapping("/biscuits")
    public List findAllBiscuits(){
        List<Biscuits> list = itemsMapper.selectAllBiscuits();
        System.out.println(list);
        return list;
    }

    //获取所有即食食品信息
    @GetMapping("/instantFood")
    public List findAllInstantFood(){
        List<InstantFoods> list = itemsMapper.selectAllInstantFood();
        System.out.println(list);
        return list;
    }

    //获取所有防护用品信息
    @GetMapping("/protectiveGears")
    public List findAllProtectiveGears(){
        List<ProtectiveGears> list = itemsMapper.selectAllProtectiveGears();
        System.out.println(list);
        return list;
    }
}
