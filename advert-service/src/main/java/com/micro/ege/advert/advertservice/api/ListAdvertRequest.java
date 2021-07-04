package com.micro.ege.advert.advertservice.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Request that used in list an Advert")
public class ListAdvertRequest {
    @Schema(description = "Service Provider ID", example = "12345678910", required = true)
    private String serviceProviderID;

    @Schema(description = "Advert ID", example = "12345678910", required = true)
    private String advertID;

    @Schema(description = "Service Advert Status", example = "2", required = true)
    private Short serviceStatus;

    @Schema(description = "Service Advert Price", example = "10", required = true)
    private Integer minPrice;

    @Schema(description = "Service City", example = "Ankara", required = true)
    private Integer city;

    @Schema(description = "Service Name", example = "Microservice Demo", required = true)
    private Integer advertName;

    @Schema(description = "Service Category", example = "Web site", required = true)
    private Integer category;
}
