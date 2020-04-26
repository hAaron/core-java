package com.aaron.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式 正则：pattern（模式）。split（分割_成数组）。compile（编译）、matcher（匹配器）
 * 
 * @author Aaron
 * @date 2017年6月20日
 * @version 1.0
 * @package_name com.aaron.regexp
 */
public class TestPattern {

	private static final String PATTERN_CHAR = "[0-9/.]";
	private static final String PATTERN_NUM = "[^0-9]";

	public static void main(String[] args) {

		// 根据【,】【空格】【|】分割字符串 +：1到无穷
		System.out.println("****根据【,】【空格】【|】分割字符串   +：1到无穷***");
		String string1 = "Java Hello World Java,Hello,,World|Sun";
		String regex1 = "[, |]+"; // 根据【,】【空格】【|】分割字符串 +：1到无穷
		Pattern pattern1 = Pattern.compile(regex1);
		String[] strings = pattern1.split(string1);
		for (int i = 0; i < strings.length; i++) {
			System.out.print(" " + strings[i]);
		}
		System.out.println();
		// 验证邮箱
		System.out.println("****验证邮箱****");
		String string2 = "ceponline@yahoo.com.cn";
		String regex2 = ".+@.+\\..+?";
		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher2 = pattern2.matcher(string2);
		System.out.println("ceponline@yahoo.com.cn符合邮箱？" + matcher2.matches());

		// 去除html标记
		System.out.println("*****去除html标记****");
		String string3 = "<a href=\"index.html\">主页</a>";
		String regex3 = "<.+?>";
		Pattern pattern3 = Pattern.compile(regex3);
		Matcher matcher3 = pattern3.matcher(string3);
		System.out.println(matcher3.replaceAll(""));
		// 截取url
		System.out.println("*****截取url****");
		String string4 = "dsdsds<http://www.baidu.com/>fdf";
		String regex4 = "<http://.+?>";
		Pattern pattern4 = Pattern.compile(regex4);
		Matcher matcher4 = pattern4.matcher(string4);
		if (matcher4.find()) {
			System.out.println(matcher4.group());
		}
		// 筛选数字
		System.out.println("****筛选数字***");
		String string5 = "as233dsdf2ssgetNum34dfs.sdfa23266";
		Pattern pattern5 = Pattern.compile(PATTERN_NUM);
		Matcher match5 = pattern5.matcher(string5);
		String number = match5.replaceAll("");
		System.out.println(number);
		// 筛选字符
		System.out.println("*****筛选字符***");
		String string6 = "as233dsdf2ssgetNum34dfs.sdfa23266";
		Pattern pattern6 = Pattern.compile(PATTERN_CHAR);
		Matcher match6 = pattern6.matcher(string6);
		String result = match6.replaceAll("");
		System.out.println(result);

	}

}
