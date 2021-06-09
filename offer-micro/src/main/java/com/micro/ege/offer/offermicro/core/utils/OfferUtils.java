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
}
