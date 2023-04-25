package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.storeInfo.StoreInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StoresMapper extends BaseMapper<StoreInfo> {
    //根据库存id及取出数量更新库存
    @Update("update storeTable set amount = amount - #{number} where storeItemID = #{storeID}")
    int updateStoreNumberById(Long storeID, Long number);
}
