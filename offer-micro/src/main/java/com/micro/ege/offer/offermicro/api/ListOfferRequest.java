package com.micro.ege.offer.offermicro.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "Request that used in list an Offer")
@Data
public class ListOfferRequest {

    @Schema(description = "Service Provider ID", example = "12345678910", required = true)
    private String serviceProviderID;

    @Schema(description = "Advert ID", example = "12345678910", required = true)
    private String advertID;

    @Schema(description = "Service Offer Status", example = "2", required = true)
    private Short serviceStatus;
}
