package com.micro.ege.offer.offermicro.service;

import com.micro.ege.offer.offermicro.dto.OfferDetails;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class ListOfferServiceOutput {
    private List<OfferDetails> offerDetailsList;
    private Long errorCode;
    private String errorMessage;
}
