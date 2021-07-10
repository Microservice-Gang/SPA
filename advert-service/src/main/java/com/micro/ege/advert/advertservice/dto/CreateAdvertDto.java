package com.micro.ege.advert.advertservice.dto;

import lombok.Data;

@Data
public class CreateAdvertDto {
    private String advertName;
    private String serviceProviderID;
    private String summary;
    private Integer minPrice;
    private Integer advertCreateTime;
    private String category;
    private String city;
}
