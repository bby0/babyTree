package com.qfedu.babytree.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

    public static String getDate(){
        return new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    }
}
