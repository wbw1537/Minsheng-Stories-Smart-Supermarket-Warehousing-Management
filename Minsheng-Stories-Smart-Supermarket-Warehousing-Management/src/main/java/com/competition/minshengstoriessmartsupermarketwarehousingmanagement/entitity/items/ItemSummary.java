package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.items;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("itemSummaryTable")
public class ItemSummary {
    @TableId(type = com.baomidou.mybatisplus.annotation.IdType.AUTO)
    private Long itemSummaryID;
    private Long itemID;
    //商品种类
    private String itemType;
    //商品名称
    private String itemName;
    //描述
    private String itemDescription;
    //进货价格
    private double itemPurchasePrice;
    //推荐售价
    private double itemRecommendedPrice;
    private String itemSupplier;
    private String shelfLife;
    private int itemVolume;

    public ItemSummary(Long itemID, String itemType, String itemName, String itemDescription, double itemPurchasePrice, double itemRecommendedPrice, String itemSupplier, String shelfLife, int itemVolume) {
        this.itemID = itemID;
        this.itemType = itemType;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPurchasePrice = itemPurchasePrice;
        this.itemRecommendedPrice = itemRecommendedPrice;
        this.itemSupplier = itemSupplier;
        this.shelfLife = shelfLife;
        this.itemVolume = itemVolume;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    public int getItemVolume() {
        return itemVolume;
    }

    public void setItemVolume(int itemVolume) {
        this.itemVolume = itemVolume;
    }

    public ItemSummary() {
    }


    public Long getItemSummaryID() {
        return itemSummaryID;
    }

    public void setItemSummaryID(Long itemSummaryID) {
        this.itemSummaryID = itemSummaryID;
    }

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getItemPurchasePrice() {
        return itemPurchasePrice;
    }

    public void setItemPurchasePrice(double itemPurchasePrice) {
        this.itemPurchasePrice = itemPurchasePrice;
    }

    public double getItemRecommendedPrice() {
        return itemRecommendedPrice;
    }

    public void setItemRecommendedPrice(double itemRecommendedPrice) {
        this.itemRecommendedPrice = itemRecommendedPrice;
    }

    public String getItemSupplier() {
        return itemSupplier;
    }

    public void setItemSupplier(String itemSupplier) {
        this.itemSupplier = itemSupplier;
    }
}
