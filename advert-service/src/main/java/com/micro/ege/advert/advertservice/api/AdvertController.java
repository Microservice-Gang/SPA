package com.micro.ege.advert.advertservice.api;

import com.micro.ege.advert.advertservice.service.AdvertService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Tag(name = "Service Advert Microservice")
@RequestMapping("/api/advert")
public class AdvertController {
    private final AdvertService advertService;
    private final AdvertMapper advertMapper;
    public AdvertController(AdvertService advertService) {
        this.advertMapper = Mappers.getMapper(AdvertMapper.class);
        this.advertService = advertService;
    }

    @Operation(summary = "Create Advert",description = "Create Advert")
    @ApiResponse(responseCode = "201", description = "Create Advert Response")
    @PostMapping(path = "/create")
    public ResponseEntity<CreateAdvertResponse> createAdvert(
            @Valid
            @Parameter(description = "Request object for create",required = true)
            @RequestBody CreateAdvertRequest createAdvertRequest) {
        return new ResponseEntity<>(advertMapper.mapServiceOutputToApiResponse(
                advertService.createAdvert(advertMapper.mapApiRequestToServiceInput(
                        createAdvertRequest))), HttpStatus.CREATED);
    }

    @Operation(summary = "Update Advert",description = "Update Advert")
    @ApiResponse(responseCode = "200", description = "Update Advert Response")
    @PutMapping(path = "/update")
    public ResponseEntity<UpdateAdvertResponse> updateAdvert(
            @Parameter(description = "Request object for update",required = true)
            @RequestBody UpdateAdvertRequest updateAdvertRequest) {
        return new ResponseEntity<>(advertMapper.mapServiceOutputToApiResponse(
                advertService.updateAdvert(advertMapper.mapApiRequestToServiceInput(
                        updateAdvertRequest))), HttpStatus.OK);
    }

    @Operation(summary = "Delete Advert",description = "Delete Advert")
    @ApiResponse(responseCode = "200", description = "Delete Advert Response")
    @DeleteMapping(path = "/delete")
    public ResponseEntity<DeleteAdvertResponse> deleteAdvert(
            @Parameter(description = "Request object for delete",required = true)
            @RequestBody DeleteAdvertRequest deleteAdvertRequest) {
        return new ResponseEntity<>(advertMapper.mapServiceOutputToApiResponse(
                advertService.deleteAdvert(advertMapper.mapApiRequestToServiceInput(
                        deleteAdvertRequest))), HttpStatus.OK);
    }

    @Operation(summary = "List Advert",description = "List Advert")
    @ApiResponse(responseCode = "200", description = "List Advert Response")
    @GetMapping(path = "/list")
    public ResponseEntity<ListAdvertResponse> listAdvert(
            @Parameter(description = "Request object for list",required = true)
            @RequestBody ListAdvertRequest listAdvertRequest) {
        return new ResponseEntity<>(advertMapper.mapServiceOutputToApiResponse(
                advertService.listAdvert(advertMapper.mapApiRequestToServiceInput(
                        listAdvertRequest))), HttpStatus.OK);
    }
}
