package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity;

public class InstantFoods extends Items {
    //口感（酸、甜、辣）
    String tasteType;
    //包装（盒装、袋装）
    String packageType;
    //食用方式（泡、微波炉）
    String eatingMethodType;

    public String getTasteType() {
        return tasteType;
    }

    public void setTasteType(String tasteType) {
        this.tasteType = tasteType;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getEatingMethodType() {
        return eatingMethodType;
    }

    public void setEatingMethodType(String eatingMethodType) {
        this.eatingMethodType = eatingMethodType;
    }
}
