package com.aaron.util.jdbc;

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
			//conn.setAutoCommit(false);
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
			conn.commit();
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

	public static void main(String[] args) {
		System.out.println(findAll());
	}

}
