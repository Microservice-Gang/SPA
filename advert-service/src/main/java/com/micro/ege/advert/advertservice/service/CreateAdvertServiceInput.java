package com.micro.ege.advert.advertservice.service;

import lombok.Data;

@Data
public class CreateAdvertServiceInput {
    private String serviceProviderID;
    private String advertID;
    private String advertName;
    private String summary;
    private Short serviceStatus;
    private Integer minPrice;
    private Integer advertCreateTime;
}
