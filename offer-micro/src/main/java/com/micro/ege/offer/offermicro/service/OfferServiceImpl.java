package com.micro.ege.offer.offermicro.service;

import com.micro.ege.offer.offermicro.core.exception.BusinessException;
import com.micro.ege.offer.offermicro.core.exception.OfferExceptions;
import com.micro.ege.offer.offermicro.dto.CreateOfferDto;
import com.micro.ege.offer.offermicro.dto.ServiceOfferDto;
import com.micro.ege.offer.offermicro.repo.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService{

    private final OfferRepository offerRepository;

    @Override
    public CreateOfferServiceOutput createOffer(CreateOfferServiceInput createOfferServiceInput) {

        CreateOfferServiceOutput result = new CreateOfferServiceOutput();
        try{
            if (createOfferServiceInput.getServiceStatus()<0 || createOfferServiceInput.getServiceStatus()>6) {
                throw new BusinessException(OfferExceptions.OFFER_STATUS_NOT_FOUND);
            }
            ServiceOfferDto existOffer = offerRepository
                    .getOfferWithProviderIdAndTime(
                            createOfferServiceInput.getServiceProviderID(),
                            createOfferServiceInput.getOfferTime());
            if (existOffer == null) {
                throw new BusinessException(OfferExceptions.TIME_IS_FILLED_ALREADY);
            }
            CreateOfferDto createOfferDto = new CreateOfferDto();
            createOfferDto.setServiceProviderID(createOfferServiceInput.getServiceProviderID());
            createOfferDto.setAdvertID(createOfferServiceInput.getAdvertID());
            createOfferDto.setFreeText(createOfferServiceInput.getFreeText());
            createOfferDto.setServiceStatus(createOfferServiceInput.getServiceStatus());
            createOfferDto.setOfferTime(createOfferServiceInput.getOfferTime());

            result.setIsSucceeded(offerRepository.createOffer(createOfferDto));
            result.setErrorCode(0L);
            result.setErrorMessage("İşlem Başarıyla Gerçekleştirildi.");
            return result;

        } catch (BusinessException businessException) {
            result.setIsSucceeded(false);
            result.setErrorCode(businessException.getErrorCode());
            result.setErrorMessage(businessException.getErrorMessage());
            return result;
        }

    }

    @Override
    public UpdateOfferServiceOutput updateOffer(UpdateOfferServiceInput updateOfferServiceInput) {
        //TODO: Get the original record with offerID from DB
        //TODO: If time range changes,controls time range fillness
        //TODO: If status changes,controls status validness
        //TODO: Update the record
        return null;
    }

    @Override
    public DeleteOfferServiceOutput deleteOffer(DeleteOfferServiceInput deleteOfferServiceInput) {
        return null;
    }

    @Override
    public ListOfferServiceOutput listOffer(ListOfferServiceInput listOfferServiceInput) {
        return null;
    }
}
