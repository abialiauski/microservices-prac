package org.micro.moexclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "corpbond", url = "${moex.bonds.corporate.url}", configuration = MoexFeignConfig.class)
public interface CorpBondsClient {

    @GetMapping
    String getBondsFromMoex();
}