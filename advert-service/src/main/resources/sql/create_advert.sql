INSERT INTO public."ADVERT"(
    "ADVERT_NAME", "ADVERT_ID", "PROVIDER_ID", "SUMMARY", "SERVICE_STATUS", "MINIMUM_PRICE", "ADVERT_TIME", "CATEGORY", "CITY")
VALUES (:advertName, :advertID, :serviceProviderID,:summary,:serviceStatus,:minPrice,:advertCreateTime,:category,:city)
