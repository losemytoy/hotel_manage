package com.yiming.hotel_manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/yiming/hotel_manage/mapper")
public class HotelManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelManageApplication.class, args);
    }

}
