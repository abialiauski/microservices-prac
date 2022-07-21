package org.micro.moexclient.service;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class MoexFeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}