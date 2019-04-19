package com.aaron.util.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 * ftp工具类：主要用户ftp文件上传下载，以及获取文件名
 * 
 * @author Aaron
 * @date 2017年5月25日
 * @version 1.0
 * @package_name com.aaron.util.ftp
 */
public class FtpUtil {

	private static FTPClient ftpClient;
	private static final String strencoding = "UTF-8";
	/**
	 * 端口号
	 */
	private static int port = 21;
	/**
	 * 服务器IP地址
	 */
	private static final String HOST = "103.37.124.35";
	/**
	 * 用户名
	 */
	private static final String USER_NAME = "hbaaron";
	/**
	 * 密码
	 */
	private static final String PASSWORD = "650EB97A171e16";
	/**
	 * ftpurl
	 */
	private static final String PATH = "ftp://103.37.124.35/";

	/**
	 * 连接ftp 获取FTPClient实例
	 */
	public static FTPClient getFtpClient() {
		ftpClient = new FTPClient();
		try {
			// 获取连接
			ftpClient.connect(HOST, port);
			// 登录
			ftpClient.login(USER_NAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ftpClient;
	}

	/**
	 * 关闭连接
	 */
	public void closeServer() throws IOException {
		if (ftpClient != null || ftpClient.isConnected()) {
			try {
				ftpClient.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读取指定目录下的文件名
	 */
	public List<String> getFileList(String filePath) {
		List<String> fileLists = new ArrayList<String>();
		FTPFile[] ftpFiles = null;
		try {
			ftpClient.changeWorkingDirectory(filePath);
			ftpFiles = ftpClient.listFiles();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; ftpFiles != null && i < ftpFiles.length; i++) {
			FTPFile file = ftpFiles[i];
			if (file.isFile()) {
				fileLists.add(file.getName());
			}
		}
		return fileLists;
	}

	/**
	 * 
	 * @param file
	 *            上传的文件或文件夹
	 * @throws Exception
	 */
	private static void upload(File file) throws Exception {
		if (file.isDirectory()) {
			ftpClient.makeDirectory(file.getName());
			ftpClient.changeWorkingDirectory(file.getName());
			String[] files = file.list();
			for (int i = 0; i < files.length; i++) {
				File file1 = new File(file.getPath() + "\\" + files[i]);
				if (file1.isDirectory()) {
					upload(file1);
					ftpClient.changeToParentDirectory();
				} else {
					File file2 = new File(file.getPath() + "\\" + files[i]);
					FileInputStream input = new FileInputStream(file2);
					ftpClient.storeFile(file2.getName(), input);
					input.close();
				}
			}
		} else {
			File file2 = new File(file.getPath());
			FileInputStream input = new FileInputStream(file2);
			ftpClient.storeFile(file2.getName(), input);
			input.close();
		}
	}

	/**
	 * 下载ftp上的文件到本地
	 * 
	 * @param ftpPath
	 *            ftp上的相对路径
	 * @param fileName
	 *            下载的文件名
	 * @param localPath
	 *            本地存储路径
	 */
	public static void download(String ftpPath, String fileName, String localPath) {
		try {
			// 转移到FTP服务器目录
			ftpClient.changeWorkingDirectory(ftpPath);
			// 下载文件列表
			FTPFile[] ffs = ftpClient.listFiles();

			for (FTPFile ff : ffs) {
				if (ff.getName().equals(fileName)) {
					File localFile = new File(localPath + "\\" + ff.getName());
					OutputStream os = new FileOutputStream(localFile);
					ftpClient.retrieveFile(ff.getName(), os);
					os.close();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过路径获得路径下所有文件 输出文件名
	 * 
	 * @param pathName
	 * @throws IOException
	 */
	public static void fileLists(String pathName) throws IOException {
		if (pathName.startsWith("/") && pathName.endsWith("/")) {
			String directory = pathName;
			ftpClient.changeWorkingDirectory(directory);
			FTPFile[] files = ftpClient.listFiles();
			for (int i = 0; i < files.length; i++) {
				System.out.println("文件名:" + files[i].getName() + " 文件大小为：" + files[i].getSize());
				if (files[i].isFile()) {
				} else if (files[i].isDirectory()) {
					fileLists(directory + files[i].getName() + "/");
				}
			}
		}
	}

	// 测试
	public static void main(String[] args) throws Exception {
		FtpUtil ftp = new FtpUtil();
		System.out.println("测试连接ftp 开始。。。。。。。。");
		ftp.getFtpClient();
		System.out.println("测试连接ftp 结束。。。。。。。。");
		System.out.println("==========================");

		System.out.println("测试读取指定目录下的文件名 开始。。。。。。。。");
		String filePath = "/webapps/BaiduYun/"; // 指定ftp上的目录
		List<String> list = ftp.getFileList(filePath);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("测试读取指定目录下的文件名 结束。。。。。。。。");
		System.out.println("==========================");

		System.out.println("测试上传本地文件或文件夹到ftp上 开始。。。。。。。。");
		File file = new File("D:/AllFiles/testftp"); // 指定本地文件或者文件夹
		ftp.upload(file);
		System.out.println("测试上传本地文件或文件夹到ftp上 结束。。。。。。。。");
		System.out.println("==========================");

		System.out.println("测试从ftp上下载文件 开始。。。。。。。。");
		ftp.download("/logs/", "localhost.2016-03-23.log", "D:/AllFiles/testftp");
		System.out.println("测试从ftp上下载文件 结束。。。。。。。。");
		System.out.println("==========================");

		System.out.println("测试获取文件 开始。。。。。。。。");
		String pathname = "/conf/";
		ftpClient.changeWorkingDirectory(pathname);
		FTPFile[] files = ftpClient.listFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.print("文件名：" + files[i].getName());
			System.out.println("-- 文件大小：" + files[i].getSize());

		}
		System.out.println("测试获取文件 结束。。。。。。。。");
		System.out.println("==========================");

		System.out.println("测试关闭ftp 开始。。。。。。。。");
		ftp.closeServer();
		System.out.println("测试关闭ftp 结束。。。。。。。。");
		System.out.println("==========================");
	}

}
