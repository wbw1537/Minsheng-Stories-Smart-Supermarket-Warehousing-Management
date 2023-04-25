package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.controller.itemsController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.items.*;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.items.ItemsMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.service.ItemsService;

@Api(tags = "商品管理")
@RestController
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    //返回商品种类及占比
    @ApiOperation(value = "返回商品种类及占比")
    @GetMapping("/items/kinds")
    public List<Map<String, Object>> getItemTypePercentage() {
        return itemsService.getItemTypePercentage();
    }

    //获取所有商品信息的通用属性
    @ApiOperation(value = "获取所有商品信息的通用属性")
    @GetMapping("/items")
    public List findAll(){
        return itemsService.findAll();
    }

//    //删除饮料信息
//    @ApiOperation(value = "删除饮料信息")
//    @DeleteMapping("/drinks/{id}")
//    public String deleteDrinks(@PathVariable Long id){
//        int i = itemsMapper.deleteDrinksById(id);
//        if(i > 0) return "删除成功";
//        else return "删除失败";
//    }
//
//    //删除饼干信息
//    @ApiOperation(value = "删除饼干信息")
//    @DeleteMapping("/biscuits/{id}")
//    public String deleteBiscuits(@PathVariable Long id){
//        int i = itemsMapper.deleteBiscuitsById(id);
//        if(i > 0) return "删除成功";
//        else return "删除失败";
//    }
//
//    //删除即食食品信息
//    @ApiOperation(value = "删除即食食品信息")
//    @DeleteMapping("/instantFoods/{id}")
//    public String deleteInstantFoods(@PathVariable Long id){
//        int i = itemsMapper.deleteInstantFoodsById(id);
//        if(i > 0) return "删除成功";
//        else return "删除失败";
//    }
//
//    //删除防护用品信息
//    @ApiOperation(value = "删除防护用品信息")
//    @DeleteMapping("/protectiveGears/{id}")
//    public String deleteProtectiveGears(@PathVariable Long id){
//        int i = itemsMapper.deleteProtectiveGearsById(id);
//        if(i > 0) return "删除成功";
//        else return "删除失败";
//    }
//
//    //删除膨化食品信息
//    @ApiOperation(value = "删除膨化食品信息")
//    @DeleteMapping("/puffedFoods/{id}")
//    public String deletePuffedFoods(@PathVariable Long id){
//        int i = itemsMapper.deletePuffedFoodsById(id);
//        if(i > 0) return "删除成功";
//        else return "删除失败";
//    }
//
//    //插入饮料信息
//    @ApiOperation(value = "插入饮料信息")
//    @PostMapping("/drinks")
//    public String insertDrinks(Drinks drinks){
//        int i = itemsMapper.insertDrinks(drinks);
//        if(i > 0) return "插入成功";
//        else return "插入失败";
//    }
//
//    //插入饼干信息
//    @ApiOperation(value = "插入饼干信息")
//    @PostMapping("/biscuits")
//    public String insertBiscuits(Biscuits biscuits){
//        int i = itemsMapper.insertBiscuits(biscuits);
//        if(i > 0) return "插入成功";
//        else return "插入失败";
//    }
//
//    //插入即食食品信息
//    @ApiOperation(value = "插入即食食品信息")
//    @PostMapping("/instantFoods")
//    public String insertInstantFoods(InstantFoods instantFoods){
//        int i = itemsMapper.insertInstantFoods(instantFoods);
//        if(i > 0) return "插入成功";
//        else return "插入失败";
//    }
//
//    //插入防护用品信息
//    @ApiOperation(value = "插入防护用品信息")
//    @PostMapping("/protectiveGears")
//    public String insertProtectiveGears(ProtectiveGears protectiveGears){
//        int i = itemsMapper.insertProtectiveGears(protectiveGears);
//        if(i > 0) return "插入成功";
//        else return "插入失败";
//    }
//
//    //插入膨化食品信息
//    @ApiOperation(value = "插入膨化食品信息")
//    @PostMapping("/puffedFoods")
//    public String insertPuffedFoods(PuffedFoods puffedFoods){
//        int i = itemsMapper.insertPuffedFoods(puffedFoods);
//        if(i > 0) return "插入成功";
//        else return "插入失败";
//    }
//
//    //更新饮料信息
//    @ApiOperation(value = "更新饮料信息")
//    @PutMapping("/drinks")
//    public String updateDrinks(Drinks drinks){
//        int i = itemsMapper.updateDrinks(drinks);
//        if(i > 0) return "更新成功";
//        else return "更新失败";
//    }
//
//    //更新饼干信息
//    @ApiOperation(value = "更新饼干信息")
//    @PutMapping("/biscuits")
//    public String updateBiscuits(Biscuits biscuits){
//        int i = itemsMapper.updateBiscuits(biscuits);
//        if(i > 0) return "更新成功";
//        else return "更新失败";
//    }
//
//    //更新即食食品信息
//    @ApiOperation(value = "更新即食食品信息")
//    @PutMapping("/instantFoods")
//    public String updateInstantFoods(InstantFoods instantFoods){
//        int i = itemsMapper.updateInstantFoods(instantFoods);
//        if(i > 0) return "更新成功";
//        else return "更新失败";
//    }
//
//    //更新防护用品信息
//    @ApiOperation(value = "更新防护用品信息")
//    @PutMapping("/protectiveGears")
//    public String updateProtectiveGears(ProtectiveGears protectiveGears){
//        int i = itemsMapper.updateProtectiveGears(protectiveGears);
//        if(i > 0) return "更新成功";
//        else return "更新失败";
//    }
//
//    //更新膨化食品信息
//    @ApiOperation(value = "更新膨化食品信息")
//    @PutMapping("/puffedFoods")
//    public String updatePuffedFoods(PuffedFoods puffedFoods){
//        int i = itemsMapper.updatePuffedFoods(puffedFoods);
//        if(i > 0) return "更新成功";
//        else return "更新失败";
//    }
//

