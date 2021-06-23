package com.sql.webpages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
//@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启方法级安全验证
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class WebpagesApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebpagesApplication.class, args);
    }

}
