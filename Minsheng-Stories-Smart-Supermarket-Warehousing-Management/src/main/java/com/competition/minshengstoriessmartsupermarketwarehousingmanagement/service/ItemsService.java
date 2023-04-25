package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.items.Drinks;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.items.ItemType;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.items.Items;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.items.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemsService {
    @Autowired
    private ItemsMapper itemsMapper;
    @Autowired
    private BiscuitsMapper biscuitsMapper;
    @Autowired
    private DrinksMapper drinksMapper;
    @Autowired
    private PuffedFoodsMapper puffedFoodsMapper;
    @Autowired
    private ProtectiveGearsMapper protectiveGearsMapper;
    @Autowired
    private InstantFoodsMapper instantFoodsMapper;

    //返回商品种类及占比
    public List<Map<String, Object>> getItemTypePercentage() {
        QueryWrapper<ItemType> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("typeName", "typeNumber");
        List<ItemType> itemsTableList = itemsMapper.selectList(queryWrapper);

        int totalItems = itemsTableList.stream().mapToInt(ItemType::getTypeNumber).sum();

        List<Map<String, Object>> itemTypePercentageList = itemsTableList.stream().map(item -> {
            double percentage = ((double) item.getTypeNumber() / totalItems) * 100;
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("typeName", item.getTypeName());
            resultMap.put("percentage", percentage);
            return resultMap;
        }).collect(Collectors.toList());

        return itemTypePercentageList;
    }

    //获取所有商品信息的通用属性
    public List findAll(){
        List<Items> list = itemsMapper.selectAllItems();
        System.out.println(list);
        return list;
    }
}
