package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.items.ItemSummary;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.storeInfo.StoreInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StoresMapper extends BaseMapper<StoreInfo> {
    //根据库存id及取出数量更新库存
    @Update("update storeTable set amount = amount - #{number} where storeItemID = #{storeID}")
    int updateStoreNumberById(Long storeID, Long number);

    //选出保质期小于一周的商品库存
    @Select("select * from storeTable where validDate < date_add(curdate(),INTERVAL 1 week);")
    List<StoreInfo> getWarningOfPerishableItems();

    //根据库存id获取商品id
    @Select("select itemID from storeTable where storeItemID = #{storeItemID}")
    Long getItemIDByStoreItemID(Long storeItemID);

    //根据库存id获取商品类型
    @Select("select itemType from storeTable where storeItemID = #{storeItemID}")
    String getItemTypeByStoreItemID(Long storeItemID);

}
