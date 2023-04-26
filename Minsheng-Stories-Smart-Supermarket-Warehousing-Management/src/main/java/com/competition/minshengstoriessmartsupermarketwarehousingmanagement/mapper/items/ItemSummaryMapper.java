package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.items;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemSummaryMapper extends com.baomidou.mybatisplus.core.mapper.BaseMapper<com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.items.ItemSummary>{
    //根据商品类型，商品id删除商品
    @Delete("delete from itemsSummaryTable where itemType = #{itemType} and itemID = #{itemID}")
    public void deleteItemSummaryByItemTypeAndItemID(String itemType, Long itemID);

    //根据商品类型，商品id获取商品体积
    @Delete("select volume from itemsSummaryTable where itemType = #{itemType} and itemID = #{itemID}")
    public Long getItemVolumeByItemTypeAndItemID(String itemType, Long itemID);
}
