package com.micro.ege.advert.advertservice.api;

import com.micro.ege.advert.advertservice.service.*;
import org.mapstruct.Mapper;

@Mapper
public interface AdvertMapper {
    public CreateAdvertServiceInput mapApiRequestToServiceInput(CreateAdvertRequest createAdvertRequest);
    public UpdateAdvertServiceInput mapApiRequestToServiceInput(UpdateAdvertRequest updateAdvertRequest);
    public DeleteAdvertServiceInput mapApiRequestToServiceInput(DeleteAdvertRequest deleteAdvertRequest);
    public ListAdvertServiceInput mapApiRequestToServiceInput(ListAdvertRequest listAdvertRequest);

    public CreateAdvertResponse mapServiceOutputToApiResponse(CreateAdvertServiceOutput createAdvertResponse);
    public UpdateAdvertResponse mapServiceOutputToApiResponse(UpdateAdvertServiceOutput updateAdvertResponse);
    public DeleteAdvertResponse mapServiceOutputToApiResponse(DeleteAdvertServiceOutput deleteAdvertResponse);
    public ListAdvertResponse mapServiceOutputToApiResponse(ListAdvertServiceOutput listAdvertResponse);
}
