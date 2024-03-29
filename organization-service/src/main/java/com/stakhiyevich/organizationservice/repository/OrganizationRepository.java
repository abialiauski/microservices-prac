package com.stakhiyevich.organizationservice.repository;

import com.stakhiyevich.organizationservice.model.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, String> {
    Optional<Organization> findOrganizationById(String organizationId);
}
