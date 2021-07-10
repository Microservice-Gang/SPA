UPDATE public."ADVERT"
SET "ADVERT_NAME"=:advertName, "SUMMARY"=:summary,"ADVERT_CREATED_TIME"=:advertCreateTime, "MINIMUM_PRICE"=:minPrice, "CATEGORY"=:category, "CITY"=:city
WHERE "ADVERT_ID" = :advertID;
