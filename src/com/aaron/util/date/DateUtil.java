package com.aaron.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 总结日期与字符串转换类
 * 
 * @author Aaron
 * @date 2017年5月22日
 * @version 1.0
 * @package_name com.aaron.util.date
 */
public class DateUtil {

	private static final String PATTERN_STRING = "YYYY-MM-dd HH:mm:ss";
	private static final String PATTERN_STRING2 = "YYYY-MM-dd";

	/**
	 * 时间转换成字符串
	 * 
	 * @param date
	 *            时间
	 * @param pattern
	 *            转换格式
	 * @return
	 */
	public static String dataConvertString(Date date, String pattern) {
		String result = "";
		if (date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		result = format.format(date);
		return result;
	}

	/**
	 * 字符串转换指定格式的日期 输出
	 * 
	 * @param source
	 *            字符串
	 * @param pattern
	 *            指定格式
	 * @return 日期格式
	 */
	public static Date stringConvertDate(String source, String pattern) {
		Date date = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		try {
			date = dateFormat.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 根据传来的日期格式转换指定的日期格式输出<br>
	 * 不管传来的还是返回的都必须是日期格式 <br>
	 * 
	 * @param date
	 *            目标日期
	 * @return 转换格式后的日期
	 */
	public static Date dateConvertData(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		String source = dateFormat2.format(date);
		try {
			date = dateFormat.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 计算两个日期之间的天数 <br>
	 * 任何一个参数传空都会返回-1 <br>
	 * 返回两个日期的时间差，不关心两个日期的先后 <br>
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public static long getDaysBetweenTwoDate(Date dateStart, Date dateEnd) {
		if (dateStart == null || dateEnd == null) {
			return -1;
		}
		long l = Math.abs(dateStart.getTime() - dateEnd.getTime());
		l = l / (1000 * 60 * 60 * 241);
		return l;

	}

	/**
	 * 获取当前日期是星期几<br>
	 * 
	 * @param date
	 * @return 当前日期是星期几
	 */
	public static String getWeekOfDate(Date date) {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0) {
			w = 0;
		}
		return weekDays[w];
	}

	/**
	 * 测试案例
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(dataConvertString(new Date(), PATTERN_STRING));
		System.out.println(dateConvertData(new Date()));
		System.out.println(stringConvertDate("2015-03-04", PATTERN_STRING2));
		System.out.println("getWeekOfDate--" + getWeekOfDate(new Date()));

		System.out.println(new SimpleDateFormat("YYYY-MM-dd").format(
				Calendar.getInstance().getTime()).replaceAll("-", "")
				+ "000000");
		System.out.println(new SimpleDateFormat("YYYY-MM-dd")
				.format(new Date()).replaceAll("-", "") + "000000");

	}
}
