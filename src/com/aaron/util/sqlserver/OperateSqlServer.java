package com.aaron.util.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperateSqlServer {
    private static Connection conn;

    public static void main(String[] args) {
        //conn = DBUtil.getConnection();
        GetInsert();
        GetSelect();

        GetUpdate();
        GetSelect();

        GetDelete();
        GetSelect();
    }

    /*
     * INSERT
     */
    public static void GetInsert() {
        if (conn != null) {
            //INSERT
            System.out.println("-----------INSERT------------");
            int x = 1 + (int) (Math.random() * 5000);
            String insert_str = "INSERT INTO tb_User (UserName,UserPwd,UserId) VALUES ('name_" + x + "','pwd_" + x + "',NEWID())";
            try {
                Statement insertstatement = conn.createStatement();
                int result = insertstatement.executeUpdate(insert_str);
                if (result > 0) {
                    System.out.println("添加成功");
                    System.out.println("-----------------------");
                } else {
                    System.out.println("添加失败");
                    System.out.println("-----------------------");
                }
            } catch (Exception e) {
                System.out.println("添加失败");
                System.out.println("-----------------------");
            }
        } else {
            System.out.println("请检查数据库连接");
            System.out.println("-----------------------");
        }
    }

    /*
     * SELECT
     */
    public static void GetSelect() {
        if (conn != null) {
            //SELECT
            System.out.println("-----------SELECT------------");
            String select_str = " SELECT * FROM tb_User ";
            try {
                PreparedStatement selectps = conn.prepareStatement(select_str);
                ResultSet rs = selectps.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("UserName");
                    String pwd = rs.getString("UserPwd");
                    String UserId = rs.getString("UserId");
                    System.out.println(name + "\t" + pwd + "\t" + UserId);
                }
                System.out.println("查询成功");
                System.out.println("-----------------------");
            } catch (Exception e) {
                System.out.println("查询失败");
                System.out.println("-----------------------");
            }
        } else {
            System.out.println("请检查数据库连接");
            System.out.println("-----------------------");
        }
    }

    /*
     * UPDATE
     */
    public static void GetUpdate() {
        if (conn != null) {
            //UPDATE
            System.out.println("-----------INSERT------------");
            String update_str = "UPDATE tb_User SET UserPwd=UserPwd+'xxxxxxxx' WHERE UserId='fa562573-218a-4205-b67d-ebdfac3f8329'";
            try {
                Statement updatestatement = conn.createStatement();
                int result = updatestatement.executeUpdate(update_str);
                if (result > 0) {
                    System.out.println("修改成功！");
                    System.out.println("-----------------------");
                } else {
                    System.out.println("修改失败");
                    System.out.println("-----------------------");
                }
            } catch (Exception e) {
                System.out.println("修改失败");
                System.out.println("-----------------------");
            }
        } else {
            System.out.println("请检查数据库连接");
            System.out.println("-----------------------");
        }
    }

    /*
     * DELETE
     */
    public static void GetDelete() {
        if (conn != null) {
            //DELETE
            System.out.println("-----------DELETE------------");
            String delete_str = "DELETE tb_User WHERE UserId!='fa562573-218a-4205-b67d-ebdfac3f8329'";
            try {
                Statement deletestatement = conn.createStatement();
                int result = deletestatement.executeUpdate(delete_str);
                if (result > 0) {
                    System.out.println("删除成功！");
                    System.out.println("-----------------------");
                } else {
                    System.out.println("删除失败");
                    System.out.println("-----------------------");
                }
            } catch (Exception e) {
                System.out.println("删除失败");
                System.out.println("-----------------------");
            }
        } else {
            System.out.println("请检查数据库连接");
            System.out.println("-----------------------");
        }
    }
}
