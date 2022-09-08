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
 * ʱ�����ڹ�����
 * 
 * @author huangbo
 * @date 2022/9/8
 */
public class DateTimeUtil {
    /**
     * ȱʡ��������ʾ��ʽ�� yyyy-MM
     */
    public static final String DATE_FORMAT_YYYYMM = "yyyy-MM";

    /**
     * ȱʡ��������ʾ��ʽ�� yyyy-MM-dd
     */
    public static final String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";

    /**
     * ȱʡ������ʱ����ʾ��ʽ��yyyy-MM-dd HH:mm:ss
     */
    public static final String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

    /**
     * ȱʡ������ʱ����ʾ��ʽ��yyyy-MM-dd HH:mm
     */
    public static final String DATE_FORMAT_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";

    /**
     * ȱʡ������ʱ����ʾ��ʽ��yyyy-MM-dd HH
     */
    public static final String DATE_FORMAT_YYYYMMDDHH = "yyyy-MM-dd HH";

    /**
     * ȱʡ��ʱ����ʾ��ʽ��HH:mm:ss
     */
    public static final String DATE_FORMAT_HHMMSS = "HH:mm:ss";

    /**
     * ȱʡ��ʱ����ʾ��ʽ��HH:mm
     */
    public static final String DATE_FORMAT_HHMM = "HH:mm";

    /**
     * 1s�еĺ�����
     */
    private static final int MILLIS = 1000;

    /**
     * һ�굱�е��·���
     */
    private static final int MONTH_PER_YEAR = 12;
    /**
     * Ĭ�����ڸ�ʽ
     */
    public static String DEFAULT_FORMAT = "yyyy-MM-dd";

    /**
     * ˽�й��췽������ֹ�Ը������ʵ����
     */
    private DateTimeUtil() {}

    /**
     * ��ȡϵͳ��ǰ����ʱ��
     *
     * @return ��ǰ����ʱ��
     */
    public static Date getNow() {
        return Calendar.getInstance().getTime();
    }

    /**
     * ��ǰ���� ��ʽ��yyyy-MM-dd
     *
     * @return ��ǰ����
     */
    public static String getDate() {
        return getDateTime(DATE_FORMAT_YYYYMMDD);
    }

    /**
     * ��ǰ���� ��ʽ��yyyy-MM-dd HH:mm:ss
     *
     * @return ��ǰ���ڼ�ʱ��
     */
    public static String getDateTime() {
        return getDateTime(DATE_FORMAT_YYYYMMDDHHMMSS);
    }

    /**
     * ��ȡϵͳ��ǰ���ڼ�ʱ�䣬����ָ���ķ�ʽ��ʽ��
     *
     * @param pattern
     *            ��ʾ��ʽ
     * @return ��ǰ���ڼ�ʱ��
     */
    public static String getDateTime(String pattern) {
        Date datetime = Calendar.getInstance().getTime();
        return getDateTime(datetime, pattern);
    }

    /**
     * ��ȡ��ָ����ʽ��ʽ��������
     *
     * @param date
     *            ��Ҫ���и�ʽ��������
     * @param pattern
     *            ��ʾ��ʽ
     * @return ����ʱ���ַ���
     */
    public static String getDateTime(Date date, String pattern) {
        if (StringUtil.isBlank(pattern)) {
            pattern = DATE_FORMAT_YYYYMMDDHHMMSS;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    /**
     * ��ȡ��ǰ���
     *
     * @return ��ǰ���
     */
    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);

    }

