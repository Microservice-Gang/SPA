package com.micro.ege.advert.advertservice.service;

import com.micro.ege.advert.advertservice.api.ListAdvertRequest;

public interface AdvertService {
    CreateAdvertServiceOutput createAdvert(CreateAdvertServiceInput createAdvertServiceInput);

    UpdateAdvertServiceOutput updateAdvert(UpdateAdvertServiceInput updateAdvertServiceInput);

    DeleteAdvertServiceOutput deleteAdvert(DeleteAdvertServiceInput deleteAdvertServiceInput);

    ListAdvertServiceOutput listAdvert(ListAdvertServiceInput listAdvertServiceInput);
}
