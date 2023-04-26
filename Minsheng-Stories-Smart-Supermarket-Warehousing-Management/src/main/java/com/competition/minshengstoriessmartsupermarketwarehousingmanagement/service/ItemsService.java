package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.items.*;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.items.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemsService {
    @Autowired
    private ItemsMapper itemsMapper;
    @Autowired
    private ItemSummaryMapper itemSummaryMapper;
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
//    public ItemSummary(Long itemID, String itemType, String itemName, String itemDescription, double itemPurchasePrice, double itemRecommendedPrice, String itemSupplier, String shelfLife, int itemVolume) {
//        this.itemID = itemID;
//        this.itemType = itemType;
//        this.itemName = itemName;
//        this.itemDescription = itemDescription;
//        this.itemPurchasePrice = itemPurchasePrice;
//        this.itemRecommendedPrice = itemRecommendedPrice;
//        this.itemSupplier = itemSupplier;
//        this.shelfLife = shelfLife;
//        this.itemVolume = itemVolume;
//    }
    //添加饼干商品
    public String insertBiscuit(Biscuits biscuits){
        biscuitsMapper.insert(biscuits);
        ItemSummary itemSummary = new ItemSummary(biscuits.getItemID(),biscuits.getItemType(),biscuits.getItemName(),biscuits.getItemDescription(),biscuits.getItemPurchasePrice(),biscuits.getItemRecommendedPrice(),biscuits.getItemSupplier(),biscuits.getShelfLife(),biscuits.getItemVolume());
        itemSummaryMapper.insert(itemSummary);
        return "添加成功";
    }

    //添加饮料商品
    public String insertDrink(Drinks drinks){
        drinksMapper.insert(drinks);
        ItemSummary itemSummary = new ItemSummary(drinks.getItemID(),drinks.getItemType(),drinks.getItemName(),drinks.getItemDescription(),drinks.getItemPurchasePrice(),drinks.getItemRecommendedPrice(),drinks.getItemSupplier(),drinks.getShelfLife(),drinks.getItemVolume());
        itemSummaryMapper.insert(itemSummary);
        return "添加成功";
    }

    //添加膨化食品商品
    public String insertPuffedFood(PuffedFoods puffedFoods){
        puffedFoodsMapper.insert(puffedFoods);
        ItemSummary itemSummary = new ItemSummary(puffedFoods.getItemID(),puffedFoods.getItemType(),puffedFoods.getItemName(),puffedFoods.getItemDescription(),puffedFoods.getItemPurchasePrice(),puffedFoods.getItemRecommendedPrice(),puffedFoods.getItemSupplier(),puffedFoods.getShelfLife(),puffedFoods.getItemVolume());
        itemSummaryMapper.insert(itemSummary);
        return "添加成功";
    }

    //添加防护用品商品
    public String insertProtectiveGear(ProtectiveGears protectiveGears){
        protectiveGearsMapper.insert(protectiveGears);
        ItemSummary itemSummary = new ItemSummary(protectiveGears.getItemID(),protectiveGears.getItemType(),protectiveGears.getItemName(),protectiveGears.getItemDescription(),protectiveGears.getItemPurchasePrice(),protectiveGears.getItemRecommendedPrice(),protectiveGears.getItemSupplier(),protectiveGears.getShelfLife(),protectiveGears.getItemVolume());
        itemSummaryMapper.insert(itemSummary);
        return "添加成功";
    }

    //添加速食商品
    public String insertInstantFood(InstantFoods instantFoods){
        instantFoodsMapper.insert(instantFoods);
        ItemSummary itemSummary = new ItemSummary(instantFoods.getItemID(),instantFoods.getItemType(),instantFoods.getItemName(),instantFoods.getItemDescription(),instantFoods.getItemPurchasePrice(),instantFoods.getItemRecommendedPrice(),instantFoods.getItemSupplier(),instantFoods.getShelfLife(),instantFoods.getItemVolume());
        itemSummaryMapper.insert(itemSummary);
        return "添加成功";
    }

    //删除商品
    public String deleteItem(Long itemID,String itemType){
        String itemTableName = itemsMapper.getTableNameByTypeName(itemType);
        itemSummaryMapper.deleteItemSummaryByItemTypeAndItemID(itemType,itemID);
        itemsMapper.deleteItemByItemID(itemTableName,itemID);
        return "删除成功";
    }

    //修改饼干
    public String updateBiscuit(Biscuits biscuits){
        biscuitsMapper.updateById(biscuits);
        ItemSummary itemSummary = new ItemSummary(biscuits.getItemID(),biscuits.getItemType(),biscuits.getItemName(),biscuits.getItemDescription(),biscuits.getItemPurchasePrice(),biscuits.getItemRecommendedPrice(),biscuits.getItemSupplier(),biscuits.getShelfLife(),biscuits.getItemVolume());
        itemSummaryMapper.updateById(itemSummary);
        return "修改成功";
    }

    //修改饮料
    public String updateDrink(Drinks drinks){
        drinksMapper.updateById(drinks);
        ItemSummary itemSummary = new ItemSummary(drinks.getItemID(),drinks.getItemType(),drinks.getItemName(),drinks.getItemDescription(),drinks.getItemPurchasePrice(),drinks.getItemRecommendedPrice(),drinks.getItemSupplier(),drinks.getShelfLife(),drinks.getItemVolume());
        itemSummaryMapper.updateById(itemSummary);
        return "修改成功";
    }

    //修改膨化食品
    public String updatePuffedFood(PuffedFoods puffedFoods){
        puffedFoodsMapper.updateById(puffedFoods);
        ItemSummary itemSummary = new ItemSummary(puffedFoods.getItemID(),puffedFoods.getItemType(),puffedFoods.getItemName(),puffedFoods.getItemDescription(),puffedFoods.getItemPurchasePrice(),puffedFoods.getItemRecommendedPrice(),puffedFoods.getItemSupplier(),puffedFoods.getShelfLife(),puffedFoods.getItemVolume());
        itemSummaryMapper.updateById(itemSummary);
        return "修改成功";
    }

    //修改防护用品
    public String updateProtectiveGear(ProtectiveGears protectiveGears){
        protectiveGearsMapper.updateById(protectiveGears);
        ItemSummary itemSummary = new ItemSummary(protectiveGears.getItemID(),protectiveGears.getItemType(),protectiveGears.getItemName(),protectiveGears.getItemDescription(),protectiveGears.getItemPurchasePrice(),protectiveGears.getItemRecommendedPrice(),protectiveGears.getItemSupplier(),protectiveGears.getShelfLife(),protectiveGears.getItemVolume());
        itemSummaryMapper.updateById(itemSummary);
        return "修改成功";
    }

    //修改速食
    public String updateInstantFood(InstantFoods instantFoods) {
        instantFoodsMapper.updateById(instantFoods);
        ItemSummary itemSummary = new ItemSummary(instantFoods.getItemID(), instantFoods.getItemType(), instantFoods.getItemName(), instantFoods.getItemDescription(), instantFoods.getItemPurchasePrice(), instantFoods.getItemRecommendedPrice(), instantFoods.getItemSupplier(), instantFoods.getShelfLife(), instantFoods.getItemVolume());
        itemSummaryMapper.updateById(itemSummary);
        return "修改成功";
    }

}
