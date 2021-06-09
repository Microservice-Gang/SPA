package com.micro.ege.offer.offermicro.core.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends Exception{
    Long errorCode;
    String errorMessage;
    public BusinessException(ExceptionData exceptionData) {
        this.errorCode = exceptionData.errCode;
        this.errorMessage = exceptionData.errMessage;
    }
}