    /**
     * ��ȡ��ǰ�·�
     *
     * @return ��ǰ�·�
     */
    public static int getCurrentMonth() {
        // ��get��ȡ���·�����ʵ�ʵ�С1����Ҫ����
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    /**
     * ��ȡ��ǰ��
     *
     * @return ��ǰ��
     */
    public static int getCurrentDay() {
        return Calendar.getInstance().get(Calendar.DATE);
    }

    /**
     * �ı䵱ǰʱ�������
     *
     * @param date
     *            ��׼ʱ��
     * @param seconds
     *            Ҫ���ӻ��߼��ٵ������������ø�����ʾ��
     * @param pattern
     *            ���ڸ�ʽ
     * @return �ı���ʱ��
     */
    public static String addSeconds(Date date, int seconds, String pattern) {
        return getDateTime(addSeconds(date, seconds), pattern);
    }

    /**
     * �ı䵱ǰʱ�������
     *
     * @param date
     *            ��׼ʱ��
     * @param seconds
     *            Ҫ���ӻ��߼��ٵ������������ø�����ʾ��
     * @return �ı���ʱ��
     */
    public static Date addSeconds(Date date, int seconds) {
        return add(date, seconds, Calendar.SECOND);
    }

    /**
     * �ı䵱ǰʱ��ķ�����
     *
     * @param date
     *            ��׼ʱ��
     * @param minutes
     *            Ҫ���ӻ��߼��ٵķ������������ø�����ʾ��
     * @param pattern
     *            ���ڸ�ʽ
     * @return �ı���ʱ��
     */
    public static String addMinutes(Date date, int minutes, String pattern) {
        return getDateTime(addMinutes(date, minutes), pattern);
    }

    /**
     * �ı䵱ǰʱ��ķ�����
     *
     * @param date
     *            ��׼ʱ��
     * @param minutes
     *            Ҫ���ӻ��߼��ٵķ������������ø�����ʾ��
     * @return �ı���ʱ��
     */
    public static Date addMinutes(Date date, int minutes) {
        return add(date, minutes, Calendar.MINUTE);
    }

    /**
     * �ı䵱ǰʱ���Сʱ
     *
     * @param date
     *            ��׼ʱ��
     * @param hours
     *            Ҫ���ӻ��߼��ٵ�Сʱ�������ø�����ʾ��
     * @param pattern
     *            ���ڸ�ʽ
     * @return �ı���ʱ��
     */
    public static String addHours(Date date, int hours, String pattern) {
        return getDateTime(addHours(date, hours), pattern);
    }

    /**
     * �ı䵱ǰʱ���Сʱ
     *
     * @param date
     *            ��׼ʱ��
     * @param hours
     *            Ҫ���ӻ��߼��ٵ�Сʱ�������ø�����ʾ��
     * @return �ı���ʱ��
     */
    public static Date addHours(Date date, int hours) {
        return add(date, hours, Calendar.HOUR);
    }

    /**
     * ȡ�õ�ǰ�����Ժ�����������ڡ����Ҫ��ȡ��ǰ�����ڣ������ø����� ����Ҫ��ȡ������ͬһ������ڣ�������Ϊ-7
     *
     * @param date
     *            ��׼ʱ��
     * @param days
     *            ���ӵ�������
     * @param pattern
     *            ���ڸ�ʽ
     * @return �ı��Ժ������
     */
    public static String addDays(Date date, int days, String pattern) {
        return getDateTime(addDays(date, days), pattern);
    }

    /**
     * ȡ��ָ�������Ժ�����������ڡ����Ҫ��ȡ��ǰ�����ڣ������ø�����
     *
     * @param date
     *            ��׼ʱ��
     * @param days
     *            ���ӵ�������
     * @return �ı��Ժ������
     */
    public static Date addDays(Date date, int days) {
        return add(date, days, Calendar.DATE);
    }

    /**
     * ȡ�õ�ǰ�����Ժ�ĳ�µ����ڡ����Ҫ��ȡ��ǰ�·ݵ����ڣ������ø�����
     *
     * @param date
     *            ��׼ʱ��
     * @param months
     *            ���ӵ��·���
     * @param pattern
     *            ���ڸ�ʽ
     * @return �ı��Ժ������
     */
    public static String addMonths(Date date, int months, String pattern) {
        return getDateTime(addMonths(date, months), pattern);
    }

    /**
     * ȡ��ָ�������Ժ�ĳ�µ����ڡ����Ҫ��ȡ��ǰ�·ݵ����ڣ������ø����� ע�⣬���ܲ���ͬһ���ӣ�����2003-1-31����һ������2003-2-28
     *
     * @param date
     *            ��׼ʱ��
     * @param months
     *            ���ӵ��·���
     * @return �ı��Ժ������
     */
    public static Date addMonths(Date date, int months) {
        return add(date, months, Calendar.MONTH);
    }

    /**
     * ȡ�õ�ǰ�����Ժ�ĳ�������
     *
     * @param date
     *            ��׼ʱ��
     * @param years
     *            ���ӵ������
     * @param pattern
     *            ���ڸ�ʽ
     * @return �ı��Ժ������
     */
    public static String addYears(Date date, int years, String pattern) {
        return getDateTime(addYears(date, years), pattern);
    }

    /**
     * ȡ�õ�ǰ�����Ժ�ĳ�������
     *
     * @param date
     *            ��׼ʱ��
     * @param years
     *            ���ӵ������
     * @return �ı��Ժ������
     */
    public static Date addYears(Date date, int years) {
        return add(date, years, Calendar.YEAR);
    }

    /**
     * �ڲ�������Ϊָ������������Ӧ������������
     *
     * @param date
     *            ��׼ʱ��
     * @param amount
     *            �ı������
     * @param field
     *            �ı��ʱ��ĵ�λ���ꡢ�¡��ա�ʱ���֡����
     * @return �ı��Ժ������
     */
    private static Date add(Date date, int amount, int field) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * ͨ��date����ȡ�ø�ʽΪСʱ:���ӵ��ַ���
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
     * ��������������������� �õ�һ�����ڼ�ȥ�ڶ��������ǰһ������С�ں�һ�����ڣ��򷵻ظ���
     *
     * @param one
     *            ��һ������������Ϊ��׼
     * @param two
     *            �ڶ�������������Ϊ�Ƚ�
     * @return ���������������
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
     * ����������������·��� ���ǰһ������С�ں�һ�����ڣ��򷵻ظ���
     *
     * @param one
     *            ��һ������������Ϊ��׼
     * @param two
     *            �ڶ�������������Ϊ�Ƚ�
     * @return ������������·���
     */
    public static int diffMonths(Date one, Date two) {

        Calendar calendar = Calendar.getInstance();

        // ��ȡ��һ�����ڵ���ֺ��·���
        calendar.setTime(one);
        int yearOne = calendar.get(Calendar.YEAR);
        int monthOne = calendar.get(Calendar.MONDAY);
        // ��ȡ�ڶ������ڵ���ݺ��·�
        calendar.setTime(two);
        int yearTwo = calendar.get(Calendar.YEAR);
        int monthTwo = calendar.get(Calendar.MONDAY);

        return (yearOne - yearTwo) * MONTH_PER_YEAR + (monthOne - monthTwo);
    }

    /**
     * �������������������� ���ǰһ������С�ں�һ�����ڣ��򷵻ظ���
     *
     * @param one
     *            ��һ������������Ϊ��׼
     * @param two
     *            �ڶ�������������Ϊ�Ƚ�
     * @return ������������·���
     */
    public static int diffYears(Date one, Date two) {

        Calendar calendar = Calendar.getInstance();

        // ��ȡ��һ�����ڵ����
        calendar.setTime(one);
        int yearOne = calendar.get(Calendar.YEAR);
        // ��ȡ�ڶ������ڵ����
        calendar.setTime(two);
        int yearTwo = calendar.get(Calendar.YEAR);

        return yearOne - yearTwo;
    }

    /**
     * ��ȡĳһ�����ڵ����
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
     * ��һ���ַ����ø����ĸ�ʽת��Ϊ�������͡� ע�⣺�������null�����ʾ����ʧ��
     *
     * @param dateStr
     *            ��Ҫ�����������ַ���
     * @param pattern
     *            �����ַ����ĸ�ʽ��Ĭ��Ϊ"yyyy-MM-dd"����ʽ
     * @return �����������
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
     * ���ر��µ����һ��
     *
     * @return �������һ�������
     */
    public static Date getMonthLastDay() {
        return getMonthLastDay(getNow());
    }

    /**
     * ���ظ��������е��·��е����һ��
     *
     * @param date
     *            ��׼����
     * @return �������һ�������
     */
    public static Date getMonthLastDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // ����������Ϊ��һ�µ�һ��
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, 1);

