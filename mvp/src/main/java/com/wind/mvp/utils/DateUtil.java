package com.wind.mvp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by H on 2017/10/23.
 */

public class DateUtil {
    private static final Locale LOCALE = Locale.CHINA;
    public static String format(Date date, String s) {
        return new SimpleDateFormat(s, LOCALE).format(date);
    }
}
