package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.service;

import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.items.ItemSummary;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.storeInfo.StoreInfo;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.StoresMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.items.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoresMapper storesMapper;
    @Autowired
    private ItemsMapper itemsMapper;
    //根据商品类型和id进货
    public String storeItems(String itemsType, Long itemsId, Long amount) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        //根据商品类型获取表名
        String itemTableName = itemsMapper.getTableNameByTypeName(itemsType);
        //根据商品表和id获取商品保质期
        String itemShelfLife = itemsMapper.getShelfLifeByItemID(itemTableName, itemsId);
        Date dateShelfLife = simpleDateFormat.parse(itemShelfLife);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateShelfLife);
        Date nowDate = new Date();
        calendar.add(Calendar.YEAR, nowDate.getYear()+1900);
        calendar.add(Calendar.MONTH, nowDate.getMonth());
        calendar.add(Calendar.DATE, nowDate.getDate()-1);
        dateShelfLife = calendar.getTime();
        //根据商品表和id获取商品成本价
        Double itemCostPrice = itemsMapper.getItemPurchasePriceByItemID(itemTableName, itemsId);
        //根据商品表和id获取商品推荐售价
        Double itemRecommendedPrice = itemsMapper.getItemRecommendedPriceByItemID(itemTableName, itemsId);
        StoreInfo storeInfo = new StoreInfo(itemsId, itemsType, amount, dateShelfLife, itemRecommendedPrice, itemCostPrice);
        storesMapper.insert(storeInfo);
        //添加商品表中商品库存
        itemsMapper.addItemStockByItemID(itemTableName, itemsId, amount);
        return "添加货品成功";
    }

    //选出保质期小于一周的商品库存
    public List<StoreInfo> getWarningOfPerishableItems(){
        return storesMapper.getWarningOfPerishableItems();
    }

    //获取所有库存信息
    public List<StoreInfo> getAllStoreInfo(){
        return storesMapper.selectList(null);
    }

}
