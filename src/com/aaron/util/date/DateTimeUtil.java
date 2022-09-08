package com.aaron.util.date;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间日期工具类
 * 
 * @author huangbo
 * @date 2022/9/8
 */
public class DateTimeUtil {
    /**
     * 缺省的日期显示格式： yyyy-MM
     */
    public static final String DATE_FORMAT_YYYYMM = "yyyy-MM";

    /**
     * 缺省的日期显示格式： yyyy-MM-dd
     */
    public static final String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";

    /**
     * 缺省的日期时间显示格式：yyyy-MM-dd HH:mm:ss
     */
    public static final String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 缺省的日期时间显示格式：yyyy-MM-dd HH:mm
     */
    public static final String DATE_FORMAT_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";

    /**
     * 缺省的日期时间显示格式：yyyy-MM-dd HH
     */
    public static final String DATE_FORMAT_YYYYMMDDHH = "yyyy-MM-dd HH";

    /**
     * 缺省的时间显示格式：HH:mm:ss
     */
    public static final String DATE_FORMAT_HHMMSS = "HH:mm:ss";

    /**
     * 缺省的时间显示格式：HH:mm
     */
    public static final String DATE_FORMAT_HHMM = "HH:mm";

    /**
     * 1s中的毫秒数
     */
    private static final int MILLIS = 1000;

    /**
     * 一年当中的月份数
     */
    private static final int MONTH_PER_YEAR = 12;
    /**
     * 默认日期格式
     */
    public static String DEFAULT_FORMAT = "yyyy-MM-dd";

    /**
     * 私有构造方法，禁止对该类进行实例化
     */
    private DateTimeUtil() {}

    /**
     * 获取系统当前日期时间
     *
     * @return 当前日期时间
     */
    public static Date getNow() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 当前日期 格式：yyyy-MM-dd
     *
     * @return 当前日期
     */
    public static String getDate() {
        return getDateTime(DATE_FORMAT_YYYYMMDD);
    }

    /**
     * 当前日期 格式：yyyy-MM-dd HH:mm:ss
     *
     * @return 当前日期及时间
     */
    public static String getDateTime() {
        return getDateTime(DATE_FORMAT_YYYYMMDDHHMMSS);
    }

    /**
     * 获取系统当前日期及时间，并用指定的方式格式化
     *
     * @param pattern
     *            显示格式
     * @return 当前日期及时间
     */
    public static String getDateTime(String pattern) {
        Date datetime = Calendar.getInstance().getTime();
        return getDateTime(datetime, pattern);
    }

    /**
     * 获取用指定方式格式化的日期
     *
     * @param date
     *            需要进行格式化的日期
     * @param pattern
     *            显示格式
     * @return 日期时间字符串
     */
    public static String getDateTime(Date date, String pattern) {
        if (StringUtil.isBlank(pattern)) {
            pattern = DATE_FORMAT_YYYYMMDDHHMMSS;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    /**
     * 获取当前年份
     *
     * @return 当前年份
     */
    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);

    }

