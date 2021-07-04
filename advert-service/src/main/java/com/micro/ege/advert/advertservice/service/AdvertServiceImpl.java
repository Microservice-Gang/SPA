package com.micro.ege.advert.advertservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.micro.ege.advert.advertservice.core.exception.BusinessException;
import com.micro.ege.advert.advertservice.core.exception.AdvertExceptions;
import com.micro.ege.advert.advertservice.core.utils.AdvertUtils;
import com.micro.ege.advert.advertservice.dto.CreateAdvertDto;
import com.micro.ege.advert.advertservice.dto.AdvertDetailsDto;
import com.micro.ege.advert.advertservice.dto.ServiceAdvertDto;
import com.micro.ege.advert.advertservice.repo.AdvertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdvertServiceImpl implements AdvertService {

    private final AdvertRepository AdvertRepository;

    @Override
    public CreateAdvertServiceOutput createAdvert(CreateAdvertServiceInput createAdvertServiceInput) {

        CreateAdvertServiceOutput result = new CreateAdvertServiceOutput();
        try{
            if (createAdvertServiceInput.getServiceStatus()<0 || createAdvertServiceInput.getServiceStatus()>6) {
                throw new BusinessException(AdvertExceptions.ADVERT_STATUS_NOT_FOUND);
            }
            ServiceAdvertDto existAdvert = AdvertRepository.getAdvertWithProviderIdAndTime(
                            createAdvertServiceInput.getServiceProviderID(),
                            createAdvertServiceInput.getAdvertCreateTime());
            if (existAdvert != null) {
                throw new BusinessException(AdvertExceptions.TIME_IS_FILLED_ALREADY);
            }
            CreateAdvertDto createAdvertDto = new CreateAdvertDto();
            createAdvertDto.setServiceProviderID(createAdvertServiceInput.getServiceProviderID());
            createAdvertDto.setAdvertID(createAdvertServiceInput.getAdvertID());
            createAdvertDto.setSummary(createAdvertServiceInput.getSummary());
            createAdvertDto.setServiceStatus(createAdvertServiceInput.getServiceStatus());
            createAdvertDto.setAdvertCreateTime(createAdvertServiceInput.getAdvertCreateTime());
            createAdvertDto.setCategory(createAdvertServiceInput.getCategory());
            createAdvertDto.setCategory(createAdvertServiceInput.getCity());

            result.setIsSucceeded(AdvertRepository.createAdvert(createAdvertDto));
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
    public UpdateAdvertServiceOutput updateAdvert(UpdateAdvertServiceInput updateAdvertServiceInput) {

        UpdateAdvertServiceOutput result = new UpdateAdvertServiceOutput();
        try{
            if (updateAdvertServiceInput.getServiceStatus()<0 || updateAdvertServiceInput.getServiceStatus()>6) {
                throw new BusinessException(AdvertExceptions.ADVERT_STATUS_NOT_FOUND);
            }

            ServiceAdvertDto existAdvert = AdvertRepository
                    .getAdvertWithAdvertId(
                            updateAdvertServiceInput.getAdvertID());
            if (existAdvert == null) {
                throw new BusinessException(AdvertExceptions.ADVERT_NOT_FOUND);
            }
            ServiceAdvertDto filledAdvert = AdvertRepository
                    .getAdvertWithProviderIdAndTime(existAdvert.getServiceProviderID(),
                            updateAdvertServiceInput.getAdvertCreateTime());
            if (filledAdvert != null && (!filledAdvert.getAdvertID().equals(updateAdvertServiceInput.getAdvertID()))) {
                throw new BusinessException(AdvertExceptions.TIME_IS_FILLED_ALREADY);
            }

            if (!AdvertUtils.checkServiceStatusChange(existAdvert.getServiceStatus(),
                    updateAdvertServiceInput.getServiceStatus())) {
                throw new BusinessException(AdvertExceptions.STATUS_CHANGE_NOT_VALID);
            }
            Boolean success = AdvertRepository.updateAdvert(updateAdvertServiceInput.getAdvertName(),
                    updateAdvertServiceInput.getAdvertID(),
                    updateAdvertServiceInput.getSummary(),
                    updateAdvertServiceInput.getServiceStatus(),
                    updateAdvertServiceInput.getAdvertCreateTime(),
                    updateAdvertServiceInput.getMinPrice(),
                    updateAdvertServiceInput.getCity(),
                    updateAdvertServiceInput.getCategory());

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
    public DeleteAdvertServiceOutput deleteAdvert(DeleteAdvertServiceInput deleteAdvertServiceInput) {
        DeleteAdvertServiceOutput result = new DeleteAdvertServiceOutput();

        try{
            ServiceAdvertDto existAdvert = AdvertRepository
                    .getAdvertWithAdvertId(
                            deleteAdvertServiceInput.getAdvertID());
            if (existAdvert == null) {
                throw new BusinessException(AdvertExceptions.ADVERT_NOT_FOUND);
            }

            Boolean success = AdvertRepository.deleteAdvert(deleteAdvertServiceInput.getAdvertID());

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
    public ListAdvertServiceOutput listAdvert(ListAdvertServiceInput listAdvertServiceInput) {
        ListAdvertServiceOutput result = new ListAdvertServiceOutput();
        List<AdvertDetailsDto> AdvertDetailsList = null;
        try{
            if ((listAdvertServiceInput.getAdvertID() != null)
                    && (listAdvertServiceInput.getServiceProviderID() != null)
                    && (listAdvertServiceInput.getServiceStatus() != null)
                    && (listAdvertServiceInput.getMinPrice() != null)) {
                AdvertDetailsList = AdvertRepository.listAdvert(listAdvertServiceInput.getServiceProviderID(),
                        listAdvertServiceInput.getAdvertID(),
                        listAdvertServiceInput.getMinPrice(),
                        listAdvertServiceInput.getServiceStatus());

            }else if ((listAdvertServiceInput.getAdvertID() != null)
                    && (listAdvertServiceInput.getServiceStatus() != null)) {
                AdvertDetailsList = AdvertRepository.listAdvertWithAdvertAndStat(listAdvertServiceInput.getAdvertID(),
                        listAdvertServiceInput.getServiceStatus());

            }else if ((listAdvertServiceInput.getServiceProviderID() != null)
                    && (listAdvertServiceInput.getServiceStatus() != null)) {
                AdvertDetailsList = AdvertRepository.listAdvertWithProviderAndStat(
                        listAdvertServiceInput.getServiceProviderID(), listAdvertServiceInput.getServiceStatus());


            }else if (listAdvertServiceInput.getServiceProviderID() != null) {
                AdvertDetailsList = AdvertRepository.listAdvertWithProvider(listAdvertServiceInput.getServiceProviderID());

            }else {
                throw new BusinessException(AdvertExceptions.BAD_LIST_ADVERT_REQUEST);
            }
            result.setAdvertDetailsList(AdvertDetailsList);
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
