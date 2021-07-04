package com.micro.ege.advert.advertservice.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "Request that used in updating an Advert")
@Data
public class UpdateAdvertRequest {
    @NotNull(message = "Advert ID is not null")
    @Schema(description = "Advert ID", example = "12345678910", required = true)
    private String advertID;

    @NotNull(message = "Advert name is not null")
    @Schema(description = "Advert Name", example = "Hello World Project!", required = true)
    private String advertName;

    @NotNull(message = "Service Condition Summary is not null")
    @Schema(description = "Service Condition Summary", example = "Service summary", required = true)
    private String summary;

    @NotNull(message = "Service Offer Status is not null")
    @Schema(description = "Service Offer Status", example = "2", required = true)
    private Short serviceStatus;

    @NotNull(message = "Service Advert Created Date is not null")
    @Schema(description = "Service Advert Created Date(YYYYMMDDHH)", example = "20210060712", required = true)
    private Integer advertCreateTime;

    @NotNull(message = "Service Advert Minimum Price is not null")
    @Schema(description = "Service Advert Minimum Price", example = "50", required = true)
    private Integer minPrice;

    @NotNull(message = "Service Category is not null")
    @Schema(description = "Service Category", example = "Web site", required = true)
    private String category;

    @NotNull(message = "Service City is not null")
    @Schema(description = "Service City", example = "Ankara", required = true)
    private String city;
}
