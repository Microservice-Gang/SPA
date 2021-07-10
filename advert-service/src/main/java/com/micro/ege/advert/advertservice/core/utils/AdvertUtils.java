package com.micro.ege.advert.advertservice.core.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AdvertUtils {
    public static String generateAdvertID() {
        Calendar calendar = Calendar.getInstance();
        int dayofYear = calendar.get(Calendar.DAY_OF_YEAR);
        String year = Integer.toString(calendar.get(Calendar.YEAR) % 10);
        String time = new SimpleDateFormat("HHmmssSS")
                .format(calendar.getTime()).substring(0,8);
        return "A" + year + String.format("%03d", dayofYear) + time;
    }
    public static Boolean checkServiceStatusChange(Short before, Short after) {
        if(before.equals(after)) {
            return true;
        }
        else if(before.equals(AdvertStatus.SEND.getStatcode()) && after.equals(AdvertStatus.ACCEPTED.getStatcode())) {
            return true;
        }
        else if(before.equals(AdvertStatus.SEND.getStatcode()) && after.equals(AdvertStatus.CANCELED.getStatcode())) {
            return true;
        }
        else if(before.equals(AdvertStatus.SEND.getStatcode()) && after.equals(AdvertStatus.REJECTED.getStatcode())) {
            return true;
        }
        else if(before.equals(AdvertStatus.ACCEPTED.getStatcode()) && after.equals(AdvertStatus.DONE.getStatcode())) {
            return true;
        }
        else {
            return false;
        }
    }
}
