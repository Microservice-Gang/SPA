package com.micro.ege.advert.advertservice.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Request that used in deleting an Advert")
public class DeleteAdvertRequest {
    @NotNull(message = "Advert ID is not null")
    @Schema(description = "Advert ID", example = "12345678910", required = true)
    private String advertID;
}
