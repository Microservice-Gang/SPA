package com.micro.ege.offer.offermicro.core.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OfferUtils {
    public static String generateOfferID() {
        Calendar calendar = Calendar.getInstance();
        int dayofYear = calendar.get(Calendar.DAY_OF_YEAR);
        String year = Integer.toString(calendar.get(Calendar.YEAR) % 10);
        String time = new SimpleDateFormat("HHmmssSS")
                .format(calendar.getTime()).substring(0,8);
        return "O" + year + String.format("%03d", dayofYear) + time;
    }
    public static Boolean checkServiceStatusChange(Short before, Short after) {
        if(before.equals(after)) {
            return true;
        }
        else if(before.equals(OfferStatus.SEND.getStatcode()) && after.equals(OfferStatus.ACCEPTED.getStatcode())) {
            return true;
        }
        else if(before.equals(OfferStatus.SEND.getStatcode()) && after.equals(OfferStatus.CANCELED.getStatcode())) {
            return true;
        }
        else if(before.equals(OfferStatus.SEND.getStatcode()) && after.equals(OfferStatus.REJECTED.getStatcode())) {
            return true;
        }
        else if(before.equals(OfferStatus.ACCEPTED.getStatcode()) && after.equals(OfferStatus.DONE.getStatcode())) {
            return true;
        }
        else {
            return false;
        }
    }
}
