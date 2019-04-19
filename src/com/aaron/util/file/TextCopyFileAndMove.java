package com.aaron.util.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 实现文件的简单处理,复制和移动文件、目录等
 * 
 * @author Aaron
 * @date 2017年6月13日
 * @version 1.0
 * @package_name com.aaron.util.file
 */
public class TextCopyFileAndMove {
	/**
	 * 移动指定文件夹内的全部文件
	 * 
	 * @param from
	 * @param to
	 * @throws Exception
	 */
	public static void fileMove(String from, String to) throws Exception {
		try {
			File dir = new File(from);
			// 将文件或文件夹放入文件集
			File[] files = dir.listFiles();
			// 判断文件集是否为空
			if (files == null) {
				return;
			}
			// 创建目标目录
			File moveDir = new File(to);
			// 判断目标目录是否存在
			if (!moveDir.exists()) {
				// 不存在则创建
				moveDir.mkdirs();
			}
			// 遍历文件集
			for (int i = 0; i < files.length; i++) {
				// 如果是文件夹或目录,则递归调用fileMove方法，直到获得目录下的文件
				if (files[i].isDirectory()) {
					// 递归移动文件
					fileMove(files[i].getPath(), to + "\\" + files[i].getName());
					// 删除文件所在原目录
					files[i].delete();
				}
				// 将文件目录放入移动后的目录
				File moveFile = new File(moveDir.getPath() + "\\" + files[i].getName());
				if (moveFile.exists()) {
					// 目标文件夹下存在的话，删除
					moveFile.delete();
				}
				// 移动文件
				files[i].renameTo(moveFile);
				System.out.println(files[i] + " 移动成功");
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 复制目录下的文件（不包括该目录）到指定目录，会连同子目录一起复制过去。
	 * 
	 * @param toPath
	 * @param fromPath
	 */
	public static void copyFileFromDir(String toPath, String fromPath) {
		File file = new File(fromPath);
		// true:创建文件 false创建目录
		createFile(toPath, false);
		// 如果是目录
		if (file.isDirectory()) {
			copyFileToDir(toPath, listFile(file));
		}
	}

	/**
	 * 复制目录到指定目录,将目录以及目录下的文件和子目录全部复制到目标目录
	 * 
	 * @param toPath
	 * @param fromPath
	 */
	public static void copyDir(String toPath, String fromPath) {
		// 创建文件
		File targetFile = new File(toPath);
		// 创建目录
		createFile(targetFile, false);
		// 创建文件
		File file = new File(fromPath);
		// 如果传入是目录
		if (targetFile.isDirectory() && file.isDirectory()) {
			// 复制文件到指定目录
			copyFileToDir(targetFile.getAbsolutePath() + "/" + file.getName(), listFile(file));
		}
	}

	/**
	 * 复制一组文件到指定目录。targetDir是目标目录，filePath是需要复制的文件路径
	 * 
	 * @param toDir
	 * @param filePath
	 */
	public static void copyFileToDir(String toDir, String[] filePath) {
		// 目录路径为空
		if (toDir == null || "".equals(toDir)) {
			System.out.println("参数错误，目标路径不能为空");
			return;
		}
		File targetFile = new File(toDir);
		// 如果指定目录不存在
		if (!targetFile.exists()) {
			// 新建目录
			targetFile.mkdir();
		} else {
			// 如果不是目录
			if (!targetFile.isDirectory()) {
				System.out.println("参数错误，目标路径指向的不是一个目录！");
				return;
			}
		}
		// 遍历需要复制的文件路径
		for (int i = 0; i < filePath.length; i++) {
			// 创建文件
			File file = new File(filePath[i]);
			// 判断是否是目录
			if (file.isDirectory()) {
				// 递归调用方法获得目录下的文件
				copyFileToDir(toDir + "/" + file.getName(), listFile(file));
				System.out.println("复制文件 " + file);
			} else {
				// 复制文件到指定目录
				copyFileToDir(toDir, file, "");
			}
		}
	}

	/**
	 * 复制文件到指定目录
	 * 
	 * @param toDir
	 * @param file
	 * @param newName
	 */
	public static void copyFileToDir(String toDir, File file, String newName) {
		String newFile = "";
		if (newName != null && !"".equals(newName)) {
			newFile = toDir + "/" + newName;
		} else {
			newFile = toDir + "/" + file.getName();
		}
		File tFile = new File(newFile);
		// 调用方法复制文件
		copyFile(tFile, file);
	}

	/**
	 * 复制文件
	 * 
	 * @param toFile
	 * @param fromFile
	 */
	public static void copyFile(File toFile, File fromFile) {
		// 判断目标目录中文件是否存在
		if (toFile.exists()) {
			System.out.println("文件" + toFile.getAbsolutePath() + "已经存在，跳过该文件！");
			return;
		} else {
			// 创建文件
			createFile(toFile, true);
		}
		System.out.println("复制文件" + fromFile.getAbsolutePath() + "到" + toFile.getAbsolutePath());
		try {
			// 创建文件输入流
			InputStream is = new FileInputStream(fromFile);
			// 文件输出流
			FileOutputStream fos = new FileOutputStream(toFile);
			// 字节数组
			byte[] buffer = new byte[1024];
			// 将文件内容写到文件中
			while (is.read(buffer) != -1) {
				fos.write(buffer);
			}
			// 输入流关闭
			is.close();
			// 输出流关闭
			fos.close();
		} catch (FileNotFoundException e) {
			// 捕获文件不存在异常
			e.printStackTrace();
		} catch (IOException e) {
			// 捕获异常
			e.printStackTrace();
		}
	}

	/**
	 * 获取文件绝对路径
	 * 
	 * @param dir
	 * @return
	 */
	public static String[] listFile(File dir) {
		// 声获字符串赋值为路传入文件的路径
		String absolutPath = dir.getAbsolutePath();
		// 文件名数组
		String[] paths = dir.list();
		// 声明字符串数组，长度为传入文件的个数
		String[] files = new String[paths.length];
		for (int i = 0; i < paths.length; i++) {
			// 遍历显示文件绝对路径
			files[i] = absolutPath + "/" + paths[i];
		}
		return files;
	}

	/**
	 * 创建文件或目录
	 * 
	 * @param path
	 * @param isFile
	 */
	public static void createFile(String path, boolean isFile) {
		// 调用方法创建新文件或目录
		createFile(new File(path), isFile);
	}

	/**
	 * 创建文件
	 * 
	 * @param file
	 * @param isFile
	 */
	public static void createFile(File file, boolean isFile) {
		// 如果文件不存在
		if (!file.exists()) {
			// 如果文件父目录不存在
			if (!file.getParentFile().exists()) {
				createFile(file.getParentFile(), false);
			} else {
				// 存在文件父目录
				if (isFile) {
					// 创建文件
					try {
						// 创建新文件
						file.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					file.mkdir();// 创建目录
				}
			}
		}
	}

	/**
	 * java程序主入口处
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 目录路径 E:\temp\myFile
		String fromPath = "E:/temp/myFile";
		// 源路径
		String toPath = "D:/createFile";
		System.out.println("1.移动文件：从路径 " + fromPath + " 移动到路径 " + toPath);
		try {
			// 调用方法实现文件的移动
			fileMove(fromPath, toPath);
		} catch (Exception e) {
			System.out.println("移动文件出现问题" + e.getMessage());
		}
		System.out.println("2.复制目录 " + toPath + " 下的文件（不包括该目录）到指定目录" + fromPath + " ，会连同子目录一起复制过去。");
		// 调用方法实现目录复制
		copyFileFromDir(fromPath, toPath);
		System.out.println("3.复制目录 " + fromPath + "到指定目录 " + toPath + " ,将目录以及目录下的文件和子目录全部复制到目标目录");
		// 调用方法实现目录以用目录下的文件和子目录全部复制
		copyDir(toPath, fromPath);
	}
}
