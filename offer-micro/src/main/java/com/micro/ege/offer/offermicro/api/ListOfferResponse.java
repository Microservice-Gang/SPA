package com.micro.ege.offer.offermicro.api;

import com.micro.ege.offer.offermicro.dto.OfferDetails;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Response that used in list an Offer")

@Data
public class ListOfferResponse {
    @Schema(description = "Offer Details List", required = true)
    private List<OfferDetails> offerDetailsList;
}
