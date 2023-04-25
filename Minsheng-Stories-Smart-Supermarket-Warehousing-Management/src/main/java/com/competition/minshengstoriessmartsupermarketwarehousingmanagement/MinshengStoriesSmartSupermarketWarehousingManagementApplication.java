package com.competition.minshengstoriessmartsupermarketwarehousingmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@MapperScan("com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper")
@SpringBootApplication
@EnableScheduling
public class MinshengStoriesSmartSupermarketWarehousingManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(MinshengStoriesSmartSupermarketWarehousingManagementApplication.class, args);
//		//建立每日任务，每晚0点执行
//		Timer timer = new Timer();
//		timer.schedule(new DailyOrderInput(), 0, 1000*60*60*24);
	}


}
