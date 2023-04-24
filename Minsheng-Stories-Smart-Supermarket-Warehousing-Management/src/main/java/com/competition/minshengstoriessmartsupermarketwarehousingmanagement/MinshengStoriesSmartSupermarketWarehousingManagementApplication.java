package com.competition.minshengstoriessmartsupermarketwarehousingmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper")
@SpringBootApplication
public class MinshengStoriesSmartSupermarketWarehousingManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(MinshengStoriesSmartSupermarketWarehousingManagementApplication.class, args);
	}
}
