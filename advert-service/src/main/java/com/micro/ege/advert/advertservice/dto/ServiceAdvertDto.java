package com.micro.ege.advert.advertservice.dto;

import lombok.Data;

@Data
public class ServiceAdvertDto {
    private String advertName;
    private String serviceProviderID;
    private String advertID;
    private String summary;
    private Short serviceStatus;
    private Integer minPrice;
    private Integer advertCreateTime;
}
