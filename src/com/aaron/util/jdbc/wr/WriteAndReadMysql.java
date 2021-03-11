package com.aaron.util.jdbc.wr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.aaron.util.jdbc.DBConfig;

/**
 * 测试数据库读写分离
 * 
 * @author Aaron
 * @date 2018年7月19日
 * @version 1.0
 * @package_type com.aaron.util.jdbc.wr.WriteAndReadMysql
 */
public class WriteAndReadMysql {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "insert into tb_name(name) values('write4');";
            // String sqlRead = "select * from tb_name;";
            connection = DBConfig.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            System.out.println(preparedStatement.execute());
            connection.setAutoCommit(false);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBConfig.closeConnection(connection, preparedStatement, resultSet);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
