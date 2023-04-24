package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.storeInfo;

import java.sql.Date;

public class storeInfo {
    private Long storeID;
    private String itemType;
    private Long amount;
    private Date validDate;
    private double actuallyPrice;
    private Long storeItemID;

    public Long getStoreID() {
        return storeID;
    }

    public void setStoreID(Long storeID) {
        this.storeID = storeID;
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