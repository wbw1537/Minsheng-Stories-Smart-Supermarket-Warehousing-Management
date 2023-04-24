package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper;

import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.items.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ItemsMapper {

    //选取商品
    //选取饮料
    @Select("select * from drinksTable")
    List<Drinks> selectAllDrinks();
    //选取饼干
    @Select("select * from biscuitsTable")
    List<Biscuits> selectAllBiscuits();
    //选取即食食品
    @Select("select * from instantFoodsTable")
    List<InstantFoods> selectAllInstantFood();
    //选取防护用品
    @Select("select * from protectiveGearsTable")
    List<ProtectiveGears> selectAllProtectiveGears();
    //选取膨化食品
    @Select("select * from puffedFoodsTable")
    List<PuffedFoods> selectAllPuffedFoods();

    //获取商品种类信息
    @Select("select * from itemsTable")
    List<Type> selectAllItemsTypes();

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

    //根据id获取饮料信息
    @Select("select * from drinksTable where itemID = #{itemID}")
    public Drinks selectDrinksById(Long itemID);

    //根据id获取饼干信息
    @Select("select * from biscuitsTable where itemID = #{itemID}")
    public Biscuits selectBiscuitsById(Long itemID);

    //根据id获取即食食品信息
    @Select("select * from instantFoodsTable where itemID = #{itemID}")
    public InstantFoods selectInstantFoodsById(Long itemID);

    //根据id获取防护用品信息
    @Select("select * from protectiveGearsTable where itemID = #{itemID}")
    public ProtectiveGears selectProtectiveGearsById(Long itemID);

    //根据id获取膨化食品信息
    @Select("select * from puffedFoodsTable where itemID = #{itemID}")
    public PuffedFoods selectPuffedFoodsById(Long itemID);



    //添加商品

    //添加饮料
    @Insert("Insert into drinksTable (itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,itemPicturePath,drinkType,drinkPackageType) values (#{itemID},#{itemType},#{itemName},#{itemDescription},#{itemPurchasePrice},#{itemRecommendedPrice},#{itemStock},#{itemSupplier},#{itemPicturePath},#{drinkType},#{drinkPackageType})")
    public int insertDrinks(Drinks drinks);

    //添加饼干
    @Insert("Insert into biscuitsTable (itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,itemPicturePath,tasteType,packageType) values (#{itemID},#{itemType},#{itemName},#{itemDescription},#{itemPurchasePrice},#{itemRecommendedPrice},#{itemStock},#{itemSupplier},#{itemPicturePath},#{tasteType},#{packageType})")
    public int insertBiscuits(Biscuits biscuits);

    //添加即食食品
    @Insert("Insert into instantFoodsTable (itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,itemPicturePath,tasteType,packageType,eatingMethodType) values (#{itemID},#{itemType},#{itemName},#{itemDescription},#{itemPurchasePrice},#{itemRecommendedPrice},#{itemStock},#{itemSupplier},#{itemPicturePath},#{tasteType},#{packageType},#{eatingMethodType})")
    public int insertInstantFoods(InstantFoods instantFoods);

    //添加防护用品
    @Insert("Insert into protectiveGearsTable (itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,itemPicturePath,usageType) values (#{itemID},#{itemType},#{itemName},#{itemDescription},#{itemPurchasePrice},#{itemRecommendedPrice},#{itemStock},#{itemSupplier},#{itemPicturePath},#{usageType})")
    public int insertProtectiveGears(ProtectiveGears protectiveGears);

    //添加膨化食品
    @Insert("Insert into puffedFoodsTable (itemID,itemType,itemName,itemDescription,itemPurchasePrice,itemRecommendedPrice,itemStock,itemSupplier,itemPicturePath,puffedFoodType,packageType) values (#{itemID},#{itemType},#{itemName},#{itemDescription},#{itemPurchasePrice},#{itemRecommendedPrice},#{itemStock},#{itemSupplier},#{itemPicturePath},#{puffedFoodType},#{packageType})")
    public int insertPuffedFoods(PuffedFoods puffedFoods);

    //删除商品

    //删除饮料
    @Insert("delete from drinksTable where itemID = #{itemID}")
    public int deleteDrinksById(Long itemID);

    //删除饼干
    @Insert("delete from biscuitsTable where itemID = #{itemID}")
    public int deleteBiscuitsById(Long itemID);

    //删除即食食品
    @Insert("delete from instantFoodsTable where itemID = #{itemID}")
    public int deleteInstantFoodsById(Long itemID);

    //删除防护用品
    @Insert("delete from protectiveGearsTable where itemID = #{itemID}")
    public int deleteProtectiveGearsById(Long itemID);

    //删除膨化食品
    @Insert("delete from puffedFoodsTable where itemID = #{itemID}")
    public int deletePuffedFoodsById(Long itemID);

    //修改商品

    //修改饮料
    @Update("update drinksTable set itemID = #{itemID},itemType = #{itemType},itemName = #{itemName},itemDescription = #{itemDescription},itemPurchasePrice = #{itemPurchasePrice},itemRecommendedPrice = #{itemRecommendedPrice},itemStock = #{itemStock},itemSupplier = #{itemSupplier},itemPicturePath = #{itemPicturePath},drinkType = #{drinkType},drinkPackageType = #{drinkPackageType} where itemID = #{itemID}")
    public int updateDrinks(Drinks drinks);

    //修改饼干
    @Update("update biscuitsTable set itemID = #{itemID},itemType = #{itemType},itemName = #{itemName},itemDescription = #{itemDescription},itemPurchasePrice = #{itemPurchasePrice},itemRecommendedPrice = #{itemRecommendedPrice},itemStock = #{itemStock},itemSupplier = #{itemSupplier},itemPicturePath = #{itemPicturePath},tasteType = #{tasteType},packageType = #{packageType} where itemID = #{itemID}")
    public int updateBiscuits(Biscuits biscuits);

    //修改即食食品
    @Update("update instantFoodsTable set itemID = #{itemID},itemType = #{itemType},itemName = #{itemName},itemDescription = #{itemDescription},itemPurchasePrice = #{itemPurchasePrice},itemRecommendedPrice = #{itemRecommendedPrice},itemStock = #{itemStock},itemSupplier = #{itemSupplier},itemPicturePath = #{itemPicturePath},tasteType = #{tasteType},packageType = #{packageType},eatingMethodType = #{eatingMethodType} where itemID = #{itemID}")
    public int updateInstantFoods(InstantFoods instantFoods);

    //修改防护用品
    @Update("update protectiveGearsTable set itemID = #{itemID},itemType = #{itemType},itemName = #{itemName},itemDescription = #{itemDescription},itemPurchasePrice = #{itemPurchasePrice},itemRecommendedPrice = #{itemRecommendedPrice},itemStock = #{itemStock},itemSupplier = #{itemSupplier},itemPicturePath = #{itemPicturePath},usageType = #{usageType} where itemID = #{itemID}")
    public int updateProtectiveGears(ProtectiveGears protectiveGears);

    //修改膨化食品
    @Update("update puffedFoodsTable set itemID = #{itemID},itemType = #{itemType},itemName = #{itemName},itemDescription = #{itemDescription},itemPurchasePrice = #{itemPurchasePrice},itemRecommendedPrice = #{itemRecommendedPrice},itemStock = #{itemStock},itemSupplier = #{itemSupplier},itemPicturePath = #{itemPicturePath},puffedFoodType = #{puffedFoodType},packageType = #{packageType} where itemID = #{itemID}")
    public int updatePuffedFoods(PuffedFoods puffedFoods);
}

