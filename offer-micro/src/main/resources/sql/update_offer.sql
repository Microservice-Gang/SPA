UPDATE public."OFFER"
SET "FREE_TEXT"=:freeText, "SERVICE_STATUS"=:serviceStatus, "OFFER_TIME"=:offerTime
WHERE "OFFER_ID" = :offerId;