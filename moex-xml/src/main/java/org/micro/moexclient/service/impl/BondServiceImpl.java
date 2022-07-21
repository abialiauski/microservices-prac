package org.micro.moexclient.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.micro.moexclient.service.BondService;
import org.micro.moexclient.service.CorpBondsClient;
import org.micro.moexclient.service.GovBondsClient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BondServiceImpl implements BondService {

    private final GovBondsClient govBondsClient;
    private final CorpBondsClient corpBondsClient;
    private static final String GETTING_GOV_BONDS_FROM_MOEX = "Getting gov bonds from Moex";
    private static final String GETTING_CORPORATE_BONDS_FROM_MOEX = "Getting corporate bonds from Moex";

    @Cacheable(value = "govs")
    @Override
    public String getGovBonds() {
        log.info(GETTING_GOV_BONDS_FROM_MOEX);
        return govBondsClient.getBondsFromMoex();
    }

    @Cacheable(value = "corps")
    @Override
    public String getCorpBonds() {
        log.info(GETTING_CORPORATE_BONDS_FROM_MOEX);
        return corpBondsClient.getBondsFromMoex();
    }
}