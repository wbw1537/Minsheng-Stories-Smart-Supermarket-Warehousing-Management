package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.order;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("ordersInfoTable")
public class OrderInfo {
    private Long orderID;
    private Long itemID;
    private String itemType;
    private Long containerID;
    private Long amount;
    private Double actuallyPrice;

    private Double purchasePrice;

    public OrderInfo(Long orderID, Long itemID, String itemType, Long containerID, Long amount, Double actuallyPrice, Double purchasePrice) {
        this.orderID = orderID;
        this.itemID = itemID;
        this.itemType = itemType;
        this.containerID = containerID;
        this.amount = amount;
        this.actuallyPrice = actuallyPrice;
        this.purchasePrice = purchasePrice;
    }

    public OrderInfo() {
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
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

    public Long getContainerID() {
        return containerID;
    }

    public void setContainerID(Long containerID) {
        this.containerID = containerID;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Double getActuallyPrice() {
        return actuallyPrice;
    }

    public void setActuallyPrice(Double actuallyPrice) {
        this.actuallyPrice = actuallyPrice;
    }
}
