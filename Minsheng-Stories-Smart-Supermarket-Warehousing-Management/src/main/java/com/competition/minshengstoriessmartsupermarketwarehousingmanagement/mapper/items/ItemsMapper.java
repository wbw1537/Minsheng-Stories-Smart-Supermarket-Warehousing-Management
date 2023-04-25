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



}

