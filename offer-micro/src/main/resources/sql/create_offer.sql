INSERT INTO "OFFER" (OFFER_ID,
                     PROVIDER_ID,
                     ADVERT_ID,
                     FREE_TEXT,
                     SERVICE_STATUS,
                     OFFER_TIME)
VALUES (:offerID, :serviceProviderID,:advertID,:freeText,:serviceStatus,:offerTime);