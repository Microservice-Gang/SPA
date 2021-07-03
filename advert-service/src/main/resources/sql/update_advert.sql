UPDATE public."ADVERT"
SET "ADVERT_NAME"=:advertName, "SUMMARY"=:summary, "SERVICE_STATUS"=:serviceStatus, "ADVERT_CREATED_TIME"=:offerTime, "MINIMUM_PRICE"=:minPrice
WHERE "OFFER_ID" = :offerId;
