package com.micro.ege.offer.offermicro.core.exception;

public class OfferExceptions {
    public static ExceptionData OFFER_STATUS_NOT_FOUND = new ExceptionData(1L,
            "Hizmet statüsü bulunamadı.");

    public static ExceptionData TIME_IS_FILLED_ALREADY = new ExceptionData(2L,
            "Bu servis sağlayıcı için belirtilen zaman aralığı halihazırda dolu durumdadır.");

    public static ExceptionData OFFER_NOT_FOUND = new ExceptionData(3L,
            "Bu ID ile bir hizmet kaydı bulunamadı.");

    public static ExceptionData STATUS_CHANGE_NOT_VALID = new ExceptionData(4L,
            "Hizmetin şu anki statüsü yeni statüye geçmek için uygun değildir.");

    public static ExceptionData BAD_LIST_OFFER_REQUEST = new ExceptionData(5L,
            "Gönderilen istek listeleme işlemi için uygun değildir.");
}
