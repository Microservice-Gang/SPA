package com.micro.ege.offer.offermicro.repo;

import com.micro.ege.offer.offermicro.dto.CreateOfferDto;
import com.micro.ege.offer.offermicro.dto.ListOfferDto;
import com.micro.ege.offer.offermicro.dto.OfferDetails;
import com.micro.ege.offer.offermicro.dto.ServiceOfferDto;

public interface OfferRepository {
    ServiceOfferDto getOfferWithOfferId(String OfferID);

    ServiceOfferDto getOfferWithProviderIdAndTime(String serviceProviderID, Integer Time);

    Boolean createOffer(CreateOfferDto createOfferDto);

    Boolean updateOffer(String freeText, Short serviceStatus, Integer offerTime);

    Boolean deleteOffer(String OfferID);

    OfferDetails listOffer(ListOfferDto listOfferDto);
}
