package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.items;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("protectiveGearsTable")
public class ProtectiveGears extends Items {
    //用途（消毒、防护、清洁）
    String usageType;

    public String getUsageType() {
        return usageType;
    }

    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }
}
