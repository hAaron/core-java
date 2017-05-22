package com.aaron.util.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author Aaron
 * @Date 创建时间：2016-4-22
 * @Version 1.0 
 *
 * @Project_Package_Description jdbctest || com.aaron.test
 * @Function_Description 存储过程
 *
 */
public class JdbcProcedure {
	private static Connection conn = null;		
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	
	public static void main(String[] args) {
		getInProcedure();
		testJdbc();
		inProcedure();
		outProcedure();
		inoutProcedure();
	}

	private static void inoutProcedure() {
		try {
			conn = DBConfig.getConnection();
			conn.setAutoCommit(true);
			//call inout_demo('aa',@x);
			String sql = "call inout_demo(?,?);";
			CallableStatement statement = conn.prepareCall(sql);
			statement.setString(1, "'aa'");
			statement.registerOutParameter(2, java.sql.Types.INTEGER);
			statement.execute();
			int i= statement.getInt(2);
			System.out.println(i);
		}catch (Exception e) {
			System.out.println("数据库连接失败！"); 
			e.printStackTrace();
		}finally{
			try {
				DBConfig.closeConnection(conn, preparedStatement, resultSet);
				System.out.println("关闭数据库连接");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void outProcedure() {
		try {
			conn = DBConfig.getConnection();
			conn.setAutoCommit(true);
			
			//call out_demo('test',@y);
			String sql = "call out_demo(?,?)";
			CallableStatement statement = conn.prepareCall(sql);
			statement.setString(1, "test");
			statement.registerOutParameter(2, java.sql.Types.INTEGER);
			statement.execute();
			System.out.println(statement.getInt(2));
	        resultSet = statement.executeQuery(); 
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
			}
		}catch (Exception e) {
			System.out.println("数据库连接失败！"); 
			e.printStackTrace();
		}finally{
			try {
				DBConfig.closeConnection(conn, preparedStatement, resultSet);
				System.out.println("关闭数据库连接");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void inProcedure() {
		try {
			conn = DBConfig.getConnection();
			System.out.println("数据库连接成功！"); 
			String sql = "{call in_demo(?,?)}";
			CallableStatement statement = conn.prepareCall(sql);
			statement.setString(1, "xx");
			statement.setInt(2, 2);
	        resultSet = statement.executeQuery();  
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"...."+resultSet.getString(2)+"...."+
	            		resultSet.getString(3)+"...."+resultSet.getBlob(4));
			}
		}catch (Exception e) {
			System.out.println("数据库连接失败！"); 
			e.printStackTrace();
		}finally{
			try {
				DBConfig.closeConnection(conn, preparedStatement, resultSet);
				System.out.println("关闭数据库连接");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 测试jdbc
	 */
	private static void testJdbc() {
		try {
			conn = DBConfig.getConnection();
			System.out.println("数据库连接成功！"); 
			
	        String sql = "select * from tb_user ";  
	        preparedStatement =conn.prepareStatement(sql);
	        resultSet = preparedStatement.executeQuery();  
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"...."+resultSet.getString(2)+"...."+
	            		resultSet.getString(3)+"...."+resultSet.getBlob(4));
			}
			
		}catch (Exception e) {
			System.out.println("数据库连接失败！"); 
			e.printStackTrace();
		}finally{
			try {
				DBConfig.closeConnection(conn, preparedStatement, resultSet);
				System.out.println("关闭数据库连接");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 */
	private static void getInProcedure() {
		Connection conn = null;		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			conn = DBConfig.getConnection();
			System.out.println("数据库连接成功！"); 
			
			String sql = "{call sp_name(?)}";
			CallableStatement statement = conn.prepareCall(sql);
			statement.setInt(1, 1);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"...."+resultSet.getString(2)+"...."+
	            		resultSet.getString(3)+"...."+resultSet.getBlob(4));
			}
			
		}catch (Exception e) {
			System.out.println("数据库连接失败！"); 
			e.printStackTrace();
		}finally{
			try {
				DBConfig.closeConnection(conn, preparedStatement, resultSet);
				System.out.println("关闭数据库连接");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
//////////////////////////////////////////////////////////////////////////////
//存储过程
//drop procedure if exists in_demo;
//create procedure in_demo(in param1 varchar(20),in param2 int )
//begin
//set @x=param1;
//set @y=param2;
//update tb_user set name=@x where id=@y;
//select * from tb_user where name=@x;
//end;
//call in_demo('test',1);
//select @x;
//----------------------------------------------------------------------------------
//drop procedure if exists out_demo;
//create procedure out_demo(in param varchar(20),out o int)
//begin 
//select count(*) into o from tb_user where password=param;
//select count(*) from tb_user where password=param;
//end;
//call out_demo('test',@y);
//select @y;
//----------------------------------------------------------------------------------
//drop procedure if exists inout_demo;
//create procedure inout_demo(in inputParam varchar(20),inout inoutParam varchar(20))
//begin
//select inputParam;
//select concat('xyz',inputParam) as inoutParam;
//set inoutParam=11;
//end
//---
//drop procedure if exists inout_demo;
//CREATE PROCEDURE p3(INOUT age INT)
//BEGIN
//  SET age := age + 20;
//END$$
//set @currage =18$$
//call p3(@currage)$$
//select @currage
/////////////////////////////////////////////////////////////////////////////////////////
