package com.micro.ege.offer.offermicro.service;

import com.micro.ege.offer.offermicro.dto.OfferDetails;
import lombok.Data;

import java.util.List;

@Data
public class ListOfferServiceOutput {
    private List<OfferDetails> offerDetailsList;
}
