INSERT INTO public."ADVERT"(
    "ADVERT_NAME", "ADVERT_ID", "PROVIDER_ID", "SUMMARY", "SERVICE_STATUS", "MINIMUM_PRICE", "ADVERT_TIME")
VALUES (:advertName, :advertID, :serviceProviderID,:summary,:serviceStatus,:minPrice,:advertCreateTime)
