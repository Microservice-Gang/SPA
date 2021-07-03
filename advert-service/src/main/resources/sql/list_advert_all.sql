SELECT "ADVERT_ID" AS advertID,
       "ADVERT_NAME" AS advertName,
       "PROVIDER_ID" AS serviceProviderID,
       "SUMMARY" AS summary,
       "SERVICE_STATUS" AS serviceStatus,
       "MINIMUM_PRICE" AS minPrice,
       "ADVERT_CREATED_TIME" AS advertCreateTime
FROM "ADVERT"
WHERE "ADVERT_ID" = :advertId
        AND "SERVICE_STATUS" = :serviceStatus
        AND "PROVIDER_ID" = :providerId;