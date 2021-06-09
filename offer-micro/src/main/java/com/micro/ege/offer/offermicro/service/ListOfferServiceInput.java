package com.micro.ege.offer.offermicro.service;

import lombok.Data;

@Data
public class ListOfferServiceInput {
    private String offerID;
    private String serviceProviderID;
    private String advertID;
    private Short serviceStatus;
}
