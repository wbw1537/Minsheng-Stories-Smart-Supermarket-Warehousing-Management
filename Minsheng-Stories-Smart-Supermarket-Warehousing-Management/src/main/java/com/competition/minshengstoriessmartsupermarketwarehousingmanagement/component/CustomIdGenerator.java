package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.component;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Component;

@Component
public class CustomIdGenerator implements IdentifierGenerator {

    private final AtomicLong al = new AtomicLong(1);
    @Override
    public Number nextId(Object entity) {
        return al.getAndIncrement();
    }

    @Override
    public String nextUUID(Object entity) {
        String key = entity.getClass().getSimpleName();
        return key + al.getAndIncrement();
    }
}
