package com.license.licensingservice.repository;

import com.license.licensingservice.model.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License, String> {
     License findByLicenseId(String licenseId);

     List<License> findByOrganizationIdAndProductName(String organizationId, String productName);
}
