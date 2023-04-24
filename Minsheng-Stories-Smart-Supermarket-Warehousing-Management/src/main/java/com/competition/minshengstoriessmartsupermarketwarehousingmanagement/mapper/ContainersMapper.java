package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.container.ContainerItems;
import org.apache.ibatis.annotations.*;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.container.Containers;

import java.util.List;

@Mapper
public interface ContainersMapper {
    //增加货柜信息
    @Insert("insert into containersInfoTable (containerID, locateInfo, sales, containerType, containerStatus, containerVolume, containerCurrentVolume, containerName, containerDescription) values (#{containerID}, #{locateInfo}, #{sales}, #{containerType}, #{containerStatus}, #{containerVolume}, #{containerCurrentVolume}, #{containerName}, #{containerDescription})")
    int insertContainer(Containers container);

    //更新货柜信息
    @Update("update containersInfoTable set locateInfo = #{locateInfo}, sales = #{sales}, containerType = #{containerType}, containerStatus = #{containerStatus}, containerVolume = #{containerVolume}, containerCurrentVolume = #{containerCurrentVolume}, containerName = #{containerName}, containerDescription = #{containerDescription} where containerID = #{containerID}")
    int updateContainer(Containers container);

    //删除货柜信息
    @Delete("delete from containersInfoTable where containerID = #{containerID}")
    int deleteContainerById(Long containerID);

    //查询货柜信息
    @Select("select * from containersInfoTable where containerID = #{containerID}")
    Containers selectContainerById(Long containerID);

    //查询所有货柜信息
    @Select("select * from containersInfoTable")
    List<Containers> selectAllContainers();

    //增加货柜商品信息
    @Insert("insert into containerContainsInfoTable (itemID, itemType, containerID, amount, validDate, actuallyPrice, containerItemID) values (#{itemID}, #{itemType}, #{containerID}, #{amount}, #{validDate}, #{actuallyPrice}, #{containerItemID})")
    int insertContainerItem(ContainerItems containerItem);

    //更新货柜商品信息
    @Update("update containerContainsInfoTable set itemID = #{itemID}, itemType = #{itemType}, containerID = #{containerID}, amount = #{amount}, validDate = #{validDate}, actuallyPrice = #{actuallyPrice} where containerItemID = #{containerItemID}")
    int updateContainerItem(ContainerItems containerItem);

    //删除指定id货柜商品信息
    @Delete("delete from containerContainsInfoTable where containerItemID = #{containerItemID}")
    int deleteContainerItemById(Long containerItemID);

    //根据货柜信息表id查询货柜商品信息
    @Select("select * from containerContainsInfoTable where containerItemID = #{containerItemID}")
    ContainerItems selectContainerItemById(Long containerItemID);

    //根据货柜id查询该货柜商品信息
    @Select("select * from containerContainsInfoTable where containerID = #{containerID}")
    List<ContainerItems> selectContainerItemByContainerId(Long containerID);
}
