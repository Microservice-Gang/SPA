package com.micro.ege.offer.offermicro.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Response that used in deleting an Offer")
@Data
public class DeleteOfferResponse {
    @Schema(description = "Is Succeeded", example = "true", required = true)
    private Boolean isSucceeded;

    @Schema(description = "Error Code", example = "11545L", required = true)
    private Long errorCode;

    @Schema(description = "Error Message", example = "This time range can not select", required = true)
    private String errorMessage;
}
