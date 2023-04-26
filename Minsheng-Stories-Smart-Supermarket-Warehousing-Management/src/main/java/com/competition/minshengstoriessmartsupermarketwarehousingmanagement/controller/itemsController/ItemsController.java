package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.controller.itemsController;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.items.*;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.items.ItemsMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.service.ItemsService;

@Api(tags = "商品接口")
@RestController
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    @Autowired
    private ItemsMapper itemsMapper;
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

    //添加饼干
    @ApiOperation(value = "添加饼干")
    @PostMapping("/items/biscuits")
    public String insertBiscuits(Biscuits biscuits){
        return itemsService.insertBiscuit(biscuits);
    }

    //添加饮料
    @ApiOperation(value = "添加饮料")
    @PostMapping("/items/drinks")
    public String insertDrinks(Drinks drinks){
        return itemsService.insertDrink(drinks);
    }

    //添加即食食品
    @ApiOperation(value = "添加即食食品")
    @PostMapping("/items/instantFoods")
    public String insertInstantFood(InstantFoods instantFood){
        return itemsService.insertInstantFood(instantFood);
    }

    //添加膨化食品
    @ApiOperation(value = "添加膨化食品")
    @PostMapping("/items/puffedFoods")
    public String insertPuffedFood(PuffedFoods puffedFood){
        return itemsService.insertPuffedFood(puffedFood);
    }

    //添加防护用品
    @ApiOperation(value = "添加防护用品")
    @PostMapping("/items/protectiveGears")
    public String insertProtectiveGear(ProtectiveGears protectiveGear){
        return itemsService.insertProtectiveGear(protectiveGear);
    }

    //根据商品id以及商品类型删除商品
    @ApiOperation(value = "删除商品")
    @DeleteMapping("/items/{itemType}/{itemID}")
    public String deleteItem(@PathVariable("itemID") Long itemID, @PathVariable("itemType") String itemType){
        return itemsService.deleteItem(itemID, itemType);
    }

    //修改饼干信息
    @ApiOperation(value = "修改饼干信息")
    @PutMapping("/items/biscuits")
    public String updateBiscuits(Biscuits biscuits){
        return itemsService.updateBiscuit(biscuits);
    }

    //修改饮料信息
    @ApiOperation(value = "修改饮料信息")
    @PutMapping("/items/drinks")
    public String updateDrinks(Drinks drinks){
        return itemsService.updateDrink(drinks);
    }

    //修改即食食品信息
    @ApiOperation(value = "修改即食食品信息")
    @PutMapping("/items/instantFoods")
    public String updateInstantFoods(InstantFoods instantFoods){
        return itemsService.updateInstantFood(instantFoods);
    }

    //修改膨化食品信息
    @ApiOperation(value = "修改膨化食品信息")
    @PutMapping("/items/puffedFoods")
    public String updatePuffedFoods(PuffedFoods puffedFoods){
        return itemsService.updatePuffedFood(puffedFoods);
    }

    //修改防护用品信息
    @ApiOperation(value = "修改防护用品信息")
    @PutMapping("/items/protectiveGears")
    public String updateProtectiveGears(ProtectiveGears protectiveGears){
        return itemsService.updateProtectiveGear(protectiveGears);
    }


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
//        List<PuffedFoods> list = itemsMapper.selectAllPufferFoods();
//        System.out.println(list);
//        return list;
//    }
//

    //TODO:实现根据标签查找商品
}
