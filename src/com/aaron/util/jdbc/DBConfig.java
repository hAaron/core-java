package com.aaron.util.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

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

    static Connection conn = null;
    private static String user = null;// "root";
    private static String password = null;// "1234";
    private static String driver = null;// "com.mysql.jdbc.Driver";
    private static String url = null;// "jdbc:mysql://localhost:3306/seckill?useUnicode=true&characterEncoding=utf8";

    /**
     * static==静态代码块 优化程序，只在会在类加载的时候执行一次
     */
    static {
        try {
            // 减少硬编码，直接从配置文件中读取
            InputStream iStream = DBConfig.class.getClassLoader().getResourceAsStream("dbconfig.properties");
            Properties properties = new Properties();
            properties.load(iStream);
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    /**
     * 获取数据库连接
     * 
     * @return 数据库连接
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        if (conn == null) {
            conn = DriverManager.getConnection(url, user, password);
        }
        return conn;
    }

    /**
     * 关闭Connection
     * 
     * @param conn
     * @throws Exception
     */
    public static void closeConnection(Connection conn) throws Exception {
        if (conn != null) {
            conn.close();
        }
    }

    /**
     * 关闭Connection，PreparedStatement，ResultSet
     * 
     * @param conn
     * @param preparedStatement
     * @param resultSet
     * @throws Exception
     */
    public static void closeConnection(Connection conn, PreparedStatement preparedStatement, ResultSet resultSet)
        throws Exception {
        if (conn != null) {
            conn.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
    }

    /**
     * 关闭Connection，PreparedStatement
     * 
     * @param conn
     * @param preparedStatement
     * @throws Exception
     */
    public static void closeConnection(Connection conn, PreparedStatement preparedStatement) throws Exception {
        if (conn != null) {
            conn.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
    }
}
