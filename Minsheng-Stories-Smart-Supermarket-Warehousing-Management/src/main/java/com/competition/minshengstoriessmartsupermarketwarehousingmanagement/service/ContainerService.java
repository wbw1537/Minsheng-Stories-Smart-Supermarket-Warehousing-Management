package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.service;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.container.ContainerItems;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.container.Containers;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.order.OrderInfo;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.storeInfo.StoreInfo;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.StoresMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.containers.ContainersInfoMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.containers.ContainersMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.items.ItemSummaryMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.orders.OrdersInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
    @Autowired
    private ItemSummaryMapper itemSummaryMapper;

    //从库存中向指定货柜添加指定库存编号和数量的商品
    public String insertItemsFromStore(Long storeItemID, Long containerID, Long amount){
        //从库存中减去指定库存编号和数量的商品
        StoreInfo storeInfo = storesMapper.selectById(storeItemID);
        if(storeInfo.getAmount() < amount)
            return "库存不足";
        //计算商品所需总体积
        Long itemID = storesMapper.getItemIDByStoreItemID(storeItemID);
        String itemType = storesMapper.getItemTypeByStoreItemID(storeItemID);
        Long volume = itemSummaryMapper.getItemVolumeByItemTypeAndItemID(itemType, itemID);
        Long requiredVolume = volume * amount;
        //根据货柜id获取货柜剩余容量
        Long remainingVolume = containersMapper.getRemainingCapacityByContainerId(containerID);
        //计算剩余容量是否足够
        if(remainingVolume < requiredVolume)
            return "货柜容量不足";
        //向指定货柜添加指定库存编号和数量的商品
        ContainerItems containerItems = new ContainerItems(storeInfo.getItemID(),storeInfo.getItemType(),containerID,amount,storeInfo.getValidDate(),storeInfo.getActuallyPrice(),storeInfo.getPurchasePrice());
        containersInfoMapper.insert(containerItems);
        //根据商品所需体积修改货柜容量
        containersMapper.updateContainerCurrentVolumeByContainerId(containerID, requiredVolume);
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
        //计算商品所需总体积
        Long volume = itemSummaryMapper.getItemVolumeByItemTypeAndItemID(itemType, itemID);
        Long requiredVolume = volume * amount;
        //根据订单号向订单信息表中添加指定数量的商品
        OrderInfo orderInfo = new OrderInfo(orderID, itemID, itemType, containerID, amount, containerItems.getActuallyPrice(), containerItems.getPurchasePrice());
        ordersInfoMapper.insert(orderInfo);
        //根据商品所需体积减少货柜容量
        containersMapper.updateContainerCurrentVolumeByContainerId(containerID, -requiredVolume);
        //最后执行减去商品
        containersInfoMapper.updateContainerItemNumberById(containerItems.getContainerItemID(), amount);
        return "添加成功";
    }

    //选出保质期小于一周的货柜商品
    public List<ContainerItems> getWarningOfPerishableItems(){
        return containersInfoMapper.getWarningOfPerishableContainers();
    }

    //添加货柜
    public String addContainer(Long containerID, String LocateInfo, String containerType, String containerStatus, String containerName, String containerDescription, Double containerVolume){
        Containers containers = new Containers(containerID, LocateInfo, containerType, containerStatus, containerVolume, 0, containerName, containerDescription);
        containersMapper.insert(containers);
        return "添加成功";
    }

    //删除货柜
    public String deleteContainer(Long containerID){
        containersMapper.deleteById(containerID);
        return "删除成功";
    }

    //修改货柜
    public String updateContainer(Containers container){
        //Containers containers = new Containers(containerID, LocateInfo, containerType, containerStatus, containerVolume, 0, containerName, containerDescription);
        containersMapper.updateById(container);
        return "修改成功";
    }

    //获取所有货柜
    public List<Containers> getAllContainers(){
        return containersMapper.selectList(null);
    }

    //根据货柜id获取货柜信息
    public Containers getContainerById(Long containerID){
        return containersMapper.selectById(containerID);
    }

}
