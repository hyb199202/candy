package com.candymanage.candy.common.utils;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import net.sf.json.JSONNull;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * Title: StringUtil.java
 * </p>
 *
 * <p>
 * Description: 字符处理工具
 * </p>
 *
 * <p>
 * Date: 2017-5-26
 * </p>
 */
public class StringUtil {

    /**
     * 转换Obj为String对象
     *
     * @param obj
     * @return
     */
    public static String valueOf(Object obj) {
        return String.valueOf(obj);
    }

    public static String valueOfNnull(Object obj) {
        if (obj == null) {
            return null;
        } else {
            return String.valueOf(obj);
        }
    }

    public static String revalueOf(Object obj) {
        return (obj == null) ? "" : obj.toString();
    }

    /**
     * 判断是否为空
     *
     * @param src
     * @return string
     */
    public static String tNull(String src) {
        if (isNull(src) || src.equalsIgnoreCase("null") || src.equalsIgnoreCase("undefined"))
            return "";
        return src;
    }


    /**
     * 判断字符串列表不为空或者不为null
     *
     * @param values
     * @return
     */
    public static boolean areNotEmpty(String... values) {
        boolean result = true;
        if (values == null || values.length == 0) {
            result = false;
        } else {
            for (String value : values) {
                result &= !isEmpty(value);
            }
        }
        return result;

    }


    public static Integer tNull_1(Object src) {
        Integer rte = new Integer("0");
        if (src == null) {
            src = String.valueOf("0");
        }
        rte = new BigDecimal(String.valueOf(src)).intValue();
        return rte;
    }

    /**
     * 先截取两边的空字符，在判断是否为空
     *
     * @param src
     * @return
     */
    public static String tNulltTrim(String src) {
        return tNull(tTrim(src));
    }

    /**
     * 先判断是否为null,再截取两边的空字符
     *
     * @param src
     * @return
     */
    public static String tTrim2(String src) {
        if (src == null) {
            return null;
        } else {
            return src.trim();
        }
    }

    public static String transformWeekday(String num) {
        String weekDay;
        switch (num) {
            case "0":
                weekDay = "星期一";
                break;
            case "1":
                weekDay = "星期二";
                break;
            case "2":
                weekDay = "星期三";
                break;
            case "3":
                weekDay = "星期四";
                break;
            case "4":
                weekDay = "星期五";
                break;
            case "5":
                weekDay = "星期六";
                break;
            case "6":
                weekDay = "星期日";
                break;
            default:
                weekDay = "";
        }
        return weekDay;
    }


    /**
     * 字符串为空时，返回"0"，否则返回本身
     *
     * @param src
     * @return string
     */
    public static String tZero(String src) {
        if (isNull(src) || src.equalsIgnoreCase("null") || src.equalsIgnoreCase("undefined"))
            return "0";
        return src.trim();
    }

    /**
     * 字符串为空时，返回"1"，否则返回本身
     *
     * @return
     */
    public static String tOne(String src) {
        if (isNull(src) || src.equalsIgnoreCase("null") || src.equalsIgnoreCase("undefined"))
            return "1";
        return src.trim();
    }

