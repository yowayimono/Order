package com.yowayimono.order_food;

import com.yowayimono.order_food.core.utils.RedisUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan("com.yowayimono.order_food.mapper")
public class OrderFoodApplication {

    public static void main(String[] args) {

        SpringApplication.run(OrderFoodApplication.class, args);
    }

}
