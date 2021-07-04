package com.micro.ege.advert.advertservice.dto;

import lombok.Data;

@Data
public class AdvertDetailsDto {
    private String advertName;
    private String serviceProviderID;
    private String advertID;
    private String summary;
    private Integer minPrice;
    private Short serviceStatus;
    private Integer advertCreateTime;
    private String category;
    private String city;
}
