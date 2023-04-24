package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.controller.containersController;

import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.container.ContainerItems;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.container.Containers;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.ContainersMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@Api(tags = "货柜管理")
@RestController
public class ContainersController {
    @Autowired
    private ContainersMapper containersMapper;

    //增加货柜信息
    @ApiOperation(value = "增加货柜")
    @PostMapping("/containers")
    public String insertContainers(Containers container){
        return containersMapper.insertContainer(container) > 0 ? "插入成功" : "插入失败";
    }

    //更新货柜信息
    @ApiOperation(value = "更新货柜")
    @PutMapping("/containers")
    public String updateContainers(Containers container){
        return containersMapper.updateContainer(container) > 0 ? "更新成功" : "更新失败";
    }

    //删除货柜信息
    @ApiOperation(value = "删除指定id货柜")
    @DeleteMapping("/containers/{id}")
    public String deleteContainersById(@PathVariable Long id){
        return containersMapper.deleteContainerById(id) > 0 ? "删除成功" : "删除失败";
    }

    //根据id查询货柜信息
    @ApiOperation(value = "根据id查询货柜")
    @GetMapping("/containers/{id}")
    public Containers selectContainersById(@PathVariable Long id){
        Containers containers = containersMapper.selectContainerById(id);
        System.out.println(containers);
        return containers;
    }

    //查询所有货柜信息
    @ApiOperation(value = "查询所有货柜")
    @GetMapping("/containers")
    public List selectAllContainers(){
        List<Containers> list = containersMapper.selectAllContainers();
        System.out.println(list);
        return list;
    }

    //增加货柜商品信息
    @ApiOperation(value = "增加货柜商品信息")
    @PostMapping("/containers/items")
    public String insertContainersItems(ContainerItems items){
        return containersMapper.insertContainerItem(items) > 0 ? "插入成功" : "插入失败";
    }

    //更新货柜商品信息
    @ApiOperation(value = "更新货柜商品信息")
    @PutMapping("/containers/items")
    public String updateContainersItems(ContainerItems items){
        return containersMapper.updateContainerItem(items) > 0 ? "更新成功" : "更新失败";
    }

    //删除指定id货柜商品信息
    @ApiOperation(value = "删除指定id货柜商品信息")
    @DeleteMapping("/containers/items/{id}")
    public String deleteContainersItemsById(@PathVariable Long id){
        return containersMapper.deleteContainerItemById(id) > 0 ? "删除成功" : "删除失败";
    }

    //根据货柜信息表id查询货柜商品信息
    @ApiOperation(value = "根据货柜信息表id(containerContainsInfo.containerItemID)查询该商品信息")
    @GetMapping("/containers/items/itemID/{id}")
    public ContainerItems selectContainersItemsById(@PathVariable Long id){
        ContainerItems items = containersMapper.selectContainerItemById(id);
        System.out.println(items);
        return items;
    }

    //根据货柜id查询该货柜商品信息
    @ApiOperation(value = "根据货柜id查询该货柜所有商品信息")
    @GetMapping("/containers/items/containerID/{id}")
    public List<ContainerItems> selectContainersItemsByContainerId(@PathVariable Long id){
        List<ContainerItems> items = containersMapper.selectContainerItemByContainerId(id);
        System.out.println(items);
        return items;
    }
}