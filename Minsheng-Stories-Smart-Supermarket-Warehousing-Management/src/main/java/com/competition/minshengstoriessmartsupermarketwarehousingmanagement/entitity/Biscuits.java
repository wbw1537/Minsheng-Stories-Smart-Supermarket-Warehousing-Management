package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity;

public class Biscuits extends Items {
    //口感（软、脆、酥）
    private String tasteType;
    //包装（盒装、袋装）
    private String packageType;

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
}
