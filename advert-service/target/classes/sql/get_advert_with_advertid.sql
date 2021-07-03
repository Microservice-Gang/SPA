SELECT "ADVERT_ID" AS advertID,
       "PROVIDER_ID" AS serviceProviderID,
       "ADVERT_ID" AS advertID,
       "SUMMARY" AS summary,
       "SERVICE_STATUS" AS serviceStatus,
       "MINIMUM_PRICE" AS minPrice,
       "ADVERT_CREATED_TIME" AS advertCreateTime
FROM "ADVERT"
WHERE "ADVERT_ID" = :advertID