package com.stakhiyevich.organizationservice.controller;

import com.stakhiyevich.organizationservice.model.Organization;
import com.stakhiyevich.organizationservice.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @GetMapping(value = "/{organizationId}")
    public ResponseEntity<Organization> getOrganization(@PathVariable("organizationId") String organizationId) {
        return ResponseEntity.ok(organizationService.findById(organizationId));
    }

    @PutMapping(value = "/{organizationId}")
    public void updateOrganization(@PathVariable("organizationId") String id, @RequestBody Organization organization) {
        organizationService.update(organization);
    }

    @PostMapping
    public ResponseEntity<Organization> saveOrganization(@RequestBody Organization organization) {
        return ResponseEntity.ok(organizationService.create(organization));
    }

    @DeleteMapping(value = "/{organizationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable("id") String id, @RequestBody Organization organization) {
        organizationService.delete(organization);
    }
}
