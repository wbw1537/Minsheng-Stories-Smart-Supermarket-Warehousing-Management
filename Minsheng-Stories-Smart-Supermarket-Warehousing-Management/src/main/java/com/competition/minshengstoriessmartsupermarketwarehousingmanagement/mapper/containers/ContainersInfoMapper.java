package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.containers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.container.ContainerItems;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Mapper
public interface ContainersInfoMapper extends BaseMapper<ContainerItems> {
    //根据货柜id以及商品类型、商品id选取商品信息
    @Select("select * from containerContainsInfoTable where containerID = #{containerID} and itemType = #{itemType} and itemID = #{itemID}")
    public ContainerItems selectContainerItemByContainerIdAndItemTypeAndItemId(Long containerID, String itemType, Long itemID);

    //根据货柜商品id减去指定数量的商品
    @Update("update containerContainsInfoTable set amount = amount - #{number} where containerItemID = #{containerItemID}")
    public void updateContainerItemNumberById(Long containerItemID, Long number);


    //选出保质期小于一周的货柜库存
    @Select("select * from containerContainsInfoTable where validDate < date_add(curdate(),INTERVAL 1 week);")
    public List<ContainerItems> getWarningOfPerishableContainers();
}
