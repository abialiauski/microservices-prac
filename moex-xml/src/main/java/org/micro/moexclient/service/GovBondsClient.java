package org.micro.moexclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "govbond", url = "${moex.bonds.government.url}", configuration = MoexFeignConfig.class)
public interface GovBondsClient {

    @GetMapping
    String getBondsFromMoex();
}