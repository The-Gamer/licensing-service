package com.license.licensingservice.bean;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class LicenseBean {
    private final String organizationId;
    private final String licenseId;
    private  final String type;
    private  final String group;
}