    /**
     * 返回一个长整数字，如果字符串为空或者不是数字形式的字符串，那么返回空
     *
     * @param src
     * @return
     */
    public static Long tLong(String src) {
        if (!StringUtil.isNull(src)) {
            try {
                return Long.parseLong(tTrim2(src));
            } catch (NumberFormatException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static Long tLongNull(Long src) {
        try {
            if (null == src) {
                return 0l;
            } else {
                return src;
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * 转换一个字符串为长整型数，如果转换失败，那么返回默认的值
     *
     * @param src 需要转换的长整型数字符
     * @param M   默认值通常为 0L
     * @return
     */
    public static Long tLongM(String src, final Long M) {
        if (!StringUtil.isNull(src)) {
            try {
                return Long.parseLong(tTrim2(src));
            } catch (NumberFormatException e) {
                return M;
            }
        } else {
            return null;
        }
    }

    /**
     * 返回一个整数字，如果字符串为空或者不是数字形式的字符串，那么返回空
     *
     * @param src
     * @return
     */
    public static Integer tInteger(String src) {
        if (!StringUtil.isNull(src)) {
            try {
                return Integer.parseInt(tTrim2(src));
            } catch (NumberFormatException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 返回一个短整数字，如果字符串为空或者不是数字形式的字符串，那么返回空
     *
     * @param src
     * @return
     */
    public static Short tShort(String src) {
        if (!StringUtil.isNull(src)) {
            try {
                return Short.parseShort(tTrim2(src));
            } catch (NumberFormatException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 返回一个DOUBLE数字，如果字符串为空或者不是数字形式的字符串，那么返回空
     *
     * @param src
     * @return
     */
    public static Double tDouble(String src) {
        if (!StringUtil.isNull(src)) {
            try {
                return Double.parseDouble(tTrim2(src));
            } catch (NumberFormatException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static BigDecimal tBigDecimal(String src) {
        if (!StringUtil.isNull(src)) {
            try {
                return new BigDecimal(src);
            } catch (NumberFormatException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 返回一个FLOAT数字，如果字符串为空或者不是数字形式的字符串，那么返回空
     *
     * @param src
     * @return
     */
    public static Float tFloat(String src) {
        if (!StringUtil.isNull(src)) {
            try {
                return Float.parseFloat(src);
            } catch (NumberFormatException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 字符串去左右空格
     *
     * @param src
     * @return s
     */
    public static String tTrim(String src) {
        if (isNull(src) || src.equalsIgnoreCase("null") || src.equalsIgnoreCase("undefined"))
            return "";
        // 2012.05.19 delete by www
        // src = Tool.replaceAll(src, "'", "′");
        return src.trim();
    }

    /**
     * 判断是否为空
     *
     * @param src
     * @return s
     */
    public static Boolean ifNull(String src) {
        if ("".equals(tTrim(src))) {
            return true;
        }
        return false;
    }

    /**
     * 数组内容 转换为字符串
     *
     * @param src
     * @return string
     */
    public static String array2String(String src[]) {
        String mes = "";
        for (int i = 0; src != null && i < src.length; i++)
            mes += src[i] + ",";
        if (mes.endsWith(","))
            mes = mes.substring(0, mes.length() - 1);
        return mes;
    }

    /**
     * 判断一个字符串是否是一个串列表的子集
     *
     * @param parent
     * @param child
     * @return boolean
     */
    public static boolean isInList(String parent, String child) {
        parent = "," + parent + ",";
        return parent.indexOf("," + child + ",") > -1;
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj == "") {
            return true;
        } else if (obj instanceof JSONNull) {
            return true;
        } else if (obj instanceof String) {
            if (((String) obj).length() == 0) {
                return true;
            }
        } else if (obj instanceof Collection) {
            if (((Collection) obj).isEmpty()) {
                return true;
            }
        } else if (obj instanceof Map) {
            if (((Map) obj).size() == 0)
                return true;
        }

        return false;
    }

    public static boolean isNotEmpty(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj == "") {
            return false;
        } else if (obj instanceof JSONNull) {
            return false;
        } else if (obj instanceof String) {
            if (((String) obj).length() == 0) {
                return false;
            }
        } else if (obj instanceof Collection) {
            if (((Collection) obj).isEmpty()) {
                return false;
            }
        } else if (obj instanceof Map) {
            if (((Map) obj).size() == 0)
                return false;
        }

        return true;
    }

    /**
     * 从列表里删除
     *
     * @param parent
     * @param child
     * @return string
     */
    public static String deleteFromList(String parent, String child) {
        if (!isInList(parent, child))
            return parent;
        parent = "," + parent + ",";
        parent = parent.replaceAll("," + child + ",", ",").replaceFirst("^,", "").replaceFirst(",$", "");
        return parent;
    }

    /**
     * 获得字符串source的tag后面的字符串
     *
     * @param source
     * @param tag
     * @return
     */
    public static String indexFormTag(String source, String tag) {
        if (isNull(source) || isNull(tag)) {
            return tTrim(source);
        }

        String str = tTrim(source);
        String ta = tTrim(tag);

        int index = 0;
        if (str.contains(ta)) {
            index = str.indexOf(ta) + ta.length();
        }

        return str.substring(index);
    }

    /**
     * 获得根据编码字符信息
     *
     * @param strSource
     * @return string
     */
    public static String getStr(String strSource) {
        String strResult = "";
        if (strSource != null) {
            try {
                strResult = new String(strSource.getBytes("ISO8859_1"), "UTF-8");
                // strResult = replaceAll(strResult,"'","''");
            } catch (Exception e) {
                strResult = "";
            }
        }
        return strResult;
    }

    /**
     * 获得根据编码字符信息
     *
     * @param strSource
     * @return string
     */
    public static String getStrFromObj(Object strSource) {
        String strResult = "";
        if (strSource != null) {
            try {
                strResult = String.valueOf(strSource);
                // strResult = replaceAll(strResult,"'","''");
            } catch (Exception e) {
                strResult = "";
            }
        }
        return strResult;
    }

    /**
     * 往列表里添加内容
     *
     * @param parent
     * @param child
     * @return string
     */
    public static String add2List(String parent, String child) {
        // 验证是否已经存在
        if (isInList(parent, child))
            return parent;
        if (parent.indexOf(",") > -1)
            return parent + "," + child;
        return child;
    }

    /**
     * @param src
     * @param length
     * @return string
     */
    public static String pop(String src, int length) {
        if (isNull(src))
            return "";
        if (src.length() <= length)
            return src;
        return "<span title=\"" + src + "\">" + src.substring(0, length) + "..</span>";
    }

    /**
     * @param src
     * @param length
     * @return string
     */
    public static String cut(String src, int length) {
        if (isNull(src))
            return "";
        if (src.length() <= length)
            return src;
        return src.substring(0, length) + "..";
    }

    /**
     * 格式化日期为年月日
     *
     * @param date
     * @return string
     */
    public static String getDateStringYMD(Date date) {
        if (date == null || date.equals(""))
            return null;
        return dateFormat(date, "yyyy-MM-dd");
    }

    /**
     * 格式化日期为年月日
     *
     * @param date
     * @return string
     */
    public static String getDateStringYMDToCN(Date date) {
        if (date == null || date.equals(""))
            return null;
        return dateFormat(date, "yyyy年MM月dd日");

    }

    /**
     * 格式化日期为年月
     *
     * @param date
     * @return string
     */
    public static String getDateStringYM(Date date) {
        if (date == null || date.equals(""))
            return null;
        return dateFormat(date, "yyyy-MM");

    }

    /**
     * 格式化日期为年月日yyyyMMdd
     *
     * @param date
     * @return string
     */
    public static String getDateStringyMd(Date date) {
        if (date == null || date.equals(""))
            return null;
        return dateFormat(date, "yyyyMMdd");

    }

    /**
     * 格式化日期为dd/MM/yyyy
     *
     * @param date
     * @return string
     */
    public static String getDateStringDMY(Date date) {
        if (date == null || date.equals(""))
            return "";
        return dateFormat(date, "dd/MM/yyyy");

    }

    /**
     * 格式化日期为月日
     *
     * @param date
     * @return string
     */
    public static String getDateStringMD(Date date) {
        if (date == null || date.equals(""))
            return "";
        return dateFormat(date, "MM-dd");

    }

    /**
     * 格式化日期为年月日 时分秒
     *
     * @param date
     * @return string
     */
    public static String getDateStringYMDHMS(Date date) {
        if (date == null || date.equals(""))
            return "";
        return dateFormat(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 格式化日期为时分
     *
     * @param date
     * @return string
     */
    public static String getDateStringHHMM(Date date) {
        if (date == null || date.equals(""))
            return "";
        return dateFormat(date, "HH:mm");
    }

    /**
     * 格式化日期为年月日 时分秒
     *
     * @param date
     * @return string
     */
    public static String getStringYMDHMS(Date date) {
        if (date == null || date.equals(""))
            return "";
        return dateFormat(date, "yyyy年MM月dd日 hh时mm分ss秒");
    }

    /**
     * 字符串转化为时间 yyyyMMdd
     *
     * @param
     * @return date
     * @throws ParseException
     */
    public static Date getStrDateFormat(String string) throws ParseException {
        if (string == null || "".equals(string))
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.parse(string);
    }

    /**
     * 从字符值转换为字符串日期
     *
     * @param
     * @param
     * @return
     */
    public static Date getDateFromString(String dateStr) throws ParseException {
        if (dateStr == null || "".equals(dateStr))
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(dateStr);
    }

    /**
     * 从字符值转换为字符串日期
     *
     * @param
     * @param
     * @return
     */
    public static Date getDateFromStringYMD(String dateStr) throws ParseException {
        if (dateStr == null || "".equals(dateStr))
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(dateStr);
    }

    public static String getThreeMonthsagoDay() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -90);
        date = calendar.getTime();

        return dateFormat(date, "yyyy-MM-dd");
    }

    /**
     * 字符串转换为日期型数据
     *
     * @param src
     * @return date
     */
    public static Date parseDate(String src) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        if (src.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
            sf = new SimpleDateFormat("yyyy-MM-dd");
        }
        if (src.matches("\\d{4}/\\d{1,2}/\\d{1,2}")) {
            sf = new SimpleDateFormat("yyyy/MM/dd");
        }
        if (src.matches("\\d{1,2}-\\d{1,2}-\\d{4}")) {
            sf = new SimpleDateFormat("dd-MM-yyyy");
        }
        if (src.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) {
            sf = new SimpleDateFormat("dd/MM/yyyy");
        }
        try {
            return sf.parse(src);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 字符串转换为日期型数据
     *
     * @param src
     * @return date
     */
    public static Date parseDate(String src, String format) {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        try {
            return sf.parse(src);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 得到当前系统时间
     *
     * @param format yyyyMMddHHmmss
     * @return
     */
    public static String getSysDate(String format) {
        Calendar col = Calendar.getInstance();
        SimpleDateFormat sdfTo = new SimpleDateFormat(format);
        return sdfTo.format(col.getTime());
    }

    /**
     * 得到当前系统时间的长整型数值
     *
     * @param format
     * @return
     */
    public static Long getSysDateLong(String format) {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(new SimpleDateFormat(format).parse(getSysDate(format)));
            return c.getTimeInMillis();
        } catch (Exception e) {
            e.printStackTrace();
            return 0l;
        }
    }

    /**
     * 从整形值根据传入的格式转换为字符串日期
     *
     * @param dateMillis
     * @param
     * @return
     */
    public static String getDateFromLongDateMillis(Long dateMillis) {
        Date date = new Date(dateMillis);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 比较两个日期月份大小
     *
     * @param DATE1
     * @param DATE2
     * @return 1:DATE1大于DATE2 -1:DATE1小于DATE2 0:DATE1等于DATE2 2:传入参数为空
     */
    public static int compare_date(String DATE1, String DATE2, String format) {
        if (StringUtil.isNull(DATE1) || StringUtil.isNull(DATE2)) {
            return 2;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date dt1 = sdf.parse(DATE1);
            Date dt2 = sdf.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 时间转化为字符串
     *
     * @param date
     * @param format
     * @return string
     */
    private static String dateFormat(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 判断一个字串是否为空
     *
     * @param str
     * @return boolean
     */
    public static boolean isNull(String str) {
        return str == null || str.trim().equals("") || str.trim().equals("null");
    }

    /**
     * 验证一个串是否是一个数字组合 用于GET参数传递的验证
     *
     * @param src
     * @return boolean
     */
    public static boolean isNumber(String src) {
        if (src == null || src.equals(""))
            return false;
        return src.matches("^-?(\\d+)|(\\d+\\.?\\d+)$");
    }

    /**
     * 如果源字符串为空,则返回替换字符串.否则返回源字符串
     *
     * @param source 源字符串
     * @param sp     替换字符串
     * @return
     */
    public static String formatString(String source, String sp) {
        if (isNull(source)) {
            return isNull(sp) ? "" : tTrim(sp);
        }
        return tTrim(source);
    }

    /**
     * 使数字字符串添加n位小说位,至少2位
     *
     * @param src
     * @param n
     * @return
     */
    public static String getNumber(String src, int n) {

        if (n < 2) {
            n = 2;
        }

        if (isNumber(src)) {
            src = src.trim();
            if (!src.contains(".")) {
                src += ".00";
            }

            int index = src.indexOf(".");
            String num = src.substring(0, index);
            String deci = src.substring(index + 1, src.length());

            String strs[] = src.split("\\.");
            if (deci.length() < n) {
                for (int i = 0; i < n - deci.length(); i++) {
                    src += "0";
                }
            } else if (strs[1].length() > n) {
                src = src.substring(0, num.length() + 1 + n);
            }
        } else {
            src = "0.00";
        }

        return src;
    }

    /**
     * 转换带分隔符串为Integer数组 后台中用到
     *
     * @param src
     * @return integer[]
     */
    public static Integer[] getIntegerFromString(String src) {
        if (!src.matches("^\\d+[,\\d+]{0,}\\d{0,}$"))
            return new Integer[]{};
        String _src[] = src.split(",");
        Integer[] ret = new Integer[_src.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = Integer.valueOf(_src[i]);
        }
        return ret;
    }

    /**
     * 转换带分隔符串为Long数组 后台中用到
     *
     * @param src
     * @return long[]
     */
    public static Long[] getLongFromString(String src) {
        if (!src.matches("^\\d+[,\\d+]{0,}\\d{0,}$"))
            return new Long[]{};
        String _src[] = src.split(",");
        Long[] ret = new Long[_src.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = Long.valueOf(_src[i]);
        }
        return ret;
    }

    /**
     * 特殊处理文本内容，对关键字可以添加前缀后缀，实现关键字着重显示 例 specilizeText("中国人","国","<font color=red>","</font>"); 结果为 中<font color=red>国</font>人
     *
     * @param content
     * @param keywords
     * @param prefix
     * @param suffix
     * @return string
     */
    public static String specilizeText(String content, String keywords, int holdLength, String prefix, String suffix) {
        String reg = keywords.replaceAll("\\s", ".*");
        Pattern p = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(content);

        if (m.find()) {
            // 能匹配
            int start = m.start();
            int end = start + holdLength;
            if (end > content.length())
                end = content.length();
            String temp = (start > 0 ? "..." : "") + content.substring(start, end) + (end < content.length() - 1 ? "..." : "");
            reg = keywords.replaceAll("\\s", "|");
            temp = temp.replaceAll("(" + reg + ")", prefix + "$1" + suffix);
            return temp;
        }
        return cut(content, holdLength);
    }

    /**
     * 字符串dd/MM/yyyy转换为日期型数据
     *
     * @param src
     * @return date
     */
    public static Date parseStringtoDate(String src) {
        if (!src.matches("^\\d{2}/\\d{2}/\\d{4}$"))
            return null;
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sf.parse(src);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 计算两个日期之差
     *
     * @param date
     * @param date1
     * @return
     */
    public static int diffDate(Date date, Date date1) {
        return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
    }

    public static long getMillis(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    /**
     * 比较两个日期月份大小
     *
     * @param date1
     * @param date2
     * @return 0:两个日期在同一月份，1：日期1在日期2的前一月，-1：其它
     * @author www 2011-03-02 19:24
     */
    public static int compare_isSameMonth(String date1, String date2) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            Date dt1 = sdf.parse(date1);
            Date dt2 = sdf.parse(date2);
            Calendar c1 = Calendar.getInstance();
            c1.setTime(dt1);
            Calendar c2 = Calendar.getInstance();
            c2.setTime(dt2);

            int m1 = c1.get(Calendar.MONTH) + 1;
            int m2 = c2.get(Calendar.MONTH) + 1;

            if (m1 == m2) { // 两日期在同一月份
                return 0;
            } else if (m1 == (m2 - 1)) { // 日期1在日期2的上一月
                return 1;
            } else { // 其它
                return -1;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 比较两个日期月份大小
     *
     * @param DATE1
     * @param DATE2
     * @return
     */
    public static int compare_date(String DATE1, String DATE2) {

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        try {
            Date dt1 = sdf.parse(DATE1);
            Date dt2 = sdf.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /***************************************************************************
     * 计算两个日期之间的月份数
     *
     * @param date1
     * @param date2
     * @return 返回月份数
     */
    public static int getMonths(Date date1, Date date2) {
        int iMonth = 0;
        int flag = 0;
        try {
            Calendar objCalendarDate1 = Calendar.getInstance();
            objCalendarDate1.setTime(date1);
            Calendar objCalendarDate2 = Calendar.getInstance();
            objCalendarDate2.setTime(date2);

            if (objCalendarDate2.equals(objCalendarDate1)) {
                return 0;
            }
            if (objCalendarDate1.after(objCalendarDate2)) {
                Calendar temp = objCalendarDate1;
                objCalendarDate1 = objCalendarDate2;
                objCalendarDate2 = temp;
            }
            if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1.get(Calendar.DAY_OF_MONTH)) {
                flag = 1;
            }
            if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1.get(Calendar.YEAR)) {
                iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1.get(Calendar.YEAR)) * 12 + objCalendarDate2.get(Calendar.MONTH) - flag) - objCalendarDate1.get(Calendar.MONTH);
            } else {
                iMonth = objCalendarDate2.get(Calendar.MONTH) - objCalendarDate1.get(Calendar.MONTH) - flag;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iMonth;
    }

    /**
     * 获取INT型数据
     *
     * @param src 字符串
     * @return
     */
    public static int getIntForString(String src) {
        int num = 0;
        try {
            num = Integer.parseInt(src);
        } catch (NumberFormatException e1) {
            e1.printStackTrace();
        }
        return num;
    }


    /***
     * 验证字符串中是否含有非法字符
     *
     * @param str
     * @return true：有非法字符 false:没有非法字符
     */
    public static boolean matchStr(String str) {
        if (isNull(str)) {
            return false;
        }
        String reg = "select|update|delete|exec|count|'|\"|=|;|>|<|%";
        if (str.matches(reg)) {
            return true;
        }
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            String s = String.valueOf(ch[i]);
            if (s.matches(reg)) {
                return true;
            }
        }
        return false;
    }

    /***
     * 字符串为空时，返回"0.0",否则返回本身
     *
     * @return String
     */
    public static String tZerozero(String src) {
        if (isNull(src) || src.equalsIgnoreCase("null") || src.equalsIgnoreCase("undefined")) {
            return "0.0";
        }
        return src.trim();
    }

    /***
     * 计算字符串的字节长度
     *
     * @param str
     * @return
     */
    public static int getStrLen(String str) {
        if (isNull(str)) {
            return 0;
        }

        byte[] by = str.getBytes();
        return by.length;
    }

    /***
     * 根据传入的字符串，如果不满足传入的位数，就在字符串前边补0
     *
     * @param str
     *            传入的字符串
     * @param num
     *            要求的字符串位数
     * @return 返回结果
     */
    public static String getAddZeroStr(String str, int num) {
        str = isNull(str) ? "" : str.trim();
        for (int i = str.length(); i < num; i++) {
            str = "0" + str;
        }
        return str;
    }


    /**
     * 将传入工作日的数字格式转化成汉字格式
     *
     * @param
     * @return String
     * @author zm
     */
    public static String getWorkDayTOChinese(String intworkday) {
        String[] workdayArray = intworkday.split(",");
        StringBuffer sb = new StringBuffer();
        for (String workdaystr : workdayArray) {
            switch (workdaystr) {
                case "0":
                    sb.append("星期日,");
                    break;
                case "1":
                    sb.append("星期一,");
                    break;
                case "2":
                    sb.append("星期二,");
                    break;
                case "3":
                    sb.append("星期三,");
                    break;
                case "4":
                    sb.append("星期四,");
                    break;
                case "5":
                    sb.append("星期五,");
                    break;
                case "6":
                    sb.append("星期六,");
                    break;
            }
        }
        int lastindex = sb.toString().lastIndexOf(",");
        return sb.toString().substring(0, lastindex);
    }

    /**
     * 如果原值为null则替换为新值
     *
     * @param oldStr 原值
     * @param newStr 替换的新值
     * @return
     */
    public static String killNull(String oldStr, String newStr) {
        if (oldStr == null) {
            return newStr;
        } else {
            return oldStr;
        }
    }

}