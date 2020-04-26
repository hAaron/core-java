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
	 * 计算2个日期之间间隔天数方法
	 * 
	 * @param d1
	 *            The first Calendar. 格式yyyy-MM-dd
	 * @param d2
	 *            The second Calendar.
	 *
	 * @return 天数
	 */
	public static long getDaysBetween(String d1, String d2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = sdf.parse(d1);
			Date dt2 = sdf.parse(d2);
			return (dt1.getTime() - dt2.getTime()) / (3600 * 24 * 1000);
		} catch (Exception e) {
			return 0;
		}

	}

	/**
	 * 计算两个日期之间的时间间隔(d1-d2)，可选择是否计算工作日
	 * 
	 * @param d1
	 * @param d2
	 * @param onlyWorkDay
	 *            是否只计算工作日
	 * @return 计算两个日期之间的时间间隔(d1-d2)，可选择是否计算工作日
	 */
	public static long getDaysBetween(String d1, String d2, boolean onlyWorkDay) {
		if (!onlyWorkDay) {
			return getDaysBetween(d1, d2);
		} else {
			long days = 0;
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date dt1 = sdf.parse(d1);
				Date dt2 = sdf.parse(d2);
				days = (dt1.getTime() - dt2.getTime()) / (3600 * 24 * 1000);
				for (calendar.setTime(dt1); !calendar.getTime().before(dt2); calendar.add(Calendar.DAY_OF_YEAR, -1)) {
					int week = calendar.get(Calendar.DAY_OF_WEEK);
					if (week == Calendar.SUNDAY || week == Calendar.SATURDAY) {
						days--;
					}
				}
				if (days < 0) {
					days = 0;
				}
			} catch (Exception e) {
			}
			return days;
		}
	}

	/**
	 * 判断日期是否为工作日(周六和周日为非工作日)
	 * 
	 * @param date
	 * @return 判断日期是否为工作日(周六和周日为非工作日)
	 */
	public static boolean isWorkDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		if (week == Calendar.SUNDAY || week == Calendar.SATURDAY) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 计算两个时间之间的间隔 单位：分钟(minutes) 格式 yyyy-MM-dd/HH:mm:ss
	 */
	public static long getMinutesBetween(String s1, String s2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
		try {
			Date dt1 = sdf.parse(s1);
			Date dt2 = sdf.parse(s2);
			return (dt1.getTime() - dt2.getTime()) / (60 * 1000);
		} catch (Exception e) {
			return 0;
		}

	}

	/**
	 * 功能描述：返回年份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回年份
	 */
	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 功能描述：返回月份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回月份
	 */
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 功能描述：返回日份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回日份
	 */
	public static int getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 功能描述：返回小时
	 * 
	 * @param date
	 *            日期
	 * @return 返回小时
	 */
	public static int getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 功能描述：返回分钟
	 * 
	 * @param date
	 *            日期
	 * @return 返回分钟
	 */
	public static int getMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * 返回秒钟
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回秒钟
	 */
	public static int getSecond(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.SECOND);
	}

	/**
	 * 功能描述：返回毫秒
	 * 
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public static long getMillis(Date date) {
		Calendar calendar = calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}

	
	/**
	 * 测试案例
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// System.out.println(dataConvertString(new Date(), PATTERN_STRING));
		// System.out.println(dateConvertData(new Date()));
		// System.out.println(stringConvertDate("2015-03-04", PATTERN_STRING2));
		// System.out.println("getWeekOfDate--" + getWeekOfDate(new Date()));
		// System.out
		// .println(new
		// SimpleDateFormat("YYYY-MM-dd").format(Calendar.getInstance().getTime()).replaceAll("-",
		// "")
		// + "000000");
		// System.out.println(new SimpleDateFormat("YYYY-MM-dd").format(new
		// Date()).replaceAll("-", "") + "000000");
		// System.out.println(getWeekOfDate(new Date()));

		System.out.println(isWorkDay(new Date()));
		System.out.println(getDaysBetween("2018-03-31", "2018-03-27", true));
	}
}
