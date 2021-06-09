package com.micro.ege.offer.offermicro.api;

import com.micro.ege.offer.offermicro.service.*;
import org.mapstruct.Mapper;

@Mapper
public interface OfferMapper {

    public CreateOfferServiceInput mapApiRequestToServiceInput(CreateOfferRequest createOfferRequest);
    public UpdateOfferServiceInput mapApiRequestToServiceInput(UpdateOfferRequest updateOfferRequest);
    public DeleteOfferServiceInput mapApiRequestToServiceInput(DeleteOfferRequest deleteOfferRequest);
    public ListOfferServiceInput mapApiRequestToServiceInput(ListOfferRequest listOfferRequest);

    public CreateOfferResponse mapServiceOutputToApiResponse(CreateOfferServiceOutput createOfferResponse);
    public UpdateOfferResponse mapServiceOutputToApiResponse(UpdateOfferServiceOutput updateOfferResponse);
    public DeleteOfferResponse mapServiceOutputToApiResponse(DeleteOfferServiceOutput deleteOfferResponse);
    public ListOfferResponse mapServiceOutputToApiResponse(ListOfferServiceOutput listOfferResponse);

}
