package com.micro.ege.offer.offermicro.core.utils;

public enum OfferStatus {
    SEND((short) 1),
    ACCEPTED((short)2),
    REJECTED((short)3),
    DONE((short)4),
    CANCELED((short)5),
    ;

    private short statcode;

    OfferStatus(short i) {
        this.statcode = i;
    }

    public short getStatcode() {
        return statcode;
    }

}