    /**
     * 获取当前月份
     *
     * @return 当前月份
     */
    public static int getCurrentMonth() {
        // 用get获取的月份数比实际的小1，需要加上
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    /**
     * 获取当前日
     *
     * @return 当前日
     */
    public static int getCurrentDay() {
        return Calendar.getInstance().get(Calendar.DATE);
    }

    /**
     * 改变当前时间的秒数
     *
     * @param date
     *            基准时间
     * @param seconds
     *            要增加或者减少的秒数（减少用负数表示）
     * @param pattern
     *            日期格式
     * @return 改变后的时间
     */
    public static String addSeconds(Date date, int seconds, String pattern) {
        return getDateTime(addSeconds(date, seconds), pattern);
    }

    /**
     * 改变当前时间的秒数
     *
     * @param date
     *            基准时间
     * @param seconds
     *            要增加或者减少的秒数（减少用负数表示）
     * @return 改变后的时间
     */
    public static Date addSeconds(Date date, int seconds) {
        return add(date, seconds, Calendar.SECOND);
    }

    /**
     * 改变当前时间的分钟数
     *
     * @param date
     *            基准时间
     * @param minutes
     *            要增加或者减少的分钟数（减少用负数表示）
     * @param pattern
     *            日期格式
     * @return 改变后的时间
     */
    public static String addMinutes(Date date, int minutes, String pattern) {
        return getDateTime(addMinutes(date, minutes), pattern);
    }

    /**
     * 改变当前时间的分钟数
     *
     * @param date
     *            基准时间
     * @param minutes
     *            要增加或者减少的分钟数（减少用负数表示）
     * @return 改变后的时间
     */
    public static Date addMinutes(Date date, int minutes) {
        return add(date, minutes, Calendar.MINUTE);
    }

    /**
     * 改变当前时间的小时
     *
     * @param date
     *            基准时间
     * @param hours
     *            要增加或者减少的小时（减少用负数表示）
     * @param pattern
     *            日期格式
     * @return 改变后的时间
     */
    public static String addHours(Date date, int hours, String pattern) {
        return getDateTime(addHours(date, hours), pattern);
    }

    /**
     * 改变当前时间的小时
     *
     * @param date
     *            基准时间
     * @param hours
     *            要增加或者减少的小时（减少用负数表示）
     * @return 改变后的时间
     */
    public static Date addHours(Date date, int hours) {
        return add(date, hours, Calendar.HOUR);
    }

    /**
     * 取得当前日期以后若干天的日期。如果要获取以前的日期，参数用负数。 例如要获取上星期同一天的日期，参数则为-7
     *
     * @param date
     *            基准时间
     * @param days
     *            增加的日期数
     * @param pattern
     *            日期格式
     * @return 改变以后的日期
     */
    public static String addDays(Date date, int days, String pattern) {
        return getDateTime(addDays(date, days), pattern);
    }

    /**
     * 取得指定日期以后若干天的日期。如果要获取以前的日期，参数用负数。
     *
     * @param date
     *            基准时间
     * @param days
     *            增加的日期数
     * @return 改变以后的日期
     */
    public static Date addDays(Date date, int days) {
        return add(date, days, Calendar.DATE);
    }

    /**
     * 取得当前日期以后某月的日期。如果要获取以前月份的日期，参数用负数。
     *
     * @param date
     *            基准时间
     * @param months
     *            增加的月份数
     * @param pattern
     *            日期格式
     * @return 改变以后的日期
     */
    public static String addMonths(Date date, int months, String pattern) {
        return getDateTime(addMonths(date, months), pattern);
    }

    /**
     * 取得指定日期以后某月的日期。如果要获取以前月份的日期，参数用负数。 注意，可能不是同一日子，例如2003-1-31加上一个月是2003-2-28
     *
     * @param date
     *            基准时间
     * @param months
     *            增加的月份数
     * @return 改变以后的日期
     */
    public static Date addMonths(Date date, int months) {
        return add(date, months, Calendar.MONTH);
    }

    /**
     * 取得当前日期以后某年的日期
     *
     * @param date
     *            基准时间
     * @param years
     *            增加的年份数
     * @param pattern
     *            日期格式
     * @return 改变以后的日期
     */
    public static String addYears(Date date, int years, String pattern) {
        return getDateTime(addYears(date, years), pattern);
    }

    /**
     * 取得当前日期以后某年的日期
     *
     * @param date
     *            基准时间
     * @param years
     *            增加的年份数
     * @return 改变以后的日期
     */
    public static Date addYears(Date date, int years) {
        return add(date, years, Calendar.YEAR);
    }

    /**
     * 内部方法。为指定日期增加相应的天数或月数
     *
     * @param date
     *            基准时间
     * @param amount
     *            改变的数量
     * @param field
     *            改变的时间的单位，年、月、日、时、分、秒等
     * @return 改变以后的日期
     */
    private static Date add(Date date, int amount, int field) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * 通过date对象取得格式为小时:分钟的字符串
     *
     * @return
     */
    public static String getHourMin(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        StringBuffer sf = new StringBuffer();
        sf.append(calendar.get(Calendar.HOUR_OF_DAY));
        sf.append(":");
        sf.append(calendar.get(Calendar.MINUTE));
        return sf.toString();
    }

    /**
     * 计算两个日期相差天数。 用第一个日期减去第二个。如果前一个日期小于后一个日期，则返回负数
     *
     * @param one
     *            第一个日期数，作为基准
     * @param two
     *            第二个日期数，作为比较
     * @return 两个日期相差天数
     */
    public static long diffDays(Date one, Date two) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(one);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH), 0,
            0, 0);
        Date d1 = calendar.getTime();
        calendar.clear();
        calendar.setTime(two);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH), 0,
            0, 0);
        Date d2 = calendar.getTime();
        final int MILISECONDS = 24 * 60 * 60 * 1000;
        BigDecimal r = BigDecimal.valueOf(Double.valueOf((d1.getTime() - d2.getTime())) / MILISECONDS);
        return Math.round(r.doubleValue());
    }

    /**
     * 计算两个日期相差月份数 如果前一个日期小于后一个日期，则返回负数
     *
     * @param one
     *            第一个日期数，作为基准
     * @param two
     *            第二个日期数，作为比较
     * @return 两个日期相差月份数
     */
    public static int diffMonths(Date one, Date two) {

        Calendar calendar = Calendar.getInstance();

        // 获取第一个日期的年分和月份数
        calendar.setTime(one);
        int yearOne = calendar.get(Calendar.YEAR);
        int monthOne = calendar.get(Calendar.MONDAY);
        // 获取第二个日期的年份和月份
        calendar.setTime(two);
        int yearTwo = calendar.get(Calendar.YEAR);
        int monthTwo = calendar.get(Calendar.MONDAY);

        return (yearOne - yearTwo) * MONTH_PER_YEAR + (monthOne - monthTwo);
    }

    /**
     * 计算两个日期相差年份数 如果前一个日期小于后一个日期，则返回负数
     *
     * @param one
     *            第一个日期数，作为基准
     * @param two
     *            第二个日期数，作为比较
     * @return 两个日期相差月份数
     */
    public static int diffYears(Date one, Date two) {

        Calendar calendar = Calendar.getInstance();

        // 获取第一个日期的年分
        calendar.setTime(one);
        int yearOne = calendar.get(Calendar.YEAR);
        // 获取第二个日期的年份
        calendar.setTime(two);
        int yearTwo = calendar.get(Calendar.YEAR);

        return yearOne - yearTwo;
    }

    /**
     * 获取某一个日期的年份
     *
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 将一个字符串用给定的格式转换为日期类型。 注意：如果返回null，则表示解析失败
     *
     * @param dateStr
     *            需要解析的日期字符串
     * @param pattern
     *            日期字符串的格式，默认为"yyyy-MM-dd"的形式
     * @return 解析后的日期
     */
    public static Date parse(String dateStr, String pattern) {
        Date date = null;
        if (StringUtil.isBlank(pattern)) {
            pattern = DATE_FORMAT_YYYYMMDD;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 返回本月的最后一天
     *
     * @return 本月最后一天的日期
     */
    public static Date getMonthLastDay() {
        return getMonthLastDay(getNow());
    }

    /**
     * 返回给定日期中的月份中的最后一天
     *
     * @param date
     *            基准日期
     * @return 该月最后一天的日期
     */
    public static Date getMonthLastDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // 将日期设置为下一月第一天
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, 1);

        // 减去1天，获取的即本月的最后一天
        calendar.add(Calendar.DATE, -1);

        return calendar.getTime();
    }

    /**
     * 计算两个具体日期之间的秒差，第一个日期-第二个日期
     *
     * @param date1
     * @param date2
     * @param onlyTime
     *            是否只计算2个日期的时间差异，忽略日期，true代表只计算时间差
     * @return
     */
    public static long diffSeconds(Date date1, Date date2, boolean onlyTime) {
        if (onlyTime) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);
            // calendar.set(1984, 5, 24);
            long t1 = calendar.getTimeInMillis();
            calendar.setTime(date2);
            // calendar.set(1984, 5, 24);
            long t2 = calendar.getTimeInMillis();
            return (t1 - t2) / MILLIS;
        } else {
            return (date1.getTime() - date2.getTime()) / MILLIS;
        }
    }

    /**
     * 计算两个具体日期之间的秒差，第一个日期-第二个日期
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long diffSeconds(Date date1, Date date2) {
        return diffSeconds(date1, date2, false);
    }

    /**
     * 根据日期确定星期几:1-星期日，2-星期一.....
     *
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        int mydate = cd.get(Calendar.DAY_OF_WEEK);
        return mydate;
    }

    /**
     * 验证是否在有效期内(跟当前日期比较)
     *
     * @param validDate
     *            要比较的时间
     * @param format
     *            日期字符串的格式
     * @return
     */
    public static boolean isValidDate(String validDate, String format) {
        return isValidDate(validDate, getDateTime(), format);
    }

    /**
     * 验证是否在有效期内(跟当前日期比较)
     *
     * @param validDate
     *            要比较的时间
     * @param date
     *            基准时间
     * @param format
     *            日期字符串的格式
     * @return
     */
    public static boolean isValidDate(String validDate, String date, String format) {
        if (validDate == null || validDate.equals("")) {
            return false;
        }
        Date valid = null;
        Date now = new Date();
        valid = parse(validDate, format);
        now = parse(date, format);
        return valid.after(now);
    }

    // TODO: 2022/9/8
    ///////////////////////

    /**
     * 毫秒数转成指定日期格式
     * 
     * @param millSec
     *            时间毫秒数
     * @return 指定格式日期，默认格式：yyyy-MM-dd HH:mm:ss
     */
    public static String longToDate(Long millSec, String pattern) {
        if (StringUtil.isBlank(pattern)) {
            pattern = DATE_FORMAT_YYYYMMDDHHMMSS;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = new Date(millSec);
        return sdf.format(date);
    }

    /**
     * string类型日期转换date类型日期
     * 
     * @param pattern
     *            日期格式
     * @param strTime
     *            string类型日期，如：2021-08-18 00:00:00
     * @return
     * @throws ParseException
     */
    public static Date str2Date(String pattern, String strTime) throws ParseException {
        if (StringUtil.isBlank(pattern)) {
            pattern = DATE_FORMAT_YYYYMMDDHHMMSS;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.parse(strTime);
    }

    /**
     * 获取指定日期所在月第一天
     *
     * @param time
     *            指定日期
     * @return
     * @throws Exception
     */
    public static Date firstDayOfMonth(Date time) throws ParseException {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取指定日期所在月最后一天
     *
     * @param time
     *            指定日期
     * @return
     * @throws Exception
     */
    public static Date lastDayOfMonth(Date time) throws Exception {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

    /**
     * 
     * date类型日期转换string类型日期
     *
     * @param pattern
     *            日期格式
     * @param date
     *            date类型日期
     * @return string类型日期，如：2021-08-18 00:00:00
     * @throws ParseException
     */
    public static String date2Str(String pattern, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * 获取string类型时间字符串的年份
     *
     * @param strDate
     *            string类型时间
     * @return
     */
    public static int getDateStringYear(String strDate) {
        int index = strDate.indexOf('-');
        int year = Integer.parseInt(strDate.substring(0, index));
        return year;
    }

    /**
     * 将string类型时间字符串转换为时间戳
     *
     * @param pattern
     *            string类型时间字符串日期格式
     * @param strDate
     *            string类型时间字符串
     * @return
     * @throws Exception
     */
    public static long dateToStamp(String pattern, String strDate) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(strDate);
        long time = date.getTime();
        return time;
    }

    /**
     * 将时间戳转换为string类型时间字符串
     *
     * @param pattern
     *            日期格式
     * @param stamp
     * @return string类型时间字符串
     * @throws Exception
     */
    public static String stampToTime(String pattern, long stamp) throws Exception {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = new Date(stamp);// 将时间调整为yyyy-MM-dd HH:mm:ss时间样式
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 耗时统计格式化: 时 分 秒
     *
     * @param millis
     * @return
     */
    public static String getCostTime(Long millis) {
        String costTime = String.format("%d h %d min %d sec", millis / (1000 * 60 * 60),
            (millis % (1000 * 60 * 60)) / (1000 * 60), ((millis % (1000 * 60 * 60)) % (1000 * 60)) / 1000);
        return costTime;
    }

    /**
     * 获取时间段间的string类型时间
     *
     * @param startDate
     *            开始时间
     * @param endDate
     *            结束时间
     * @param dateNum
     *            取多少个时间点
     * @return
     */
    public static List<String> getBetweenDates(Date startDate, Date endDate, int dateNum) {
        long start = startDate.getTime();
        long end = endDate.getTime();
        List<String> dates = new ArrayList<>();
        if (end > start) {
            long subtract = end - start;
            long mod = subtract % dateNum;
            long trunc = subtract / dateNum;

            long tmpDate = 0;
            for (int i = 0; i < dateNum; i++) {
                if (i == 0) {
                    tmpDate = start;
                } else if (i == dateNum && mod != 0) {
                    tmpDate = tmpDate + mod;
                } else {
                    tmpDate = tmpDate + trunc;
                }
                dates.add(getDateTime(new Date(tmpDate), DATE_FORMAT_YYYYMMDDHHMMSS));
            }
        }
        return dates;
    }

    /**
     * 判断日期是否满足格式要求
     *
     * @param strDate
     * @param pattern
     * @return
     */
    public static boolean checkDate(String strDate, String pattern) {

        boolean dateFlag = true;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);
            sdf.parse(strDate);
        } catch (ParseException | NullPointerException e) {
            dateFlag = false;
        }

        return dateFlag;
    }

    /**
     * 获取date类型时间的开始时间 00:00:00:00
     *
     * @param date
     *            指定时间
     * @return
     */
    public static Long getDayStartTime(Date date) {
        Calendar dateStart = Calendar.getInstance();
        dateStart.setTime(date);
        dateStart.set(Calendar.HOUR_OF_DAY, 0);
        dateStart.set(Calendar.MINUTE, 0);
        dateStart.set(Calendar.SECOND, 0);
        return dateStart.getTime().getTime();
    }

    /**
     * 获取date类型时间的开始时间 23:59:59:999
     *
     * @param date
     *            指定时间
     * @return
     */
    public static Long getDayEndTime(Date date) {
        Calendar dateEnd = Calendar.getInstance();
        dateEnd.setTime(date);
        dateEnd.set(Calendar.HOUR_OF_DAY, 23);
        dateEnd.set(Calendar.MINUTE, 59);
        dateEnd.set(Calendar.SECOND, 59);
        return dateEnd.getTime().getTime();
    }

    /**
     * 获取月开始时间
     *
     * @param date
     *            指定时间
     */
    public static Long getMonthStartTime(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取月结束时间
     *
     * @param date
     *            指定时间
     */
    public static Long getMonthEndTime(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));// 获取当前月最后一天
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTimeInMillis();
    }

    /**
     * 补全给定起止时间区间内的所有日期
     *
     * @param startTime
     *            开始时间
     * @param endTime
     *            结束时间
     * @param isIncludeStartTime
     *            是否包含开始时间
     * @return
     */
    public static List<String> getBetweenDates(String startTime, String endTime, boolean isIncludeStartTime) {
        List<String> result = new ArrayList<>();
        try {
            SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
            Date d1 = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD).parse(startTime);// 定义起始日期
            Date d2 = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD).parse(endTime);// 定义结束日期 可以去当前月也可以手动写日期。
            Calendar dd = Calendar.getInstance();// 定义日期实例
            dd.setTime(d1);// 设置日期起始时间
            if (isIncludeStartTime) {
                result.add(format.format(d1));
            }
            while (dd.getTime().before(d2)) {// 判断是否到结束日期
                dd.add(Calendar.DATE, 1);// 进行当前日期加1
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
                String str = sdf.format(dd.getTime());
                result.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 最近一周的所有日期
     *
     * @param date
     *            指定时间
     * @return
     */
    public static List<String> getNearlyWeekDates(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
        Calendar c = Calendar.getInstance();
        // 过去七天
        c.setTime(date);
        String today = format.format(date);
        c.add(Calendar.DATE, -7);
        Date d = c.getTime();
        String day = format.format(d);
        List<String> result = getBetweenDates(day, today, false);

        return result;
    }

    /**
     * 最近一周开始或者结束时间
     *
     * @param date
     *            指定时间
     * @param isHead
     * @param isTail
     * @return
     * @throws ParseException
     */
    public static Long getNearlyWeekHeadOrTailTime(Date date, boolean isHead, boolean isTail) {
        List<String> result = getNearlyWeekDates(date);
        String timeStr;
        Date resultDate;
        if (isHead) {
            timeStr = result.get(0);
            try {
                resultDate = str2Date(DATE_FORMAT_YYYYMMDD, timeStr);
                return getDayStartTime(resultDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (isTail) {
            timeStr = result.get(result.size() - 1);
            try {
                resultDate = str2Date(DATE_FORMAT_YYYYMMDD, timeStr);
                return getDayEndTime(resultDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    /**
     * 最近一个月的所有日期
     *
     * @param date
     *            指定时间
     * @return
     */
    public static List<String> getNearlyMonthDates(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
        Calendar c = Calendar.getInstance();
        // 过去一月
        c.setTime(date);
        String today = format.format(date);
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        List<String> result = getBetweenDates(mon, today, false);

        return result;
    }

    /**
     * 补全给定时间区内的所有月份
     *
     * @param startTime
     *            开始时间
     * @param endTime
     *            结束时间
     * @return
     */
    public static List<String> getMonthsBetweenDates(String startTime, String endTime) {
        List<String> result = new ArrayList<>();
        try {
            SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYYMM);
            // 定义起始日期
            Date d1 = new SimpleDateFormat(DATE_FORMAT_YYYYMM).parse(startTime);
            // 定义结束日期 可以去当前月也可以手动写日期。
            Date d2 = new SimpleDateFormat(DATE_FORMAT_YYYYMM).parse(endTime);
            // 定义日期实例
            Calendar dd = Calendar.getInstance();
            // 设置日期起始时间
            dd.setTime(d1);
            result.add(format.format(d1));
            // 判断是否到结束日期
            while (dd.getTime().before(d2)) {
                // 进行当前日期月份加1
                dd.add(Calendar.MONTH, 1);
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYYMM);
                String str = sdf.format(dd.getTime());
                result.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 最近一年的所有日期string类型
     *
     * @param date
     *            指定时间 date类型
     * @return
     */
    public static List<String> getNearlyYearDates(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
        Calendar c = Calendar.getInstance();
        // 过去一月
        c.setTime(date);
        String today = format.format(date);
        c.add(Calendar.YEAR, -1);
        Date yearAgoDate = c.getTime();
        String year = format.format(yearAgoDate);
        List<String> result = getBetweenDates(year, today, false);
        return result;
    }

    /**
     * 最近一年的所有年-月（yyyy-MM）
     * 
     * @param date
     *            指定日期 date类型
     * @return
     */
    public static List<String> getNearlyYearMonths(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String today = format.format(date);
        c.add(Calendar.YEAR, -1);
        Date yearAgoDate = c.getTime();
        String year = format.format(yearAgoDate);
        List<String> result = getMonthsBetweenDates(year, today);

        return result;
    }

    /**
     * 最近一个月开始或者结束时间
     *
     * @param date
     *            指定时间 date类型
     * @param isHead
     *            返回开始时间
     * @param isTail
     *            返回结束时间
     * @return
     */
    public static Long getNearlyMonthHeadOrTailTime(Date date, boolean isHead, boolean isTail) {
        List<String> result = getNearlyMonthDates(date);
        String timeStr;
        Date resultDate;
        if (isHead) {
            timeStr = result.get(0);
            try {
                resultDate = str2Date(DATE_FORMAT_YYYYMMDD, timeStr);
                return getDayStartTime(resultDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (isTail) {
            timeStr = result.get(result.size() - 1);
            try {
                resultDate = str2Date(DATE_FORMAT_YYYYMMDD, timeStr);
                return getDayEndTime(resultDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    /**
     * 最近一年开始或者结束时间
     *
     * @param date
     *            指定时间
     * @param isHead
     *            返回开始时间
     * @param isTail
     *            返回结束时间
     * @return
     */
    public static Long getNearlyYearHeadOrTailTime(Date date, boolean isHead, boolean isTail) {
        List<String> result = getNearlyYearDates(date);
        String timeStr;
        Date resultDate;
        if (isHead) {
            timeStr = result.get(0);
            try {
                resultDate = str2Date(DATE_FORMAT_YYYYMMDD, timeStr);
                return getDayStartTime(resultDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (isTail) {
            timeStr = result.get(result.size() - 1);
            try {
                resultDate = str2Date(DATE_FORMAT_YYYYMMDD, timeStr);
                return getDayEndTime(resultDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    /**
     * 当前两个时间相差多少天
     *
     * @param endTime
     *            结束时间时间戳
     * @param startTime
     *            开始时间时间戳
     */
    public static int calculateTimeDiff(Long endTime, Long startTime) throws Exception {
        if (endTime < startTime) {
            throw new Exception("endTime需要大于或等于startTime");
        }
        SimpleDateFormat simpleFormat = new SimpleDateFormat(DATE_FORMAT_YYYYMMDDHHMM);
        /*天数差*/
        Date fromDate1 = simpleFormat.parse(longToDate(startTime, DATE_FORMAT_YYYYMMDDHHMM));
        Date toDate1 = simpleFormat.parse(longToDate(endTime, DATE_FORMAT_YYYYMMDDHHMM));
        long from1 = fromDate1.getTime();
        long to1 = toDate1.getTime();
        int days = (int)((to1 - from1) / (1000 * 60 * 60 * 24));
        return days;
    }

    /**
     * 当前两个时间相差多少秒
     *
     * @param endTime
     *            结束时间时间戳
     * @param startTime
     *            开始时间时间戳
     * @return
     */
    public static int calculateSecondsDiff(Long endTime, Long startTime) {
        int diffSeconds = 0;
        try {
            diffSeconds = (int)((endTime - startTime) / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return diffSeconds;
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @param date
     *            指定时间 date类型
     * @return 当前日期是星期几 返回数字
     */
    public static int getWeekOfDate(Date date) {
        // String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return w;
    }

    /**
     * 获取当前日期的月份<br>
     *
     * @param date
     *            指定时间 date类型
     * @return 返回数字
     */
    public static int getMounthOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_MONTH);
        if (w < 0) {
            w = 0;
        }
        return w;
    }

    /**
     * 获取上一年年份
     *
     * @return
     */
    public static Integer getLastYear() {
        SimpleDateFormat formats = new SimpleDateFormat("yyyy");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -1);
        Date date = c.getTime();
        // Date类型转String类型
        String format = formats.format(date);
        // String类型转int类型
        int parseInt = Integer.parseInt(format);
        return parseInt;
    }

    /**
     * 获取当年的第一天
     *
     * @param
     * @return
     */
    public static Date getCurrYearFirst() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }

    /**
     * 获取当年的最后一天
     *
     * @param
     * @return
     */
    public static Date getCurrYearLast() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    /**
     * 获取当周第一天
     * 
     * @return
     */
    public static Date getCurrWeekStart() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();
        return date;
    }

    /**
     * 获取某年第一天日期
     *
     * @param year
     *            年份
     * @return Date
     */
    public static Date getYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        String nowTime = new SimpleDateFormat(DATE_FORMAT_YYYYMMDDHHMMSS).format(currYearFirst);
        return currYearFirst;
    }

    /**
     * 获得某天最大时间 2020-02-19 23:59:59
     *
     * @param date
     *            当前时间
     * @return 当前时间结束时间
     */
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime =
            LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());;
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获得某天最小时间 2020-02-17 00:00:00
     *
     * @param date
     *            当前时间
     * @return 当前时间开始时间
     */
    public static Date getStartOfDay(Date date) {
        LocalDateTime localDateTime =
            LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取某年最后一天日期
     *
     * @param year
     *            年份
     * @return Date
     */
    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTime();
    }

    public static Date getBeginTime(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate localDate = yearMonth.atDay(1);
        LocalDateTime startOfDay = localDate.atStartOfDay();
        ZonedDateTime zonedDateTime = startOfDay.atZone(ZoneId.of("Asia/Shanghai"));

        return Date.from(zonedDateTime.toInstant());
    }

    public static Date getEndTime(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate endOfMonth = yearMonth.atEndOfMonth();
        LocalDateTime localDateTime = endOfMonth.atTime(23, 59, 59, 999);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * 根据当前date获取周xx
     *
     * @param date
     * @return
     */
    public static String getWeek(Date date) {
        String[] weeks = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (week_index < 0) {
            week_index = 0;
        }
        return weeks[week_index];
    }

    /**
     * 生成随机时间
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
            Date start = format.parse(beginDate);// 构造开始日期
            Date end = format.parse(endDate);// 构造结束日期
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());
            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static long random(long begin, long end) {
        long rtn = begin + (long)(Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

    /**
     * 获取指定日期的前几个月或者后几个月
     *
     * @param date
     *            获取指定日期 date类型
     * @param n
     *            大于0：前n个月，小于0：后n个月
     * @return
     */
    public static Date getMonthBefore(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, n);
        return calendar.getTime();
    }

    public static void main(String[] args) throws Exception {

        System.out.println(getMounthOfDay(new Date()));
    }

}
