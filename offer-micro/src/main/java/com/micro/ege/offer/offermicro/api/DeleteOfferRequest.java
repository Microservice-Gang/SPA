package com.micro.ege.offer.offermicro.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "Request that used in deleteing an Offer")
@Data
public class DeleteOfferRequest {
    @NotNull(message = "Offer ID is not null")
    @Schema(description = "Offer ID", example = "12345678910", required = true)
    private String offerID;
}
