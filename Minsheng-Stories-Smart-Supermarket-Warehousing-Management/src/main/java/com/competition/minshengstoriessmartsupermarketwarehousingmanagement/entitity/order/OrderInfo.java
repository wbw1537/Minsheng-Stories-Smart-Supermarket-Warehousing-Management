package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.order;

public class OrderInfo {
    private Long orderID;
    private Long itemID;
    private String itemType;
    private Long containerID;
    private Long amount;
    private Double actuallyPrice;

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
