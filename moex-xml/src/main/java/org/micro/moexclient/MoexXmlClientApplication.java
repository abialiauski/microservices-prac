package org.micro.moexclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
public class MoexXmlClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoexXmlClientApplication.class, args);
    }
}