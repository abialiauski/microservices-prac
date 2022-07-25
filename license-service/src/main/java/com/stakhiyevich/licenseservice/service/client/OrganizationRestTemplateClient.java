package com.stakhiyevich.licenseservice.service.client;

import com.stakhiyevich.licenseservice.model.Organization;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class OrganizationRestTemplateClient {

    private final RestTemplate restTemplate;

    public Organization getOrganization(String organizationId) {
        ResponseEntity<Organization> restExchange = restTemplate.exchange(
                // FIXME organizationservice repl with address from eureka UI
                "http://organizationservice/v1/organization/{organizationId}",
                HttpMethod.GET,
                null, Organization.class, organizationId
        );
        return restExchange.getBody();
    }
}
