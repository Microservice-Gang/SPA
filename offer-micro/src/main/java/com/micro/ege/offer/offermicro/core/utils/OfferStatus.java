package com.micro.ege.offer.offermicro.core.utils;

public enum OfferStatus {
    SEND(1),
    ACCEPTED(2),
    REJECTED(3),
    DONE(4),
    CANCELED(5),
    ;

    private int statcode;

    OfferStatus(int i) {
        this.statcode = i;
    }

    public int getStatcode() {
        return statcode;
    }

}
