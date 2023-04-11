package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper;

import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface itemsMapper {

    //选取商品
    //选取饮料
    @Select("select * from drinksTable")
    List<Drinks> selectAllDrinks();
    //选取饼干
    @Select("select * from biscuitsTable")
    List<Biscuits> selectAllBiscuits();
    //选取即食食品
    @Select("select * from instantFoodTable")
    List<InstantFoods> selectAllInstantFood();
    //选取防护用品
    @Select("select * from protectiveGearTable")
    List<ProtectiveGears> selectAllProtectiveGears();
    //选取膨化食品
    @Select("select * from pufferFoodTable")
    List<PuffedFoods> selectAllPufferFoods();

    //从多个商品表中选取必要的信息进行汇总
    String selectAllItems = "SELECT itemsID,itemsType,itemNames,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier FROM storehouse.drinkTable\n" +
            "union\n" +
            "select itemsID,itemsType,itemNames,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier from storehouse.biscuitsTable\n" +
            "union\n" +
            "select itemsID,itemsType,itemNames,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier from storehouse.puffedFoodTable\n" +
            "union\n" +
            "select itemsID,itemsType,itemNames,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier from storehouse.protectiveGearTable\n" +
            "union\n" +
            "select itemsID,itemsType,itemNames,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier from storehouse.instantFoodTable\n" +
            ";";
    @Select(selectAllItems)
    List<Items> selectAllItems();

    //添加商品

    //添加饮料
    @Insert("Insert into drinksTable (itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,drinkType,drinkPackageType) values (#{itemID},#{itemType},#{itemName},#{itemDescription},#{itemPurchasePrice},#{itemRecommendedPrice},#{itemStock},#{itemSupplier},#{drinkType},#{drinkPackageType})")
    public int insertDrinks(Drinks drinks);

    //添加饼干
    @Insert("Insert into biscuitsTable (itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,tasteType,packageType) values (#{itemID},#{itemType},#{itemName},#{itemDescription},#{itemPurchasePrice},#{itemRecommendedPrice},#{itemStock},#{itemSupplier},#{tasteType},#{packageType})")
    public int insertBiscuits(Biscuits biscuits);

    //添加即食食品
    @Insert("Insert into instantFoodsTable (itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,tasteType,packageType,eatingMethodType) values (#{itemID},#{itemType},#{itemName},#{itemDescription},#{itemPurchasePrice},#{itemRecommendedPrice},#{itemStock},#{itemSupplier},#{tasteType},#{packageType},#{eatingMethodType})")
    public int insertInstantFoods(InstantFoods instantFoods);

    //添加防护用品
    @Insert("Insert into protectiveGearsTable (itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,useageType) values (#{itemID},#{itemType},#{itemName},#{itemDescription},#{itemPurchasePrice},#{itemRecommendedPrice},#{itemStock},#{itemSupplier},#{useageType})")
    public int insertProtectiveGears(ProtectiveGears protectiveGears);

    //添加膨化食品
    @Insert("Insert into puffedFoodsTable (itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,puffedFoodType,packageType) values (#{itemID},#{itemType},#{itemName},#{itemDescription},#{itemPurchasePrice},#{itemRecommendedPrice},#{itemStock},#{itemSupplier},#{puffedFoodType},#{packageType})")
    public int insertPuffedFoods(PuffedFoods puffedFoods);
}

