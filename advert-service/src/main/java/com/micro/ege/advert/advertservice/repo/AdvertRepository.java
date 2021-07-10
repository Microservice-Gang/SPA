package com.micro.ege.advert.advertservice.repo;

import com.micro.ege.advert.advertservice.dto.CreateAdvertDto;
import com.micro.ege.advert.advertservice.dto.ListAdvertDto;
import com.micro.ege.advert.advertservice.dto.ServiceAdvertDto;
import com.micro.ege.advert.advertservice.dto.AdvertDetailsDto;

import java.util.List;

public interface AdvertRepository {
    ServiceAdvertDto getAdvertWithAdvertId(String AdvertID);

    ServiceAdvertDto getAdvertWithProviderId(String serviceProviderID);

    Boolean createAdvert(CreateAdvertDto createAdvertDto);

    Boolean updateAdvert(String AdvertName , String AdvertID, String Summary,Integer advertCreateTime, Integer minPrice, String category, String city);

    Boolean deleteAdvert(String AdvertID);


    List<AdvertDetailsDto> listAdvertWithProvider(String providerId);

    List<AdvertDetailsDto> listAdvertWithCategory(String category);

    List<AdvertDetailsDto> listAdvertWithCity(String city);

    List<AdvertDetailsDto> listAdvertWithName(String advertName);

    List<AdvertDetailsDto> listAdvert(String providerId, String advertId, Integer minPrice);


    ServiceAdvertDto getAdvertWithProviderIdAndTime(String serviceProviderID, Integer advertCreateTime);

    List<AdvertDetailsDto> listAdvertWithAdvertAndStat(String advertID);

    List<AdvertDetailsDto> listAdvertWithPrice(Integer minPrice);


    List<AdvertDetailsDto> listAdvertWithProviderAndStat(String serviceProviderID);
}
