package com.micro.ege.advert.advertservice.service;

import com.micro.ege.advert.advertservice.dto.AdvertDetailsDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;
import lombok.Data;

@Data
public class ListAdvertServiceOutput {
    private List<AdvertDetailsDto> advertDetailsList;
    private Long errorCode;
    private String errorMessage;
}
