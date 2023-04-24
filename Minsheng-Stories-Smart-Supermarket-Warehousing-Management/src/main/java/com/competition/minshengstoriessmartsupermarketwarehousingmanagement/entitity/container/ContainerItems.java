package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.container;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.sql.Date;

public class ContainerItems {
    private Long itemID;
    private String itemType;
    private Long containerID;
    @TableId(type = IdType.AUTO)
    private Long containerItemID;
    private Long amount;

    private Date validDate;
    private double actuallyPrice;

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
