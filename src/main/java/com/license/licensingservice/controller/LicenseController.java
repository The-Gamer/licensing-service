package com.license.licensingservice.controller;

import com.license.licensingservice.bean.LicenseBean;
import com.license.licensingservice.model.License;
import com.license.licensingservice.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/organizations/{organizationId}")
public class LicenseController {
    @Value("${tracer.property:null}")
    private String tracerProperty;

    @Autowired
    private LicenseService licenseService;

    @RequestMapping(value = "/licenses/{licenseId}", method = RequestMethod.GET)
    public LicenseBean getLicense(@PathVariable String organizationId, @PathVariable String licenseId){
        return LicenseBean.builder()
                .licenseId(licenseId)
                .organizationId(organizationId)
                .group("CSATA")
                .type("DEMO")
                .build();
    }

    @RequestMapping(value = "/license/{licenseId}", method = RequestMethod.GET)
    public License getLicense(@PathVariable String licenseId){
        return licenseService.getLicenseById(licenseId);
    }

    @GetMapping(value = "/products/{productName}")
    public List<License> getLicenseByOrganizationIdAndProductName(@PathVariable String organizationId, @PathVariable
                                                                  String productName){
        return licenseService.getLicenseByOrganizationIdAndProductName(organizationId,productName);
    }
}
