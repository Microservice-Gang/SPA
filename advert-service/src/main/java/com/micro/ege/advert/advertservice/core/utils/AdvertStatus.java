package com.micro.ege.advert.advertservice.core.utils;

public enum AdvertStatus {
    SEND((short) 1),
    ACCEPTED((short)2),
    REJECTED((short)3),
    DONE((short)4),
    CANCELED((short)5),
    ;

    private short statcode;

    AdvertStatus(short i) {
        this.statcode = i;
    }

    public short getStatcode() {
        return statcode;
    }
}
