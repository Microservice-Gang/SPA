package com.micro.ege.offer.offermicro.core.exception;

public class OfferExceptions {
    public static ExceptionData OFFER_STATUS_NOT_FOUND = new ExceptionData(1L,
            "Hizmet statüsü bulunamadı.");
    public static ExceptionData TIME_IS_FILLED_ALREADY = new ExceptionData(2L,
            "Bu servis sağlayıcı için belirtilen zaman aralığı halihazırda dolu durumdadır.");
}
