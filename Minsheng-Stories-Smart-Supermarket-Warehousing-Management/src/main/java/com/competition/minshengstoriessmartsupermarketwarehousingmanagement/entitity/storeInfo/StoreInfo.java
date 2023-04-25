package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.storeInfo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("storeTable")
public class StoreInfo {
    private Long itemID;
    private String itemType;
    private Long amount;
    private Date validDate;
    private double actuallyPrice;
    @TableId(type = com.baomidou.mybatisplus.annotation.IdType.AUTO)
    private Long storeItemID;
    private Double purchasePrice;

    public StoreInfo(Long itemID, String itemType, Long amount, Date validDate, double actuallyPrice, Double purchasePrice) {
        this.itemID = itemID;
        this.itemType = itemType;
        this.amount = amount;
        this.validDate = validDate;
        this.actuallyPrice = actuallyPrice;
        this.purchasePrice = purchasePrice;
    }
    public StoreInfo(){};
    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public double getActuallyPrice() {
        return actuallyPrice;
    }

    public void setActuallyPrice(double actuallyPrice) {
        this.actuallyPrice = actuallyPrice;
    }

    public Long getStoreItemID() {
        return storeItemID;
    }

    public void setStoreItemID(Long storeItemID) {
        this.storeItemID = storeItemID;
    }
}