package com.funi.demo.utils;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhihuan.niu on 2016/11/3.
 */
public class DateUtils {
    private static String formatDay="yyyy-MM-dd";
    public static String formatTimeStamp="yyyy-MM-dd HH:mm:ss";
    public static String getDateStr(Date date,String format) {
        if(date==null)return "";
        return new SimpleDateFormat(format).format(date);
    }
    public static String getDateStr(Date date) {
        if(date==null)return "";
        return new SimpleDateFormat(formatDay).format(date);
    }
    public static Date getStartDate(Date date){
        if(date==null)return null;
        try {
            return new SimpleDateFormat(formatDay).parse(new SimpleDateFormat(formatDay).format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Date getEndDate(Date date){
        if(date==null)return date;
        Date start=getStartDate(date);
        return new DateTime(start).plusDays(1).plusSeconds(-1).toDate();
    }
}
