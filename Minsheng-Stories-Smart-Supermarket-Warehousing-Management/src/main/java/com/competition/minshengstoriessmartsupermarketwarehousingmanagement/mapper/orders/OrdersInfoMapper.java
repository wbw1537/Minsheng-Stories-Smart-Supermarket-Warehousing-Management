package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.orders;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.order.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface OrdersInfoMapper extends BaseMapper<OrderInfo> {
}
