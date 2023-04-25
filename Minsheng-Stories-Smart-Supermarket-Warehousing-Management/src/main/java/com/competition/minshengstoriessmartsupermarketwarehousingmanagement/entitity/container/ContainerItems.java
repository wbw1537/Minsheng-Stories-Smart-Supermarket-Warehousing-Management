package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.container;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("containerContainsInfoTable")
public class ContainerItems {
    private Long itemID;
    private String itemType;
    private Long containerID;
    @TableId(type = IdType.AUTO)
    private Long containerItemID;
    private Long amount;

    private Date validDate;
    private double actuallyPrice;
    private double purchasePrice;

    public ContainerItems(Long itemID, String itemType, Long containerID, Long amount, Date validDate, double actuallyPrice, double purchasePrice) {
        this.itemID = itemID;
        this.itemType = itemType;
        this.containerID = containerID;
        this.amount = amount;
        this.validDate = validDate;
        this.actuallyPrice = actuallyPrice;
        this.purchasePrice = purchasePrice;
    }

    public ContainerItems(){};
    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
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

    public Long getContainerID() {
        return containerID;
    }

    public void setContainerID(Long containerID) {
        this.containerID = containerID;
    }

    public Long getContainerItemID() {
        return containerItemID;
    }

    public void setContainerItemID(Long containerItemID) {
        this.containerItemID = containerItemID;
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
}
