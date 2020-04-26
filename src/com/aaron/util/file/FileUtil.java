package com.aaron.util.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
	 * 并且按照指定的标志截取字符串 放入到list集合中
	 * 
	 * @param file
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

	/**
	 * 列出某文件夹及其子文件夹下面的文件，并可根据扩展名过滤
	 * 
	 * @param path
	 */
	public static void list(File path) {
		if (!path.exists()) {
			System.out.println("文件名称不存在!");
		} else {
			if (path.isFile()) {
				if (path.getName().toLowerCase().endsWith(".pdf") || path.getName().toLowerCase().endsWith(".doc")
						|| path.getName().toLowerCase().endsWith(".chm")
						|| path.getName().toLowerCase().endsWith(".html")
						|| path.getName().toLowerCase().endsWith(".htm")) {// 文件格式
					System.out.println(path);
					System.out.println(path.getName());
				}
			} else {
				File[] files = path.listFiles();
				for (int i = 0; i < files.length; i++) {
					list(files[i]);
				}
			}
		}
	}

	/**
	 * 拷贝一个目录或者文件到指定路径下，即把源文件拷贝到目标文件路径下
	 * 
	 * @param source
	 * @param target
	 */
	public static void copy(File source, File target) {
		File tarpath = new File(target, source.getName());
		if (source.isDirectory()) {
			tarpath.mkdir();
			File[] dir = source.listFiles();
			for (int i = 0; i < dir.length; i++) {
				copy(dir[i], tarpath);
			}
		} else {
			try {
				InputStream is = new FileInputStream(source); // 用于读取文件的原始字节流
				OutputStream os = new FileOutputStream(tarpath); // 用于写入文件的原始字节的流
				byte[] buf = new byte[1024];// 存储读取数据的缓冲区大小
				int len = 0;
				while ((len = is.read(buf)) != -1) {
					os.write(buf, 0, len);
				}
				is.close();
				os.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		File source = new File("D:\\迅雷下载\\Java常用工具类\\file\\FileUtil.java");
		File target = new File("D:\\迅雷下载\\Java常用工具类\\file\\11");
		copy(source, target);
	}

}
