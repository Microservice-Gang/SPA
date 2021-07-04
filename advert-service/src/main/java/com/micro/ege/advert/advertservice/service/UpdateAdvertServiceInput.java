package com.micro.ege.advert.advertservice.service;

import lombok.Data;

@Data
public class UpdateAdvertServiceInput {
    private String advertName;
    private String advertID;
    private String serviceProviderID;
    private String summary;
    private Short serviceStatus;
    private Integer minPrice;
    private Integer advertCreateTime;
    private String category;
    private String city;
}
