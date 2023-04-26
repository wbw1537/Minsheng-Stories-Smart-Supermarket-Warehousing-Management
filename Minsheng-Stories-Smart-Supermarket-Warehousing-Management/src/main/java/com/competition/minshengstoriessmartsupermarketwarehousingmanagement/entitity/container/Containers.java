package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.container;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("containersInfoTable")
public class Containers {
    @TableId(type = IdType.AUTO)
    private Long containerID;
    private double sales;
    private String locateInfo;
    private String containerType;
    private String containerStatus;
    private double containerVolume;
    private double containerCurrentVolume;
    private String containerName;
    private String containerDescription;

    public Containers(Long containerID) {
    }

    public Containers(double sales, String locateInfo, String containerType, String containerStatus, double containerVolume, double containerCurrentVolume, String containerName, String containerDescription) {
        this.sales = sales;
        this.locateInfo = locateInfo;
        this.containerType = containerType;
        this.containerStatus = containerStatus;
        this.containerVolume = containerVolume;
        this.containerCurrentVolume = containerCurrentVolume;
        this.containerName = containerName;
        this.containerDescription = containerDescription;
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

    public String getLocateInfo() {
        return locateInfo;
    }

    public void setLocateInfo(String locateInfo) {
        this.locateInfo = locateInfo;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public String getContainerStatus() {
        return containerStatus;
    }

    public void setContainerStatus(String containerStatus) {
        this.containerStatus = containerStatus;
    }

    public double getContainerVolume() {
        return containerVolume;
    }

    public void setContainerVolume(double containerVolume) {
        this.containerVolume = containerVolume;
    }

    public double getContainerCurrentVolume() {
        return containerCurrentVolume;
    }

    public void setContainerCurrentVolume(double containerCurrentVolume) {
        this.containerCurrentVolume = containerCurrentVolume;
    }

    public String getContainerName() {
        return containerName;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    public String getContainerDescription() {
        return containerDescription;
    }

    public void setContainerDescription(String containerDescription) {
        this.containerDescription = containerDescription;
    }
}
