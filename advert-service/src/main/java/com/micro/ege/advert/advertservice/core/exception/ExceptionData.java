package com.micro.ege.advert.advertservice.core.exception;

public class ExceptionData {
    Long errCode;
    String errMessage;

    public ExceptionData(Long code, String msg) {
        this.errCode = code;
        this.errMessage = msg;
    }
}
