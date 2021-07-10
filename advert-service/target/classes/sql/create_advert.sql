INSERT INTO public."ADVERT"(
    "ADVERT_NAME", "ADVERT_ID", "PROVIDER_ID", "SUMMARY","MINIMUM_PRICE", "ADVERT_TIME", "CATEGORY", "CITY")
VALUES (:advertName, :advertID, :serviceProviderID,:summary,:minPrice,:advertTime,:category,:city)
