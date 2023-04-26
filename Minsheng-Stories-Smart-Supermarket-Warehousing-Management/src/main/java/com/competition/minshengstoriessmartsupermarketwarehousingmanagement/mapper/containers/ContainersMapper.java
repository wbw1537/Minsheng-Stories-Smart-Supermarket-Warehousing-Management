package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.containers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.container.ContainerItems;
import org.apache.ibatis.annotations.*;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.container.Containers;

import java.util.List;

@Mapper
public interface ContainersMapper extends BaseMapper<Containers>{




    //根据货柜信息表id查询货柜商品信息
    @Select("select * from containerContainsInfoTable where containerItemID = #{containerItemID}")
    ContainerItems selectContainerItemById(Long containerItemID);

    //根据货柜id查询该货柜商品信息
    @Select("select * from containerContainsInfoTable where containerID = #{containerID}")
    List<ContainerItems> selectContainerItemByContainerId(Long containerID);

    //根据货柜id获取货柜剩余容量
    @Select("select (containerVolume - containerCurrentVolume) as remainingCapacity from containersInfoTable where containerID = #{containerID}")
    Long getRemainingCapacityByContainerId(Long containerID);

    //根据货柜id，商品体积更改货柜容量
    @Update("update containersInfoTable set containerCurrentVolume = containerCurrentVolume + #{volume} where containerID = #{containerID}")
    public void updateContainerCurrentVolumeByContainerId(Long containerID, Long volume);
}
