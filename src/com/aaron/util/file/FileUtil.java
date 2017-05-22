package com.aaron.util.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 文件的读写
 * 
 * @author Aaron
 * @date 2017年5月22日
 * @version 1.0
 * @package_name com.aaron.util.file
 */
public class FileUtil {

	/**
	 * 读取文件，并且按照指定的标志截取字符串 放入到list集合中
	 * 
	 * @param file
	 *            文件
	 * @return
	 */
	public static List getList(File file) {
		List result = new ArrayList();
		int len = 0;
		StringBuffer sb = new StringBuffer("");
		try {
			FileInputStream is = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(reader);
			String line = null;
			while ((line = br.readLine()) != null) {
				if (len != 0) {
					result.add(strList(line, "\\|"));
					sb.append("\r\n" + line);
				} else {
					result.add(strList(line, "\\|"));
					sb.append(line);
				}
				len++;
			}
			br.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List strList(String str, String pattern) {
		List<String> list = new ArrayList<String>();
		String[] strings = str.split(pattern);
		list = Arrays.asList(strings);
		return list;
	}
}
