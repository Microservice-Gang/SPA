package com.micro.ege.offer.offermicro.dto;

import lombok.Data;

@Data
public class OfferDetails {
    private String offerID;
    private String serviceProviderID;
    private String advertID;
    private String freeText;
    private Short serviceStatus;
    private Integer offerTime;
    private Long errorCode;
    private String errorMessage;
}
