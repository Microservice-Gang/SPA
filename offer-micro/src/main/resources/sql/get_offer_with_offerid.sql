SELECT "OFFER_ID" AS offerID,
       "PROVIDER_ID" AS serviceProviderID,
       "ADVERT_ID" AS advertID,
       "FREE_TEXT" AS freeText,
       "SERVICE_STATUS" AS serviceStatus,
       "OFFER_TIME" AS offerTime
FROM "OFFER"
WHERE "OFFER_ID" = :offerId