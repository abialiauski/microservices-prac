package org.micro.moexclient.controller;

import lombok.RequiredArgsConstructor;
import org.micro.moexclient.service.BondService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bonds")
@RequiredArgsConstructor
public class BondController {

    private final BondService bondService;

    @GetMapping("/govs")
    public String getGovBondsClient() {
        return bondService.getGovBonds();
    }

    @GetMapping("/corps")
    public String getCorpBondsClient() {
        return bondService.getCorpBonds();
    }
}