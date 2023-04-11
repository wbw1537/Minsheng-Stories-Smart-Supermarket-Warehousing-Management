package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity;

public class PuffedFoods extends Items {
    //类型（薯片、虾条、...）
    String puffedFoodType;
    //包装（盒装、袋装）
    String packageType;

    public String getPuffedFoodType() {
        return puffedFoodType;
    }

    public void setPuffedFoodType(String puffedFoodType) {
        this.puffedFoodType = puffedFoodType;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }
}
