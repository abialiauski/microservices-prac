package com.stakhiyevich.licenseservice.service.client;

import com.stakhiyevich.licenseservice.model.Organization;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrganizationDiscoveryClient {

    private static final String ORGANIZATION_SERVICE = "organizationservice";

    private final DiscoveryClient discoveryClient;

    public Organization getOrganization(String organizationId) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instanceList = discoveryClient.getInstances(ORGANIZATION_SERVICE);
        if (instanceList.isEmpty()) {
            return null;
        }
        String serviceUri = String.format("%s/v1/organization/%s", instanceList.get(0).getUri().toString(), organizationId);
        ResponseEntity<Organization> restExchange = restTemplate.exchange(serviceUri, HttpMethod.GET, null, Organization.class, organizationId);
        return restExchange.getBody();
    }

}
