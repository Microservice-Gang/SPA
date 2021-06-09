package com.micro.ege.offer.offermicro.service;

import lombok.Data;

@Data
public class CreateOfferServiceInput {
    private String serviceProviderID;
    private String advertID;
    private String freeText;
    private Short serviceStatus;
    private Integer offerTime;
}
