package com.aaron.util.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * mysql处理图片字段工具类
 * 
 * @author Aaron
 * @date 2017年8月19日
 * @version 1.0
 * @package_name com.aaron.util.jdbc
 */
public class ImageJDBCUtil {
	// DDL
	/*
	 * CREATE TABLE pic ( `id` INT (11) NOT NULL auto_increment COMMENT '主键id',
	 * `name` VARCHAR (45) NOT NULL DEFAULT '' COMMENT '图片名称', `photo` LONGBLOB
	 * NOT NULL COMMENT '图片', PRIMARY KEY (`id`) ) ENGINE = INNODB DEFAULT
	 * CHARSET = utf8;
	 */
	private static final String sourceFile = "";// 需要保存到数据库原图片地址
	private static final String targetFile = "";// 需要从数据库导出的图片存放的地址

	private static Connection conn = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	private static File file = null;

	/**
	 * 从本地文件读取图像的二进制流
	 * 
	 * @param infile
	 * @return
	 */
	public static FileInputStream getImageByte(String infile) {
		FileInputStream imageByte = null;
		file = new File(infile);
		try {
			imageByte = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return imageByte;
	}

	/**
	 * 将图片流读出为图片
	 * 
	 * @param inputStream
	 * @param path
	 */
	public static void readBlob(InputStream inputStream, String path) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = inputStream.read(buffer)) != -1) {
				fileOutputStream.write(buffer, 0, len);
			}
			inputStream.close();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将本地文件保存到数据库
	 * 
	 * @param sourceFile
	 *            需要保存到数据库原图片地址
	 * @return
	 */
	public static int insertMysql(String sourceFile) {
		InputStream inputStream = null;
		int temp = 0;
		try {
			conn = DBConfig.getConnection();
			inputStream = ImageJDBCUtil.getImageByte(sourceFile);
			String sql = "insert into pic(id,name,photo) values (?,?,?)";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, "测试图片");
			preparedStatement.setBinaryStream(3, inputStream,
					inputStream.available());
			temp = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConfig.closeConnection(conn, preparedStatement);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return temp;
	}

	/**
	 * 数据库中读取并生成图片
	 * 
	 * @param targetFile
	 *            需要从数据库导出的图片存放的地址
	 * @return
	 */
	public static void queryMysql(String targetFile) {
		InputStream inputStream = null;
		try {
			conn = DBConfig.getConnection();
			String sql = "select * from pic where id = 1";
			preparedStatement = conn.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			resultSet.next();
			inputStream = resultSet.getBinaryStream("photo");
			ImageJDBCUtil.readBlob(inputStream, targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConfig.closeConnection(conn, preparedStatement, resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 测试类
	 * @param args
	 */
	public static void main(String[] args) {
		// System.out.println("插入数据库记录数："+ImageJDBCUtil.insertMysql("C:/Users/Administrator/Desktop/pic/1.jpg"));
		// ImageJDBCUtil.queryMysql("C:/Users/Administrator/Desktop/pic/2.jpg");
		// System.out.println("成功读出数据库记录数");
	}
}
