package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.items;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("itemsTable")
public class ItemType {
    private String typeName;
    private Integer typeNumber;
    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(Integer typeNumber) {
        this.typeNumber = typeNumber;
    }
}
