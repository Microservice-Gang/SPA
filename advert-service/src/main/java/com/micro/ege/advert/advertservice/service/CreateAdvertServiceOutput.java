package com.micro.ege.advert.advertservice.service;

import lombok.Data;

@Data
public class CreateAdvertServiceOutput {
    private Boolean isSucceeded;
    private Long errorCode;
    private String errorMessage;
}