        // ��ȥ1�죬��ȡ�ļ����µ����һ��
        calendar.add(Calendar.DATE, -1);

        return calendar.getTime();
    }

    /**
     * ����������������֮�������һ������-�ڶ�������
     *
     * @param date1
     * @param date2
     * @param onlyTime
     *            �Ƿ�ֻ����2�����ڵ�ʱ����죬�������ڣ�true����ֻ����ʱ���
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
     * ����������������֮�������һ������-�ڶ�������
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long diffSeconds(Date date1, Date date2) {
        return diffSeconds(date1, date2, false);
    }

    /**
     * ��������ȷ�����ڼ�:1-�����գ�2-����һ.....
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
     * ��֤�Ƿ�����Ч����(����ǰ���ڱȽ�)
     *
     * @param validDate
     *            Ҫ�Ƚϵ�ʱ��
     * @param format
     *            �����ַ����ĸ�ʽ
     * @return
     */
    public static boolean isValidDate(String validDate, String format) {
        return isValidDate(validDate, getDateTime(), format);
    }

    /**
     * ��֤�Ƿ�����Ч����(����ǰ���ڱȽ�)
     *
     * @param validDate
     *            Ҫ�Ƚϵ�ʱ��
     * @param date
     *            ��׼ʱ��
     * @param format
     *            �����ַ����ĸ�ʽ
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
     * ������ת��ָ�����ڸ�ʽ
     * 
     * @param millSec
     *            ʱ�������
     * @return ָ����ʽ���ڣ�Ĭ�ϸ�ʽ��yyyy-MM-dd HH:mm:ss
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
     * string��������ת��date��������
     * 
     * @param pattern
     *            ���ڸ�ʽ
     * @param strTime
     *            string�������ڣ��磺2021-08-18 00:00:00
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
     * ��ȡָ�����������µ�һ��
     *
     * @param time
     *            ָ������
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
     * ��ȡָ���������������һ��
     *
     * @param time
     *            ָ������
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
     * date��������ת��string��������
     *
     * @param pattern
     *            ���ڸ�ʽ
     * @param date
     *            date��������
     * @return string�������ڣ��磺2021-08-18 00:00:00
     * @throws ParseException
     */
    public static String date2Str(String pattern, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * ��ȡstring����ʱ���ַ��������
     *
     * @param strDate
     *            string����ʱ��
     * @return
     */
    public static int getDateStringYear(String strDate) {
        int index = strDate.indexOf('-');
        int year = Integer.parseInt(strDate.substring(0, index));
        return year;
    }

    /**
     * ��string����ʱ���ַ���ת��Ϊʱ���
     *
     * @param pattern
     *            string����ʱ���ַ������ڸ�ʽ
     * @param strDate
     *            string����ʱ���ַ���
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
     * ��ʱ���ת��Ϊstring����ʱ���ַ���
     *
     * @param pattern
     *            ���ڸ�ʽ
     * @param stamp
     * @return string����ʱ���ַ���
     * @throws Exception
     */
    public static String stampToTime(String pattern, long stamp) throws Exception {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = new Date(stamp);// ��ʱ�����Ϊyyyy-MM-dd HH:mm:ssʱ����ʽ
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * ��ʱͳ�Ƹ�ʽ��: ʱ �� ��
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
     * ��ȡʱ��μ��string����ʱ��
     *
     * @param startDate
     *            ��ʼʱ��
     * @param endDate
     *            ����ʱ��
     * @param dateNum
     *            ȡ���ٸ�ʱ���
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
     * �ж������Ƿ������ʽҪ��
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
     * ��ȡdate����ʱ��Ŀ�ʼʱ�� 00:00:00:00
     *
     * @param date
     *            ָ��ʱ��
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
     * ��ȡdate����ʱ��Ŀ�ʼʱ�� 23:59:59:999
     *
     * @param date
     *            ָ��ʱ��
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
     * ��ȡ�¿�ʼʱ��
     *
     * @param date
     *            ָ��ʱ��
     */
    public static Long getMonthStartTime(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);// ����Ϊ1��,��ǰ���ڼ�Ϊ���µ�һ��
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * ��ȡ�½���ʱ��
     *
     * @param date
     *            ָ��ʱ��
     */
    public static Long getMonthEndTime(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));// ��ȡ��ǰ�����һ��
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTimeInMillis();
    }

    /**
     * ��ȫ������ֹʱ�������ڵ���������
     *
     * @param startTime
     *            ��ʼʱ��
     * @param endTime
     *            ����ʱ��
     * @param isIncludeStartTime
     *            �Ƿ������ʼʱ��
     * @return
     */
    public static List<String> getBetweenDates(String startTime, String endTime, boolean isIncludeStartTime) {
        List<String> result = new ArrayList<>();
        try {
            SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
            Date d1 = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD).parse(startTime);// ������ʼ����
            Date d2 = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD).parse(endTime);// ����������� ����ȥ��ǰ��Ҳ�����ֶ�д���ڡ�
            Calendar dd = Calendar.getInstance();// ��������ʵ��
            dd.setTime(d1);// ����������ʼʱ��
            if (isIncludeStartTime) {
                result.add(format.format(d1));
            }
            while (dd.getTime().before(d2)) {// �ж��Ƿ񵽽�������
                dd.add(Calendar.DATE, 1);// ���е�ǰ���ڼ�1
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
     * ���һ�ܵ���������
     *
     * @param date
     *            ָ��ʱ��
     * @return
     */
    public static List<String> getNearlyWeekDates(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
        Calendar c = Calendar.getInstance();
        // ��ȥ����
        c.setTime(date);
        String today = format.format(date);
        c.add(Calendar.DATE, -7);
        Date d = c.getTime();
        String day = format.format(d);
        List<String> result = getBetweenDates(day, today, false);

        return result;
    }

    /**
     * ���һ�ܿ�ʼ���߽���ʱ��
     *
     * @param date
     *            ָ��ʱ��
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
     * ���һ���µ���������
     *
     * @param date
     *            ָ��ʱ��
     * @return
     */
    public static List<String> getNearlyMonthDates(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
        Calendar c = Calendar.getInstance();
        // ��ȥһ��
        c.setTime(date);
        String today = format.format(date);
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        List<String> result = getBetweenDates(mon, today, false);

        return result;
    }

    /**
     * ��ȫ����ʱ�����ڵ������·�
     *
     * @param startTime
     *            ��ʼʱ��
     * @param endTime
     *            ����ʱ��
     * @return
     */
    public static List<String> getMonthsBetweenDates(String startTime, String endTime) {
        List<String> result = new ArrayList<>();
        try {
            SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYYMM);
            // ������ʼ����
            Date d1 = new SimpleDateFormat(DATE_FORMAT_YYYYMM).parse(startTime);
            // ����������� ����ȥ��ǰ��Ҳ�����ֶ�д���ڡ�
            Date d2 = new SimpleDateFormat(DATE_FORMAT_YYYYMM).parse(endTime);
            // ��������ʵ��
            Calendar dd = Calendar.getInstance();
            // ����������ʼʱ��
            dd.setTime(d1);
            result.add(format.format(d1));
            // �ж��Ƿ񵽽�������
            while (dd.getTime().before(d2)) {
                // ���е�ǰ�����·ݼ�1
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
     * ���һ�����������string����
     *
     * @param date
     *            ָ��ʱ�� date����
     * @return
     */
    public static List<String> getNearlyYearDates(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
        Calendar c = Calendar.getInstance();
        // ��ȥһ��
        c.setTime(date);
        String today = format.format(date);
        c.add(Calendar.YEAR, -1);
        Date yearAgoDate = c.getTime();
        String year = format.format(yearAgoDate);
        List<String> result = getBetweenDates(year, today, false);
        return result;
    }

    /**
     * ���һ���������-�£�yyyy-MM��
     * 
     * @param date
     *            ָ������ date����
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
     * ���һ���¿�ʼ���߽���ʱ��
     *
     * @param date
     *            ָ��ʱ�� date����
     * @param isHead
     *            ���ؿ�ʼʱ��
     * @param isTail
     *            ���ؽ���ʱ��
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
     * ���һ�꿪ʼ���߽���ʱ��
     *
     * @param date
     *            ָ��ʱ��
     * @param isHead
     *            ���ؿ�ʼʱ��
     * @param isTail
     *            ���ؽ���ʱ��
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
     * ��ǰ����ʱ����������
     *
     * @param endTime
     *            ����ʱ��ʱ���
     * @param startTime
     *            ��ʼʱ��ʱ���
     */
    public static int calculateTimeDiff(Long endTime, Long startTime) throws Exception {
        if (endTime < startTime) {
            throw new Exception("endTime��Ҫ���ڻ����startTime");
        }
        SimpleDateFormat simpleFormat = new SimpleDateFormat(DATE_FORMAT_YYYYMMDDHHMM);
        /*������*/
        Date fromDate1 = simpleFormat.parse(longToDate(startTime, DATE_FORMAT_YYYYMMDDHHMM));
        Date toDate1 = simpleFormat.parse(longToDate(endTime, DATE_FORMAT_YYYYMMDDHHMM));
        long from1 = fromDate1.getTime();
        long to1 = toDate1.getTime();
        int days = (int)((to1 - from1) / (1000 * 60 * 60 * 24));
        return days;
    }

    /**
     * ��ǰ����ʱ����������
     *
     * @param endTime
     *            ����ʱ��ʱ���
     * @param startTime
     *            ��ʼʱ��ʱ���
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
     * ��ȡ��ǰ���������ڼ�<br>
     *
     * @param date
     *            ָ��ʱ�� date����
     * @return ��ǰ���������ڼ� ��������
     */
    public static int getWeekOfDate(Date date) {
        // String[] weekDays = {"������", "����һ", "���ڶ�", "������", "������", "������", "������"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return w;
    }

    /**
     * ��ȡ��ǰ���ڵ��·�<br>
     *
     * @param date
     *            ָ��ʱ�� date����
     * @return ��������
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
     * ��ȡ��һ�����
     *
     * @return
     */
    public static Integer getLastYear() {
        SimpleDateFormat formats = new SimpleDateFormat("yyyy");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -1);
        Date date = c.getTime();
        // Date����תString����
        String format = formats.format(date);
        // String����תint����
        int parseInt = Integer.parseInt(format);
        return parseInt;
    }

    /**
     * ��ȡ����ĵ�һ��
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
     * ��ȡ��������һ��
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
     * ��ȡ���ܵ�һ��
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
     * ��ȡĳ���һ������
     *
     * @param year
     *            ���
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
     * ���ĳ�����ʱ�� 2020-02-19 23:59:59
     *
     * @param date
     *            ��ǰʱ��
     * @return ��ǰʱ�����ʱ��
     */
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime =
            LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());;
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * ���ĳ����Сʱ�� 2020-02-17 00:00:00
     *
     * @param date
     *            ��ǰʱ��
     * @return ��ǰʱ�俪ʼʱ��
     */
    public static Date getStartOfDay(Date date) {
        LocalDateTime localDateTime =
            LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * ��ȡĳ�����һ������
     *
     * @param year
     *            ���
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
     * ���ݵ�ǰdate��ȡ��xx
     *
     * @param date
     * @return
     */
    public static String getWeek(Date date) {
        String[] weeks = {"����", "��һ", "�ܶ�", "����", "����", "����", "����"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (week_index < 0) {
            week_index = 0;
        }
        return weeks[week_index];
    }

    /**
     * �������ʱ��
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYYMMDD);
            Date start = format.parse(beginDate);// ���쿪ʼ����
            Date end = format.parse(endDate);// �����������
            // getTime()��ʾ������ 1970 �� 1 �� 1 �� 00:00:00 GMT ������ Date �����ʾ�ĺ�������
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
        // ������ص��ǿ�ʼʱ��ͽ���ʱ�䣬��ݹ���ñ������������ֵ
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

    /**
     * ��ȡָ�����ڵ�ǰ�����»��ߺ󼸸���
     *
     * @param date
     *            ��ȡָ������ date����
     * @param n
     *            ����0��ǰn���£�С��0����n����
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
