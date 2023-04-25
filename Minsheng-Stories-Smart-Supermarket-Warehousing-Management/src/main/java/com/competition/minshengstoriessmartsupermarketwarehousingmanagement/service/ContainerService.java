package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.service;

import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.container.ContainerItems;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.order.OrderInfo;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.storeInfo.StoreInfo;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.StoresMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.containers.ContainersInfoMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.containers.ContainersMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.orders.OrdersInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContainerService {
    @Autowired
    private ContainersMapper containersMapper;
    @Autowired
    private ContainersInfoMapper containersInfoMapper;
    @Autowired
    private StoresMapper storesMapper;
    @Autowired
    private OrdersInfoMapper ordersInfoMapper;

    //从库存中向指定货柜添加指定库存编号和数量的商品
    public String insertItemsFromStore(Long storeItemID, Long containerID, Long amount){
        //从库存中减去指定库存编号和数量的商品
        StoreInfo storeInfo = storesMapper.selectById(storeItemID);
        if(storeInfo.getAmount() < amount)
            return "库存不足";
        //向指定货柜添加指定库存编号和数量的商品
        ContainerItems containerItems = new ContainerItems(storeInfo.getItemID(),storeInfo.getItemType(),containerID,amount,storeInfo.getValidDate(),storeInfo.getActuallyPrice(),storeInfo.getPurchasePrice());
        containersInfoMapper.insert(containerItems);
        //最后执行减少库存
        storesMapper.updateStoreNumberById(storeItemID, amount);
        return "添加成功";
    }

    //从根据订单号从货柜中售出商品
    public String SaleItemsFromContainer(Long orderID, Long containerID, Long itemID, String itemType, Long amount){
        //根据货柜id以及货柜商品id减去指定数量的商品
        ContainerItems containerItems = containersInfoMapper.selectContainerItemByContainerIdAndItemTypeAndItemId(containerID, itemType,itemID);
        if(containerItems.getAmount() < amount)
            return "库存不足";
        //根据订单号向订单信息表中添加指定数量的商品
        OrderInfo orderInfo = new OrderInfo(orderID, itemID, itemType, containerID, amount, containerItems.getActuallyPrice(), containerItems.getPurchasePrice());
        ordersInfoMapper.insert(orderInfo);
        //最后执行减去商品
        containersInfoMapper.updateContainerItemNumberById(containerItems.getContainerItemID(), amount);
        return "添加成功";
    }

}
