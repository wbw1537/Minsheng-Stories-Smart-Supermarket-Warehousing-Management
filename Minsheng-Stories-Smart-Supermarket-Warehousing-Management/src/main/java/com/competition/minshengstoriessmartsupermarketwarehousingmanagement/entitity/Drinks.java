package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity;

public class Drinks extends Items {
    //饮料类型（碳酸、果汁、乳制品、茶）
    private String drinkType;
    //包装类型（罐装、盒装、瓶装）
    private String drinkPackageType;

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public String getDrinkPackageType() {
        return drinkPackageType;
    }

    public void setDrinkPackageType(String drinkPackageType) {
        this.drinkPackageType = drinkPackageType;
    }
}
