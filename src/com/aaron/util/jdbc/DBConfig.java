package com.aaron.util.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author Aaron
 * @Date 创建时间：2016-4-28
 * @Version 1.0 
 *
 * @Project_Package_Description core-utils || com.hbaaron.jdbc
 * @Function_Description 连接数据库，已经关闭连接
 *
 */
public class DBConfig {
	
	private static final String user = "root";
	private static final String password = "1234";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/seckill?useUnicode=true&characterEncoding=utf8";
	static Connection conn = null;		
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	static {
		try {
			Class.forName(driver);	 									
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return 数据库连接
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		if(conn == null) {
			conn = DriverManager.getConnection(url, user, password);
		}
		return conn;
	}
	
	/**
	 * 关闭Connection
	 * @param conn
	 * @throws Exception
	 */
	public static void closeConnection(Connection conn) throws Exception {
		if(conn != null) {
			conn.close();
		}
	}
	/**
	 * 关闭Connection，PreparedStatement，ResultSet
	 * @param conn
	 * @param preparedStatement
	 * @param resultSet
	 * @throws Exception
	 */
	public static void closeConnection(Connection conn,PreparedStatement preparedStatement,ResultSet resultSet) throws Exception {
		if(conn != null) {
			conn.close();
		}
		if(preparedStatement != null) {
			preparedStatement.close();
		}
		if(resultSet != null) {
			resultSet.close();
		}
	}
	/**
	 * 关闭Connection，PreparedStatement
	 * @param conn
	 * @param preparedStatement
	 * @throws Exception
	 */
	public static void closeConnection(Connection conn,PreparedStatement preparedStatement) throws Exception {
		if(conn != null) {
			conn.close();
		}
		if(preparedStatement != null) {
			preparedStatement.close();
		}
	}
}

