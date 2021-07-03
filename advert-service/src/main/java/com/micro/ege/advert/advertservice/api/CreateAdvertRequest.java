package com.micro.ege.advert.advertservice.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Request that used in creating an Advert")
public class CreateAdvertRequest {
    @NotNull(message = "Service Provider ID is not null")
    @Schema(description = "Service Provider ID", example = "12345678910", required = true)
    private String serviceProviderID;

    @NotNull(message = "Advert ID is not null")
    @Schema(description = "Advert ID", example = "12345678910", required = true)
    private String advertID;

    @NotNull(message = "Service Condition Text is not null")
    @Schema(description = "Service Condition Text", example = "Service summary", required = true)
    private String summary;

    @NotNull(message = "Service Offer Status is not null")
    @Schema(description = "Service Offer Status", example = "2", required = true)
    private Short serviceStatus;

    @NotNull(message = "Service Advert Date is not null")
    @Schema(description = "Service Offer Date(YYYYMMDDHH)", example = "20210060712", required = true)
    private Integer advertTime;

    @NotNull(message = "Service Advert Minimum Price is not null")
    @Schema(description = "Service Advert Minimum Price", example = "50", required = true)
    private Integer minPrice;
}
