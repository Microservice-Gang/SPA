package com.micro.ege.offer.offermicro.repo;

import com.micro.ege.offer.offermicro.dto.CreateOfferDto;
import com.micro.ege.offer.offermicro.dto.ListOfferDto;
import com.micro.ege.offer.offermicro.dto.OfferDetails;
import com.micro.ege.offer.offermicro.dto.ServiceOfferDto;

import java.util.List;

public interface OfferRepository {
    ServiceOfferDto getOfferWithOfferId(String OfferID);

    ServiceOfferDto getOfferWithProviderIdAndTime(String serviceProviderID, Integer Time);

    Boolean createOffer(CreateOfferDto createOfferDto);

    Boolean updateOffer(String offerID, String freeText, Short serviceStatus, Integer offerTime);

    Boolean deleteOffer(String OfferID);

    List<OfferDetails> listOfferWithAdvert(String advertId);

    List<OfferDetails> listOfferWithProvider(String providerId);

    List<OfferDetails> listOfferWithAdvertAndStat(String advertId, short serviceStatus);

    List<OfferDetails> listOfferWithProviderAndStat(String providerId,short serviceStatus);

    List<OfferDetails> listOffer(String providerId, String advertId,short serviceStatus);

}
