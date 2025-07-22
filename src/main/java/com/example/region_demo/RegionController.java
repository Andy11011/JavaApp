package com.example.region_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amazonaws.util.EC2MetadataUtils;

@RestController
public class RegionController {

    @GetMapping("/region")
    public String getRegionAndAZ() {
        String az = null, region = null;
        try {
            az = EC2MetadataUtils.getAvailabilityZone();
            region = EC2MetadataUtils.getEC2InstanceRegion();
        } catch (Exception e) {
            return "Unable to retrieve EC2 metadata: " + e.getMessage();
        }
        return String.format("Region: %s, Availability Zone: %s", region, az);
    }
}