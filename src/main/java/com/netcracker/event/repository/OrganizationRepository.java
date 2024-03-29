package com.netcracker.event.repository;


import com.netcracker.event.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, UUID> {
    Organization findByOrganizationId(UUID id);

    Organization findOrganizationByUserId(String id);

    Organization findOrganizationByEmail(String email);

    Organization findOrganizationByName(String name);
}