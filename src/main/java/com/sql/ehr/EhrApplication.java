package com.sql.ehr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.sql.ehr.dao")
@EnableCaching
public class EhrApplication {

    public static void main(String[] args) {
        SpringApplication.run(EhrApplication.class, args);
    }

}
