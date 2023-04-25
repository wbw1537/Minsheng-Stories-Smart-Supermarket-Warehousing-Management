package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Date yesterday = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        this.fillStrategy( metaObject, "orderTime",new Date());
        this.fillStrategy(metaObject,"date",yesterday);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
