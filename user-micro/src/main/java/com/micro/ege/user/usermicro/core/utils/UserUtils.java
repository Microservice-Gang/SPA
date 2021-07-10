package com.micro.ege.user.usermicro.core.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserUtils {
    public static String generateUserID() {
        Calendar calendar = Calendar.getInstance();
        int dayofYear = calendar.get(Calendar.DAY_OF_YEAR);
        String year = Integer.toString(calendar.get(Calendar.YEAR) % 10);
        String time = new SimpleDateFormat("HHmmssSS")
                .format(calendar.getTime()).substring(0,8);
        return "U" + year + String.format("%03d", dayofYear) + time;
    }
}
