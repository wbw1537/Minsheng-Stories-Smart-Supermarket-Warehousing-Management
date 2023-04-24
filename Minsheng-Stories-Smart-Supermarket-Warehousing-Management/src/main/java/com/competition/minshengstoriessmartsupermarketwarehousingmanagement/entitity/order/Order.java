package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.order;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

public class Order {
    private Long orderID;
    private Long containerID;
    private String orderStatus;
    private Long customerID;
    private String paymentInfo;
    private String orderName;
    private DateTimeLiteralExpression.DateTime orderTime;

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Long getContainerID() {
        return containerID;
    }

    public void setContainerID(Long containerID) {
        this.containerID = containerID;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public DateTimeLiteralExpression.DateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(DateTimeLiteralExpression.DateTime orderTime) {
        this.orderTime = orderTime;
    }
}