//
//    //获取商品种类信息
//    @ApiOperation(value = "获取商品种类信息")
//    @GetMapping("/itemsType")
//    public List findAllItemsType(){
//        List<Type> list = itemsMapper.selectAllItemsTypes();
//        System.out.println(list);
//        return list;
//    }
//
//    //获取所有饮料信息
//    @ApiOperation(value = "获取所有饮料信息")
//    @GetMapping("/drinks")
//    public List findAllDrinks(){
//        List<Drinks> list = itemsMapper.selectAllDrinks();
//        System.out.println(list);
//        return list;
//    }
//
//    //获取所有饼干信息
//    @ApiOperation(value = "获取所有饼干信息")
//    @GetMapping("/biscuits")
//    public List findAllBiscuits(){
//        List<Biscuits> list = itemsMapper.selectAllBiscuits();
//        System.out.println(list);
//        return list;
//    }
//
//    //获取所有即食食品信息
//    @ApiOperation(value = "获取所有即食食品信息")
//    @GetMapping("/instantFood")
//    public List findAllInstantFood(){
//        List<InstantFoods> list = itemsMapper.selectAllInstantFood();
//        System.out.println(list);
//        return list;
//    }
//
//    //获取所有防护用品信息
//    @ApiOperation(value = "获取所有防护用品信息")
//    @GetMapping("/protectiveGears")
//    public List findAllProtectiveGears(){
//        List<ProtectiveGears> list = itemsMapper.selectAllProtectiveGears();
//        System.out.println(list);
//        return list;
//    }
//
//    //获取所有膨化食品信息
//    @ApiOperation(value = "获取所有膨化食品信息")
//    @GetMapping("/puffedFoods")
//    public List findAllPuffedFoods(){
//        List<PuffedFoods> list = itemsMapper.selectAllPuffedFoods();
//        System.out.println(list);
//        return list;
//    }
//
//    //根据id获取饮料信息
//    @ApiOperation(value = "根据id获取饮料信息")
//    @GetMapping("/drinks/{id}")
//    public Drinks findDrinksById(@PathVariable("id") Long id){
//        Drinks drinks = itemsMapper.selectDrinksById(id);
//        System.out.println(drinks);
//        return drinks;
//    }

    //TODO:实现根据标签查找商品
}
