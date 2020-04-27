package com.aaron.util.sqlserver;

public class TestDriver {
    //驱动路径
    private static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //程序入口函数
    public static void main(String[] args) {
        try {
            //加载驱动程序
            Class.forName(DBDRIVER);
            System.out.println("数据库驱动加载成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
