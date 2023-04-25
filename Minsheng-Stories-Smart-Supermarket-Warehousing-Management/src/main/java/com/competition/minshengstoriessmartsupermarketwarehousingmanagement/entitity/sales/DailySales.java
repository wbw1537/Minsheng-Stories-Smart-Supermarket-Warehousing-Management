package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.sales;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

@TableName("dailySalesTable")
public class DailySales {
    @TableId(type = IdType.AUTO)
    private Long dailySalesID;
    private Long containerID;
    private double sales;
    private Long amount;
    private double actuallyPrice;
    private double purchasePrice;

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    @TableField(fill = FieldFill.INSERT)
    private Date date;
    private String itemType;
    private Long itemID;

    public Long getDailySalesID() {
        return dailySalesID;
    }

    public void setDailySalesID(Long dailySalesID) {
        this.dailySalesID = dailySalesID;
    }

    public Long getContainerID() {
        return containerID;
    }

    public void setContainerID(Long containerID) {
        this.containerID = containerID;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public double getActuallyPrice() {
        return actuallyPrice;
    }

    public void setActuallyPrice(double actuallyPrice) {
        this.actuallyPrice = actuallyPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

}
