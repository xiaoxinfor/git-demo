package com.javasm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/11-14:42
 * @Since:jdk1.8
 * @Description:数据类型转换
 */
public class DataConvert {

    /**
     * 将string装为 Integer
     * @param value
     * @return
     */
    public static Integer stringConvertInteger(String value) {
        return value == null ? null : Integer.valueOf(value);
    }

    /**
     * 将string装为 Float
     * @param value
     * @return
     */
    public static Float stringConvertFloat(String value) {
        return value == null ? null : Float.valueOf(value);
    }

    /**
     * 将 string 装为 Double
     * @param value
     * @return
     */
    public static Double stringConvertDouble(String value) {
        return value == null ? null : Double.valueOf(value);
    }


    /**
     * 将 string 装为 UtilDate
     * @param value
     * @return
     */
    public static Date stringConvertUtilDateTime(String value) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.parse(value);
    }

    /**
     * 将 string 装为 UtilDate
     * @param value
     * @return
     */
    public static Date stringConvertUtilDate(String value) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(value);
    }


    /**
     * 将 string 装为 SqlDate
     * @param value
     * @return
     */
    public static java.sql.Date stringConvertSqlDate(String value) throws ParseException {
        return java.sql.Date.valueOf(value);
    }

    /**
     * 将 string 装为 Timestamp
     * @param value
     * @return
     */
    public static java.sql.Timestamp stringConvertTimestamp(String value) throws ParseException {
        return java.sql.Timestamp.valueOf(value);
    }



}
