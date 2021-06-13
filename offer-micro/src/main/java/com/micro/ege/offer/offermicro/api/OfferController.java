package com.micro.ege.offer.offermicro.api;


import com.micro.ege.offer.offermicro.service.OfferService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Service Offer Microservice")
@RequestMapping("/api/offer")
public class OfferController {

    private final OfferService offerService;
    private final OfferMapper offerMapper;
    public OfferController(OfferService offerService) {
        this.offerMapper = Mappers.getMapper(OfferMapper.class);
        this.offerService = offerService;
    }

    @Operation(summary = "Create Offer",description = "Create Offer")
    @ApiResponse(responseCode = "201", description = "Create Offer Response")
    @PostMapping(path = "/create")
    public ResponseEntity<CreateOfferResponse> createOffer(
            @Parameter(description = "Request object for create",required = true)
            @RequestBody CreateOfferRequest createOfferRequest) {
        return new ResponseEntity<>(offerMapper.mapServiceOutputToApiResponse(
                offerService.createOffer(offerMapper.mapApiRequestToServiceInput(
                        createOfferRequest))), HttpStatus.CREATED);
    }

    @Operation(summary = "Update Offer",description = "Update Offer")
    @ApiResponse(responseCode = "200", description = "Update Offer Response")
    @PutMapping(path = "/update")
    public ResponseEntity<UpdateOfferResponse> updateOffer(
            @Parameter(description = "Request object for update",required = true)
            @RequestBody UpdateOfferRequest updateOfferRequest) {
        return new ResponseEntity<>(offerMapper.mapServiceOutputToApiResponse(
                offerService.updateOffer(offerMapper.mapApiRequestToServiceInput(
                        updateOfferRequest))), HttpStatus.OK);
    }

    @Operation(summary = "Delete Offer",description = "Delete Offer")
    @ApiResponse(responseCode = "200", description = "Delete Offer Response")
    @DeleteMapping(path = "/delete")
    public ResponseEntity<DeleteOfferResponse> deleteOffer(
            @Parameter(description = "Request object for delete",required = true)
            @RequestBody DeleteOfferRequest deleteOfferRequest) {
        return new ResponseEntity<>(offerMapper.mapServiceOutputToApiResponse(
                offerService.deleteOffer(offerMapper.mapApiRequestToServiceInput(
                        deleteOfferRequest))), HttpStatus.OK);
    }

    @Operation(summary = "List Offer",description = "List Offer")
    @ApiResponse(responseCode = "200", description = "List Offer Response")
    @GetMapping(path = "/list")
    public ResponseEntity<ListOfferResponse> listOffer(
            @Parameter(description = "Request object for list",required = true)
            @RequestBody ListOfferRequest listOfferRequest) {
        return new ResponseEntity<>(offerMapper.mapServiceOutputToApiResponse(
                offerService.listOffer(offerMapper.mapApiRequestToServiceInput(
                        listOfferRequest))), HttpStatus.OK);
    }
}
