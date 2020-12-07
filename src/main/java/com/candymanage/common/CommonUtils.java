// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CommonUtils.java

package com.candymanage.common;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils extends StringUtils
{

    public CommonUtils()
    {
    }

    public static String parseStr(String str)
    {
        return isNotBlank(str) ? str : "";
    }

    public static Object parseId(Object id)
    {
        if(id != null)
            return id;
        else
            return "";
    }

    public static String parseDate(Date date, String formate)
    {
        if(date != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat(formate);
            return sdf.format(date);
        } else
        {
            return "";
        }
    }

    public static int parseInteger(Integer i)
    {
        return i == null ? 0 : i.intValue();
    }

    public static Long parseLong(Long l)
    {
        return Long.valueOf(l == null ? 0L : l.longValue());
    }

    public static Double parseDouble(Double d)
    {
        return Double.valueOf(d == null ? 0.0D : d.doubleValue());
    }

    public static Boolean parseBoolean(Boolean b)
    {
        return Boolean.valueOf(b == null ? false : b.booleanValue());
    }

    public static BigDecimal parseBigDecimal(BigDecimal d)
    {
        return d == null ? new BigDecimal(0.0D) : d;
    }
}
