package com.aaron.util.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Aaron
 * @Date 创建时间：2016-5-26
 * @Version 1.0
 * 
 * @Project_Package_Description core-utils || com.hbaaron.hbjdbc
 * @Function_Description
 * 
 */
public class JdbcUtil {
	private static Connection conn = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	/**
	 * 查询
	 */
	private static List findAll() {
		List list = new ArrayList();
		// 1加载JDBC驱动程序
		// 2提供JDBC连接的URL
		// Class.forName(driver);
		// conn = DriverManager.getConnection(url, user, password);
		try {
			// 3创建数据库的连接
			conn = DBConfig.getConnection();
			// conn.setAutoCommit(false);
			String sql = "select * from seckill";
			// 4创建一个Statement
			preparedStatement = conn.prepareStatement(sql);
			// 5执行SQL语句
			resultSet = preparedStatement.executeQuery();
			// 6处理结果
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "...."
						+ resultSet.getString(2) + "...."
						+ resultSet.getString(3) + "...."
						+ resultSet.getBlob(4));
				list.add(resultSet);
			}
			// conn.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 8.关闭JDBC对象
			try {
				DBConfig.closeConnection(conn, preparedStatement, resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 往数据库中插入图片数据
	 */
	public static void insertImage(String strFile) {
		try {
			conn = DBConfig.getConnection();
			String sql = "insert into pic values (?,?,?)";
			preparedStatement = conn.prepareStatement(sql);
			int id = 0;
			File file = new File(strFile);
			FileInputStream fis = new FileInputStream(file);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, file.getName());
			preparedStatement.setBinaryStream(3, fis, (int) file.length());
			preparedStatement.executeUpdate();
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
	 * 从数据库中读取图片数据，存放在其他目录上
	 * @throws Exception 
	 */
	public static void readImage(String path) throws Exception {
		conn = DBConfig.getConnection();
		String sql = "select * from pic where id=3";
		preparedStatement = conn.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		resultSet.next();
		InputStream is = resultSet.getBinaryStream("img");
		
		FileOutputStream fileOutputStream = new FileOutputStream(path);
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = is.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len);
        }
        is.close();
        fileOutputStream.close();
	}

	public static void main(String[] args) throws Exception {
		//System.out.println(findAll());
		
		//insertImage("C:/Users/Administrator/Desktop/pic/1.jpg");
		
		readImage("C:/Users/Administrator/Desktop/hb/2.jpg");
		
	}

}
