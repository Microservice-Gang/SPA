SELECT "ADVERT_ID" AS advertID,
       "ADVERT_NAME" AS advertName,
       "PROVIDER_ID" AS serviceProviderID,
       "SUMMARY" AS summary,
       "MINIMUM_PRICE" AS minPrice,
       "ADVERT_TIME" AS advertCreateTime,
       "CATEGORY" AS category,
       "CITY" AS city
FROM "ADVERT"
WHERE "PROVIDER_ID" = :serviceProviderID
  AND  "ADVERT_TIME" = :advertTime
