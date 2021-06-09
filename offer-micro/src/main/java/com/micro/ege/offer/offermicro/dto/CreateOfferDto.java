package com.micro.ege.offer.offermicro.dto;

import lombok.Data;

@Data
public class CreateOfferDto {
    private String serviceProviderID;
    private String advertID;
    private String freeText;
    private Short serviceStatus;
    private Integer offerTime;
}
