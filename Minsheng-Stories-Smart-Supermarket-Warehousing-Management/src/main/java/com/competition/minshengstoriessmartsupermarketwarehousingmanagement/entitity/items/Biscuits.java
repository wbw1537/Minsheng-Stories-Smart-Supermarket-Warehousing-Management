package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.items;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@TableName("biscuitsTable")
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
