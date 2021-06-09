package com.micro.ege.offer.offermicro.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "Request that used in updating an Offer")
@Data
public class UpdateOfferRequest {
    @NotNull(message = "Offer ID is not null")
    @Schema(description = "Offer ID", example = "12345678910", required = true)
    private String offerID;

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
