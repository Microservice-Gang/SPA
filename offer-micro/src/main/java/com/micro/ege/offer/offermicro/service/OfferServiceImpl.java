package com.micro.ege.offer.offermicro.service;

import com.micro.ege.offer.offermicro.core.exception.BusinessException;
import com.micro.ege.offer.offermicro.core.exception.OfferExceptions;
import com.micro.ege.offer.offermicro.core.utils.OfferUtils;
import com.micro.ege.offer.offermicro.dto.CreateOfferDto;
import com.micro.ege.offer.offermicro.dto.OfferDetails;
import com.micro.ege.offer.offermicro.dto.ServiceOfferDto;
import com.micro.ege.offer.offermicro.repo.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
            if (existOffer != null) {
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

        UpdateOfferServiceOutput result = new UpdateOfferServiceOutput();
        try{
            if (updateOfferServiceInput.getServiceStatus()<0 || updateOfferServiceInput.getServiceStatus()>6) {
                throw new BusinessException(OfferExceptions.OFFER_STATUS_NOT_FOUND);
            }

            ServiceOfferDto existOffer = offerRepository
                    .getOfferWithOfferId(
                            updateOfferServiceInput.getOfferID());
            if (existOffer == null) {
                throw new BusinessException(OfferExceptions.OFFER_NOT_FOUND);
            }
            ServiceOfferDto filledOffer = offerRepository
                    .getOfferWithProviderIdAndTime(existOffer.getServiceProviderID(),
                            updateOfferServiceInput.getOfferTime());
            if (filledOffer != null && (!filledOffer.getOfferID().equals(updateOfferServiceInput.getOfferID()))) {
                throw new BusinessException(OfferExceptions.TIME_IS_FILLED_ALREADY);
            }

            if (!OfferUtils.checkServiceStatusChange(existOffer.getServiceStatus(),
                    updateOfferServiceInput.getServiceStatus())) {
                throw new BusinessException(OfferExceptions.STATUS_CHANGE_NOT_VALID);
            }
            Boolean success = offerRepository.updateOffer(updateOfferServiceInput.getOfferID(),
                    updateOfferServiceInput.getFreeText(),
                    updateOfferServiceInput.getServiceStatus(),
                    updateOfferServiceInput.getOfferTime());

            result.setIsSucceeded(success);
            result.setErrorCode(0L);
            result.setErrorMessage("İşlem Başarıyla Gerçekleştirildi.");
            return result;


        }catch (BusinessException businessException) {
            result.setIsSucceeded(false);
            result.setErrorCode(businessException.getErrorCode());
            result.setErrorMessage(businessException.getErrorMessage());
            return result;
        }
        catch (Exception exception) {
            result.setIsSucceeded(false);
            result.setErrorCode(99999L);
            result.setErrorMessage(exception.getMessage());
            return result;
        }
    }

    @Override
    public DeleteOfferServiceOutput deleteOffer(DeleteOfferServiceInput deleteOfferServiceInput) {
        DeleteOfferServiceOutput result = new DeleteOfferServiceOutput();

        try{
            ServiceOfferDto existOffer = offerRepository
                    .getOfferWithOfferId(
                            deleteOfferServiceInput.getOfferID());
            if (existOffer == null) {
                throw new BusinessException(OfferExceptions.OFFER_NOT_FOUND);
            }

            Boolean success = offerRepository.deleteOffer(deleteOfferServiceInput.getOfferID());

            result.setIsSucceeded(success);
            result.setErrorCode(0L);
            result.setErrorMessage("İşlem Başarıyla Gerçekleştirildi.");
            return result;
        }
        catch (Exception exception) {
        result.setIsSucceeded(false);
        result.setErrorCode(99999L);
        result.setErrorMessage(exception.getMessage());
        return result;
        }
    }

    @Override
    public ListOfferServiceOutput listOffer(ListOfferServiceInput listOfferServiceInput) {
        ListOfferServiceOutput result = new ListOfferServiceOutput();
        List<OfferDetails> offerDetailsList = null;
        try{
            if ((listOfferServiceInput.getAdvertID() != null)
                    && (listOfferServiceInput.getServiceProviderID() != null)
                    && (listOfferServiceInput.getServiceStatus() != null)) {
                offerDetailsList = offerRepository.listOffer(listOfferServiceInput.getServiceProviderID(),
                        listOfferServiceInput.getAdvertID(),
                        listOfferServiceInput.getServiceStatus());

            }else if ((listOfferServiceInput.getAdvertID() != null)
                    && (listOfferServiceInput.getServiceStatus() != null)) {
                offerDetailsList = offerRepository.listOfferWithAdvertAndStat(listOfferServiceInput.getAdvertID(),
                        listOfferServiceInput.getServiceStatus());

            }else if ((listOfferServiceInput.getServiceProviderID() != null)
                    && (listOfferServiceInput.getServiceStatus() != null)) {
                offerDetailsList = offerRepository.listOfferWithProviderAndStat(
                        listOfferServiceInput.getServiceProviderID(), listOfferServiceInput.getServiceStatus());

            }else if (listOfferServiceInput.getAdvertID() != null) {
                offerDetailsList = offerRepository.listOfferWithAdvert(listOfferServiceInput.getAdvertID());

            }else if (listOfferServiceInput.getServiceProviderID() != null) {
                offerDetailsList = offerRepository.listOfferWithProvider(listOfferServiceInput.getServiceProviderID());

            }else {
                throw new BusinessException(OfferExceptions.BAD_LIST_OFFER_REQUEST);
            }
            result.setOfferDetailsList(offerDetailsList);
            result.setErrorCode(0L);
            result.setErrorMessage("İşlem Başarıyla Gerçekleştirildi.");
            return result;
        }catch (BusinessException businessException) {

            result.setErrorCode(businessException.getErrorCode());
            result.setErrorMessage(businessException.getErrorMessage());
            return result;
        }
        catch (Exception exception) {
            result.setErrorCode(99999L);
            result.setErrorMessage(exception.getMessage());
            return result;
        }
    }
}
