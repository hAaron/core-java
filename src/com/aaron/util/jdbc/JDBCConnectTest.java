package com.aaron.util.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 测试数据库连接
 * @author Aaron
 * @date 2017年11月25日
 * @version 1.0
 * @package_type com.aaron.util.jdbc.JDBCConnectTest
 */
public class JDBCConnectTest {

	private static Connection conn = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public static void main(String[] args) {
		testJdbc();
	}

	/**
	 * 测试jdbc
	 */
	private static void testJdbc() {
		try {
			conn = DBConfig.getConnection();
			System.out.println("数据库连接成功！");

			String sql = "select * from tb_user ";
			preparedStatement = conn.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "...." + resultSet.getString(2) + "...."
						+ resultSet.getString(3) + "...." + resultSet.getBlob(4));
			}

		} catch (Exception e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		} finally {
			try {
				DBConfig.closeConnection(conn, preparedStatement, resultSet);
				System.out.println("关闭数据库连接");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
