package com.micro.ege.advert.advertservice.service;

import lombok.Data;

@Data
public class ListAdvertServiceInput {
    private String serviceProviderID;
    private String advertID;
    private Integer minPrice;
    private Short serviceStatus;
}
