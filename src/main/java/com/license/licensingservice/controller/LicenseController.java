package com.license.licensingservice.controller;

import com.license.licensingservice.bean.LicenseBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/organizations/{organizationId}")
public class LicenseController {
    @Value("${tracer.property}")
    private String tracerProperty;

    @RequestMapping(value = "/licenses/{licenseId}", method = RequestMethod.GET)
    public LicenseBean getLicense(@PathVariable String organizationId, @PathVariable String licenseId){
        return LicenseBean.builder()
                .licenseId(licenseId)
                .organizationId(organizationId)
                .group("CSATA")
                .type("DEMO")
                .build();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testConfig(){
        return tracerProperty;
    }
}
