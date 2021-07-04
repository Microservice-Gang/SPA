package com.micro.ege.advert.advertservice.api;

import com.micro.ege.advert.advertservice.dto.AdvertDetailsDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Response that used in list an Advert")
public class ListAdvertResponse {
    @Schema(description = "Advert Details List", required = true)
    private List<AdvertDetailsDto> advertDetailsDtoList;

    @Schema(description = "Error Code", example = "11545L", required = true)
    private Long errorCode;

    @Schema(description = "Error Message", example = "This time range can not select", required = true)
    private String errorMessage;
}
