package com.stakhiyevich.microservicestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class MicroservicestudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicestudyApplication.class, args);
    }

}
