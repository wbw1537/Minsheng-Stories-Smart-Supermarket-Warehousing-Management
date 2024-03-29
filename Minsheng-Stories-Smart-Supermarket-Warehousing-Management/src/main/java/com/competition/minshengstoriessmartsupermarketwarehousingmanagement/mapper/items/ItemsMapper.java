package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.items;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.items.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ItemsMapper extends BaseMapper<ItemType>{

    //从多个商品表中选取必要的信息进行汇总
    String selectAllItems =
            "SELECT itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,itemPicturePath FROM storehouse.drinksTable\n" +
            "union\n" +
            "select itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,itemPicturePath from storehouse.biscuitsTable\n" +
            "union\n" +
            "select itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,itemPicturePath from storehouse.puffedFoodsTable\n" +
            "union\n" +
            "select itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,itemPicturePath from storehouse.protectiveGearsTable\n" +
            "union\n" +
            "select itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,itemPicturePath from storehouse.instantFoodsTable\n" +
            ";";
    @Select(selectAllItems)
    List<Items> selectAllItems();

    //根据商品种类选取表名
    @Select("select itemsTable.tableName from itemsTable where typeName = #{typeName};")
    public String getTableNameByTypeName(@Param("typeName") String typeName);

    //根据商品类型、id选取商品保质期
    @Select("select shelfLife from ${tableName} where itemID = #{itemID};")
    public String getShelfLifeByItemID(@Param("tableName") String tableName,@Param("itemID") Long itemID);

    //根据商品类型、id选取商品成本价
    @Select("select itemPurchasePrice from ${tableName} where itemID = #{itemID};")
    public Double getItemPurchasePriceByItemID(@Param("tableName") String tableName,@Param("itemID") Long itemID);

    //根据商品类型、id选取商品推荐售价
    @Select("select itemRecommendedPrice from ${tableName} where itemID = #{itemID};")
    public Double getItemRecommendedPriceByItemID(@Param("tableName") String tableName,@Param("itemID") Long itemID);

    //根据商品类型、id添加商品库存
    @Update("update ${tableName} set itemStock = itemStock + #{itemStock} where itemID = #{itemID};")
    public void addItemStockByItemID(@Param("tableName") String tableName,@Param("itemID") Long itemID,@Param("itemStock") Long itemStock);

    //根据商品id，商品表名删除商品
    @Delete("delete from ${tableName} where itemID = #{itemID};")
    public void deleteItemByItemID(@Param("tableName") String tableName,@Param("itemID") Long itemID);


//    //选取商品
//    //选取饮料
//    @Select("select * from drinksTable")
//    List<Drinks> selectAllDrinks();
//    //选取饼干
//    @Select("select * from biscuitsTable")
//    List<Biscuits> selectAllBiscuits();
//    //选取即食食品
//    @Select("select * from instantFoodTable")
//    List<InstantFoods> selectAllInstantFood();
//    //选取防护用品
//    @Select("select * from protectiveGearTable")
//    List<ProtectiveGears> selectAllProtectiveGears();
//    //选取膨化食品
//    @Select("select * from pufferFoodTable")
//    List<PuffedFoods> selectAllPufferFoods();
//

//    //添加商品
//
//    //添加饮料
//    @Insert("Insert into drinksTable (itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,drinkType,drinkPackageType) values (#{itemID},#{itemType},#{itemName},#{itemDescription},#{itemPurchasePrice},#{itemRecommendedPrice},#{itemStock},#{itemSupplier},#{drinkType},#{drinkPackageType})")
//    public int insertDrinks(Drinks drinks);
//
//    //添加饼干
//    @Insert("Insert into biscuitsTable (itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,tasteType,packageType) values (#{itemID},#{itemType},#{itemName},#{itemDescription},#{itemPurchasePrice},#{itemRecommendedPrice},#{itemStock},#{itemSupplier},#{tasteType},#{packageType})")
//    public int insertBiscuits(Biscuits biscuits);
//
//    //添加即食食品
//    @Insert("Insert into instantFoodsTable (itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,tasteType,packageType,eatingMethodType) values (#{itemID},#{itemType},#{itemName},#{itemDescription},#{itemPurchasePrice},#{itemRecommendedPrice},#{itemStock},#{itemSupplier},#{tasteType},#{packageType},#{eatingMethodType})")
//    public int insertInstantFoods(InstantFoods instantFoods);
//
//    //添加防护用品
//    @Insert("Insert into protectiveGearsTable (itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,useageType) values (#{itemID},#{itemType},#{itemName},#{itemDescription},#{itemPurchasePrice},#{itemRecommendedPrice},#{itemStock},#{itemSupplier},#{useageType})")
//    public int insertProtectiveGears(ProtectiveGears protectiveGears);
//
//    //添加膨化食品
//    @Insert("Insert into puffedFoodsTable (itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,puffedFoodType,packageType) values (#{itemID},#{itemType},#{itemName},#{itemDescription},#{itemPurchasePrice},#{itemRecommendedPrice},#{itemStock},#{itemSupplier},#{puffedFoodType},#{packageType})")
//    public int insertPuffedFoods(PuffedFoods puffedFoods);
//
//    //删除商品
//
//    //删除饮料
//    @Insert("delete from drinksTable where itemID = #{itemID}")
//    public int deleteDrinks(Drinks drinks);
//
//    //删除饼干
//    @Insert("delete from biscuitsTable where itemID = #{itemID}")
//    public int deleteBiscuits(Biscuits biscuits);
//
//    //删除即食食品
//    @Insert("delete from instantFoodsTable where itemID = #{itemID}")
//    public int deleteInstantFoods(InstantFoods instantFoods);
//
//    //删除防护用品
//    @Insert("delete from protectiveGearsTable where itemID = #{itemID}")
//    public int deleteProtectiveGears(ProtectiveGears protectiveGears);
//
//    //删除膨化食品
//    @Insert("delete from puffedFoodsTable where itemID = #{itemID}")
//    public int deletePuffedFoods(PuffedFoods puffedFoods);
//
//    //修改商品
//
//    //修改饮料
//    @Update("update drinksTable set itemID = #{itemID},itemType = #{itemType},itemName = #{itemName},itemDescription = #{itemDescription},itemPurchasePrice = #{itemPurchasePrice},itemRecommendedPrice = #{itemRecommendedPrice},itemStock = #{itemStock},itemSupplier = #{itemSupplier},drinkType = #{drinkType},drinkPackageType = #{drinkPackageType} where itemID = #{itemID}")
//    public int updateDrinks(Drinks drinks);
//
//    //修改饼干
//    @Update("update biscuitsTable set itemID = #{itemID},itemType = #{itemType},itemName = #{itemName},itemDescription = #{itemDescription},itemPurchasePrice = #{itemPurchasePrice},itemRecommendedPrice = #{itemRecommendedPrice},itemStock = #{itemStock},itemSupplier = #{itemSupplier},tasteType = #{tasteType},packageType = #{packageType} where itemID = #{itemID}")
//    public int updateBiscuits(Biscuits biscuits);
//
//    //修改即食食品
//    @Update("update instantFoodsTable set itemID = #{itemID},itemType = #{itemType},itemName = #{itemName},itemDescription = #{itemDescription},itemPurchasePrice = #{itemPurchasePrice},itemRecommendedPrice = #{itemRecommendedPrice},itemStock = #{itemStock},itemSupplier = #{itemSupplier},tasteType = #{tasteType},packageType = #{packageType},eatingMethodType = #{eatingMethodType} where itemID = #{itemID}")
//    public int updateInstantFoods(InstantFoods instantFoods);
//
//    //修改防护用品
//    @Update("update protectiveGearsTable set itemID = #{itemID},itemType = #{itemType},itemName = #{itemName},itemDescription = #{itemDescription},itemPurchasePrice = #{itemPurchasePrice},itemRecommendedPrice = #{itemRecommendedPrice},itemStock = #{itemStock},itemSupplier = #{itemSupplier},useageType = #{useageType} where itemID = #{itemID}")
//    public int updateProtectiveGears(ProtectiveGears protectiveGears);
//
//    //修改膨化食品
//    @Update("update puffedFoodsTable set itemID = #{itemID},itemType = #{itemType},itemName = #{itemName},itemDescription = #{itemDescription},itemPurchasePrice = #{itemPurchasePrice},itemRecommendedPrice = #{itemRecommendedPrice},itemStock = #{itemStock},itemSupplier = #{itemSupplier},puffedFoodType = #{puffedFoodType},packageType = #{packageType} where itemID = #{itemID}")
//    public int updatePuffedFoods(PuffedFoods puffedFoods);
}

