package com.license.licensingservice.service;

import com.license.licensingservice.model.License;
import com.license.licensingservice.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseService {
    @Autowired
    private LicenseRepository licenseRepository;

    public License getLicenseById(String licenseId){
        return licenseRepository.findByLicenseId(licenseId);
    }

    public List<License> getLicenseByOrganizationIdAndProductName(String organizationID, String productName){
        return licenseRepository.findByOrganizationIdAndProductName(organizationID,productName);
    }
}
