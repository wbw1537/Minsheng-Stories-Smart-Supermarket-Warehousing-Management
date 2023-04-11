package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Items {

    @TableId(value = "itemID",type = IdType.AUTO)
    //pk,商品id
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
    //库存
    private int itemStock;
    //供应商（允许不同供应商同种商品存储在相同表）
    private String itemSupplier;

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

    public int getItemStock() {
        return itemStock;
    }

    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }

    public String getItemSupplier() {
        return itemSupplier;
    }

    public void setItemSupplier(String itemSupplier) {
        this.itemSupplier = itemSupplier;
    }
}
