package com.aaron.files;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 操作文件工具
 * 
 * @author Aaron
 * @date 2017年6月3日
 * @version 1.0
 * @package_name com.aaron.files
 */
public class FileOperator {

	private static final String FILE_PATH = "E:" + File.separator + "temp";

	/**
	 * 创建一个新的文件 在用 \\ 时使用File.separator 表示获取当前系统下的\\ Linux 和 windows 不同
	 * 
	 * @throws IOException
	 */
	public static void createFile() throws IOException {
		String fileName = FILE_PATH + File.separator + "myfile.txt";
		File file = new File(fileName);
		// System.out.println(File.separator);
		// System.out.println(File.pathSeparator);
		file.createNewFile();
	}

	/**
	 * 删除一个文件
	 * 
	 * @throws IOException
	 */
	public static void deleteFile() throws IOException {
		String fileName = FILE_PATH + File.separator + "myfile.txt";
		File file = new File(fileName);
		file.delete();
	}

	/**
	 * 创建一个文件夹
	 */
	public static void createDir() {
		String pathname = FILE_PATH + File.separator + "myFile";
		File file = new File(pathname);
		file.mkdir();
	}

	/**
	 * 列出指定目录的全部文件（包括隐藏文件）,使用list列出指定目录的全部文件 listFiles输出的是完整路径
	 */
	public static void listFiles() {
		String fileName = FILE_PATH;
		File file = new File(fileName);
		String[] fileList = file.list();
		for (int i = 0; i < fileList.length; i++) {
			System.out.println(fileList[i]);
		}
		// listFiles输出的是完整路径
		File[] listFiles = file.listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			System.out.println(listFiles[i]);
		}
	}

	/**
	 * 判断一个指定的路径是否为目录
	 */
	public static void isDirectory() {
		String fileName = FILE_PATH + File.separator + "myFile";
		File file = new File(fileName);
		if (file.isDirectory()) {
			System.out.println("该文件为目录");
		} else {
			System.out.println("该文件不是目录");
		}
	}

	/**
	 * 搜索指定目录的全部内容
	 */
	public static void listFilesByCondition() {
		// 列出指定目录的全部内容
		String fileName = FILE_PATH ;//+ File.separator + "jar";
		File file = new File(fileName);
		print(file);
	}

	public static void print(File f) {
		if (f != null) {
			if (f.isDirectory()) {
				File[] fileArray = f.listFiles();
				if (fileArray != null) {
					for (int i = 0; i < fileArray.length; i++) {
						// 递归调用
						print(fileArray[i]);
					}
				}
			} else {
				System.out.println(f);
			}
		}
	}
}
