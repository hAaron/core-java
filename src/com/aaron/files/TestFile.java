package com.aaron.files;

import java.io.IOException;

/**
 * 测试类
 * 
 * @author Aaron
 * @date 2017年6月3日
 * @version 1.0
 * @package_name com.aaron.files
 */
public class TestFile {

	public static void main(String[] args) throws IOException {

		// 创建一个新的文件
		// FileOperator.createFile();

		// 删除文件
		// FileOperator.deleteFile();

		// 创建一个文件夹
		// FileOperator.createDir();

		// 列出指定目录的全部文件（包括隐藏文件）
		// FileOperator.listFiles();
		
		//判断一个指定的路径是否为目录
		//FileOperator.isDirectory();
		
		//搜索指定目录的全部内容
		FileOperator.listFilesByCondition();
	}

}
