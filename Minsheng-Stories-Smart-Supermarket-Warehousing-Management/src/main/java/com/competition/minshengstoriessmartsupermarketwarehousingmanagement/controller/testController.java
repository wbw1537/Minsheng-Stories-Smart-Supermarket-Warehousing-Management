package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.controller;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.testTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper.testMapper;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @Autowired
    private testMapper testMapper;

    @GetMapping("/tests")
    public List findAll(){
        List<testTable> list = testMapper.selectAll();
        System.out.println(list);
        return list;
    }
}
