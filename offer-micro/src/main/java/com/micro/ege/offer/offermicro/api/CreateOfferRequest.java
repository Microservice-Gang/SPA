package com.micro.ege.offer.offermicro.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "Request that used in creating an Offer")
@Data
public class CreateOfferRequest {

    @NotNull(message = "Service Provider ID is not null")
    @Schema(description = "Service Provider ID", example = "12345678910", required = true)
    private String serviceProviderID;

    @NotNull(message = "Advert ID is not null")
    @Schema(description = "Advert ID", example = "12345678910", required = true)
    private String advertID;

    @NotNull(message = "Service Condition Text is not null")
    @Schema(description = "Service Condition Text", example = "Service conditions", required = true)
    private String freeText;

    @NotNull(message = "Service Offer Status is not null")
    @Schema(description = "Service Offer Status", example = "2", required = true)
    private Short serviceStatus;

    @NotNull(message = "Service Offer Date is not null")
    @Schema(description = "Service Offer Date(YYYYMMDDHH)", example = "20210060712", required = true)
    private Integer offerTime;

}
