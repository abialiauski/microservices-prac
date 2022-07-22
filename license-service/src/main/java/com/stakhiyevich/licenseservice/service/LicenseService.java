package com.stakhiyevich.licenseservice.service;

import com.stakhiyevich.licenseservice.model.License;
import com.stakhiyevich.licenseservice.model.Organization;
import com.stakhiyevich.licenseservice.repository.LicenseRepository;
import com.stakhiyevich.licenseservice.service.client.OrganizationDiscoveryClient;
import com.stakhiyevich.licenseservice.service.client.OrganizationFeignClient;
import com.stakhiyevich.licenseservice.service.client.OrganizationRestTemplateClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class LicenseService {

    private static final String FEIGN = "feign";
    private static final String REST = "rest";
    private static final String DISCOVERY = "discovery";

    private final LicenseRepository licenseRepository;
    private final OrganizationFeignClient organizationFeignClient;
    private final OrganizationDiscoveryClient organizationDiscoveryClient;
    private final OrganizationRestTemplateClient organizationRestTemplateClient;

//    public License getLicense(String licenseId, String organizationId) {
//        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
//        if (license == null) {
//            throw new IllegalArgumentException("failed to find a license");
//        }
//        return license;
//    }

    public License getLicense(String licenseId, String organizationId, String clientType) {
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        if (license == null) {
            throw new IllegalArgumentException("failed to find a license");
        }
        Organization organization = retrieveOrganizationInfo(organizationId, clientType);
        if (organization != null) {
            license.setOrganizationName(organization.getName());
            license.setContactName(organization.getContactName());
            license.setContactEmail(organization.getContactEmail());
            license.setContactPhone(organization.getContactPhone());
        }
        return license;
    }

    public License createLicense(License license) {
        license.setLicenseId(UUID.randomUUID().toString());
        licenseRepository.save(license);
        return license;
    }

    public License updateLicense(License license) {
        licenseRepository.save(license);
        return license;
    }

    public String deleteLicense(String licenseId) {
        String responseMessage;
        License license = new License();
        license.setLicenseId(licenseId);
        licenseRepository.delete(license);
        responseMessage = "license has been deleted";
        return responseMessage;
    }

    private Organization retrieveOrganizationInfo(String organizationId, String clientType) {
        Organization organization;
        switch (clientType) {
            case FEIGN -> {
                log.info("The feign client has been used");
                organization = organizationFeignClient.getOrganization(organizationId);
            }
            case REST -> {
                log.info("The rest client has been used");
                organization = organizationRestTemplateClient.getOrganization(organizationId);
            }
            case DISCOVERY -> {
                log.info("The discovery client has been used");
                organization = organizationDiscoveryClient.getOrganization(organizationId);
            }
            default -> organization = organizationRestTemplateClient.getOrganization(organizationId);
        }
        return organization;
    }
}


