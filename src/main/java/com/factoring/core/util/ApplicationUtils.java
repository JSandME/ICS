package com.factoring.core.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * ApplicationUtils : 程序工具类，提供大量的便捷方法
 *
 * @author 
 *  2014-09-28 22:31
 */
public class ApplicationUtils {

    /**
     * 产生一个36个字符的UUID
     *
     * @return UUID
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * md5加密
     *
     * @param value 要加密的值
     * @return md5加密后的值
     */
    public static String md5Hex(String value) {
        return DigestUtils.md5Hex(value);
    }

    /**
     * sha1加密
     *
     * @param value 要加密的值
     * @return sha1加密后的值
     */
    public static String sha1Hex(String value) {
        return DigestUtils.sha1Hex(value);
    }

    /**
     * sha256加密
     *
     * @param value 要加密的值
     * @return sha256加密后的值
     */
    public static String sha256Hex(String value) {
        return DigestUtils.sha256Hex(value);
    }
    
    public static String getCurrentTime()
    {
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(Calendar.getInstance().getTime());
    }

    public static String getCurrentDate()
    {
        return (new SimpleDateFormat("yyyy-MM-dd")).format(Calendar.getInstance().getTime());
    }
    
    public static int daysOfTwo(Date fDate, Date oDate) {

        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(fDate);
        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
        aCalendar.setTime(oDate);
        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);

        return day2 - day1;

     }

}
