package com.micro.ege.offer.offermicro.service;

public interface OfferService {
    CreateOfferServiceOutput createOffer(CreateOfferServiceInput createOfferServiceInput);

    UpdateOfferServiceOutput updateOffer(UpdateOfferServiceInput updateOfferServiceInput);

    DeleteOfferServiceOutput deleteOffer(DeleteOfferServiceInput deleteOfferServiceInput);

    ListOfferServiceOutput listOffer(ListOfferServiceInput listOfferServiceInput);
}
