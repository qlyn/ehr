package com.sql.ehr.external;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * XXXXXX
 *
 * @author 沈钦林
 * @date 2021/12/18 15:01
 */
@EnableFeignClients
@MapperScan("com.sql.ehr.external.dao")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class EhrExternalApplication {
    public static void main(String[] args) {
        SpringApplication.run(EhrExternalApplication.class, args);
    }
}
