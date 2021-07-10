package com.micro.ege.advert.advertservice.api;

import com.micro.ege.advert.advertservice.service.CreateAdvertServiceInput;
import com.micro.ege.advert.advertservice.service.CreateAdvertServiceOutput;
import com.micro.ege.advert.advertservice.service.DeleteAdvertServiceInput;
import com.micro.ege.advert.advertservice.service.DeleteAdvertServiceOutput;
import com.micro.ege.advert.advertservice.service.ListAdvertServiceInput;
import com.micro.ege.advert.advertservice.service.ListAdvertServiceOutput;
import com.micro.ege.advert.advertservice.service.UpdateAdvertServiceInput;
import com.micro.ege.advert.advertservice.service.UpdateAdvertServiceOutput;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-10T22:36:39+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.7 (AdoptOpenJDK)"
)
public class AdvertMapperImpl implements AdvertMapper {

    @Override
    public CreateAdvertServiceInput mapApiRequestToServiceInput(CreateAdvertRequest createAdvertRequest) {
        if ( createAdvertRequest == null ) {
            return null;
        }

        CreateAdvertServiceInput createAdvertServiceInput = new CreateAdvertServiceInput();

        createAdvertServiceInput.setServiceProviderID( createAdvertRequest.getServiceProviderID() );
        createAdvertServiceInput.setAdvertName( createAdvertRequest.getAdvertName() );
        createAdvertServiceInput.setSummary( createAdvertRequest.getSummary() );
        createAdvertServiceInput.setMinPrice( createAdvertRequest.getMinPrice() );
        createAdvertServiceInput.setAdvertCreateTime( createAdvertRequest.getAdvertCreateTime() );
        createAdvertServiceInput.setCategory( createAdvertRequest.getCategory() );
        createAdvertServiceInput.setCity( createAdvertRequest.getCity() );

        return createAdvertServiceInput;
    }

    @Override
    public UpdateAdvertServiceInput mapApiRequestToServiceInput(UpdateAdvertRequest updateAdvertRequest) {
        if ( updateAdvertRequest == null ) {
            return null;
        }

        UpdateAdvertServiceInput updateAdvertServiceInput = new UpdateAdvertServiceInput();

        updateAdvertServiceInput.setAdvertName( updateAdvertRequest.getAdvertName() );
        updateAdvertServiceInput.setAdvertID( updateAdvertRequest.getAdvertID() );
        updateAdvertServiceInput.setSummary( updateAdvertRequest.getSummary() );
        updateAdvertServiceInput.setMinPrice( updateAdvertRequest.getMinPrice() );
        updateAdvertServiceInput.setAdvertCreateTime( updateAdvertRequest.getAdvertCreateTime() );
        updateAdvertServiceInput.setCategory( updateAdvertRequest.getCategory() );
        updateAdvertServiceInput.setCity( updateAdvertRequest.getCity() );

        return updateAdvertServiceInput;
    }

    @Override
    public DeleteAdvertServiceInput mapApiRequestToServiceInput(DeleteAdvertRequest deleteAdvertRequest) {
        if ( deleteAdvertRequest == null ) {
            return null;
        }

        DeleteAdvertServiceInput deleteAdvertServiceInput = new DeleteAdvertServiceInput();

        deleteAdvertServiceInput.setAdvertID( deleteAdvertRequest.getAdvertID() );

        return deleteAdvertServiceInput;
    }

    @Override
    public ListAdvertServiceInput mapApiRequestToServiceInput(ListAdvertRequest listAdvertRequest) {
        if ( listAdvertRequest == null ) {
            return null;
        }

        ListAdvertServiceInput listAdvertServiceInput = new ListAdvertServiceInput();

        listAdvertServiceInput.setServiceProviderID( listAdvertRequest.getServiceProviderID() );
        listAdvertServiceInput.setAdvertID( listAdvertRequest.getAdvertID() );
        listAdvertServiceInput.setMinPrice( listAdvertRequest.getMinPrice() );

        return listAdvertServiceInput;
    }

    @Override
    public CreateAdvertResponse mapServiceOutputToApiResponse(CreateAdvertServiceOutput createAdvertResponse) {
        if ( createAdvertResponse == null ) {
            return null;
        }

        CreateAdvertResponse createAdvertResponse1 = new CreateAdvertResponse();

        createAdvertResponse1.setIsSucceeded( createAdvertResponse.getIsSucceeded() );
        createAdvertResponse1.setErrorCode( createAdvertResponse.getErrorCode() );
        createAdvertResponse1.setErrorMessage( createAdvertResponse.getErrorMessage() );

        return createAdvertResponse1;
    }

    @Override
    public UpdateAdvertResponse mapServiceOutputToApiResponse(UpdateAdvertServiceOutput updateAdvertResponse) {
        if ( updateAdvertResponse == null ) {
            return null;
        }

        UpdateAdvertResponse updateAdvertResponse1 = new UpdateAdvertResponse();

        updateAdvertResponse1.setIsSucceeded( updateAdvertResponse.getIsSucceeded() );
        updateAdvertResponse1.setErrorCode( updateAdvertResponse.getErrorCode() );
        updateAdvertResponse1.setErrorMessage( updateAdvertResponse.getErrorMessage() );

        return updateAdvertResponse1;
    }

    @Override
    public DeleteAdvertResponse mapServiceOutputToApiResponse(DeleteAdvertServiceOutput deleteAdvertResponse) {
        if ( deleteAdvertResponse == null ) {
            return null;
        }

        DeleteAdvertResponse deleteAdvertResponse1 = new DeleteAdvertResponse();

        deleteAdvertResponse1.setIsSucceeded( deleteAdvertResponse.getIsSucceeded() );
        deleteAdvertResponse1.setErrorCode( deleteAdvertResponse.getErrorCode() );
        deleteAdvertResponse1.setErrorMessage( deleteAdvertResponse.getErrorMessage() );

        return deleteAdvertResponse1;
    }

    @Override
    public ListAdvertResponse mapServiceOutputToApiResponse(ListAdvertServiceOutput listAdvertResponse) {
        if ( listAdvertResponse == null ) {
            return null;
        }

        ListAdvertResponse listAdvertResponse1 = new ListAdvertResponse();

        listAdvertResponse1.setErrorCode( listAdvertResponse.getErrorCode() );
        listAdvertResponse1.setErrorMessage( listAdvertResponse.getErrorMessage() );

        return listAdvertResponse1;
    }
}
