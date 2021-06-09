package com.micro.ege.offer.offermicro.service;

import lombok.Data;

@Data
public class CreateOfferServiceOutput {
    private Boolean isSucceeded;
    private Long errorCode;
    private String errorMessage;
}
