package com.sql.ehr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan("com.sql.ehr.dao")
@EnableCaching
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启方法级安全验证
@EnableFeignClients
public class EhrApplication {

    public static void main(String[] args) {
        SpringApplication.run(EhrApplication.class, args);
    }

}
