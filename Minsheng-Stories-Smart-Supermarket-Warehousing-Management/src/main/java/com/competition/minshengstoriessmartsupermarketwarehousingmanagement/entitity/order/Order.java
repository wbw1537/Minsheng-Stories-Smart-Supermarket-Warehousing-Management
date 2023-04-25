package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.order;

import com.baomidou.mybatisplus.annotation.*;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;

@TableName("ordersTable")
public class Order {
    private Long orderID;
    private Long containerID;
    private String orderStatus;
    private Long customerID;
    private String paymentInfo;
    private String orderName;
    @TableField(fill = FieldFill.INSERT)
    private Date orderTime;

    public Order() {
    }

    public Order(Long orderID, Long containerID, String orderStatus, Long customerID, String paymentInfo, String orderName) {
        this.orderID = orderID;
        this.containerID = containerID;
        this.orderStatus = orderStatus;
        this.customerID = customerID;
        this.paymentInfo = paymentInfo;
        this.orderName = orderName;
    }

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

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
