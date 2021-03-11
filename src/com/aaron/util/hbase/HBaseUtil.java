package com.aaron.util.hbase;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * Hbase 整合 Java 增删查改 -- Hbase的优点： </br>
 * 1.列的可以动态增加，并且列为空就不存储数据,节省存储空间</br>
 * 2.Hbase自动切分数据，使得数据存储自动具有水平scalability</br>
 * 3.Hbase可以提供高并发读写操作的支持</br>
 * --Hbase的缺点：</br>
 * 1. 不能支持条件查询，只支持按照Row key来查询 </br>
 * 2. 暂时不能支持Master server的故障切换,当Master宕机后,整个存储系统就会挂掉.</br>
 * 
 * @author Aaron
 * @date 2017年5月22日
 * @version 1.0
 * @package_name com.aaron.util.hbase
 */
public class HBaseUtil {

    private static Configuration configuration = null;
    static {
        Configuration hbase_Configuration = new Configuration();
        // 与hbase/conf/hbase-site.xml中hbase.zookeeper.quorum配置的值相同
        hbase_Configuration.set("hbase.zookeeper.quorum", "YP526F7-C01-XNFX-DATANODE02");
        // 与hbase/conf/hbase-site.xml中hbase.zookeeper.property.clientPort配置的值相同
        hbase_Configuration.set("hbase.zookeeper.property.clientPort", "2181");
        configuration = HBaseConfiguration.create(hbase_Configuration);
    }

    /**
     * 判断表是否存在
     * 
     * @param tableName
     * @return
     * @throws Exception
     */
    public static boolean isExist(String tableName) throws Exception {
        HBaseAdmin admin = new HBaseAdmin(configuration);
        return admin.tableExists(tableName);
    }

    /**
     * 创建数据库表
     * 
     * @param tableName
     * @param columns
     * @throws Exception
     */
    public static void createTable(String tableName, String[] columns) throws Exception {
        // 新建一个数据库管理员
        HBaseAdmin admin = new HBaseAdmin(configuration);
        if (admin.tableExists(tableName)) {
            System.out.println("表 " + tableName + " 已存在！");
            System.exit(0);
        } else {
            // 新建一个students表的描述
            HTableDescriptor tableDesc = new HTableDescriptor(tableName);
            // 描述里添加列族
            for (String column : columns) {
                tableDesc.addFamily(new HColumnDescriptor(column));
            }
            // 根据配置好的描述建表
            admin.createTable(tableDesc);
            System.out.println("创建表 " + tableName + " 成功!");
        }

    }

    /**
     * 删除数据库表
     * 
     * @param tableName
     * @throws Exception
     */
    public static void deleteTable(String tableName) throws Exception {
        // 创建一个数据库管理员
        HBaseAdmin admin = new HBaseAdmin(configuration);
        if (admin.tableExists(tableName)) {
            // 关闭一个表
            admin.disableTable(tableName);
            admin.deleteTable(tableName);
            System.out.println("删除表 " + tableName + " 成功！");
        } else {
            System.out.println("删除的表 " + tableName + " 不存在！");
            System.exit(0);
        }

    }

    /**
     * 添加一条数据
     * 
     * @param tableName
     * @param row
     * @param columnFamily
     * @param column
     * @param value
     * @throws Exception
     */
    public static void addRow(String tableName, String row, String columnFamily, String column, String value)
        throws Exception {
        HTable table = new HTable(configuration, tableName);
        Put put = new Put(Bytes.toBytes(row));
        // 参数分别:列族、列、值
        put.add(Bytes.toBytes(columnFamily), Bytes.toBytes(column), Bytes.toBytes(value));
        table.put(put);
    }

    /**
     * 删除一条(行)数据
     * 
     * @param tableName
     * @param row
     * @throws Exception
     */
    public static void delRow(String tableName, String row) throws Exception {
        HTable table = new HTable(configuration, tableName);
        Delete del = new Delete(Bytes.toBytes(row));
        table.delete(del);
    }

    /**
     * 删除多条数据
     * 
     * @param tableName
     * @param rows
     * @throws Exception
     */
    public static void delMultiRows(String tableName, String[] rows) throws Exception {
        HTable table = new HTable(configuration, tableName);
        List<Delete> delList = new ArrayList<Delete>();
        for (String row : rows) {
            Delete del = new Delete(Bytes.toBytes(row));
            delList.add(del);
        }
        table.delete(delList);
    }

    public static void getRow(String tableName, String row) throws Exception {
        HTable table = new HTable(configuration, tableName);
        Get get = new Get(Bytes.toBytes(row));
        Result result = table.get(get);
        // 输出结果,raw方法返回所有keyvalue数组
        for (KeyValue rowKV : result.raw()) {
            System.out.print("行名:" + new String(rowKV.getRow()) + " ");
            System.out.print("时间戳:" + rowKV.getTimestamp() + " ");
            System.out.print("列族名:" + new String(rowKV.getFamily()) + " ");
            System.out.print("列名:" + new String(rowKV.getQualifier()) + " ");
            System.out.println("值:" + new String(rowKV.getValue()));
        }
    }

    // 获取所有数据
    public static void getAllRows(String tableName) throws Exception {
        HTable table = new HTable(configuration, tableName);
        Scan scan = new Scan();
        ResultScanner results = table.getScanner(scan);
        // 输出结果
        for (Result result : results) {
            for (KeyValue rowKV : result.raw()) {
                System.out.print("行名:" + new String(rowKV.getRow()) + " ");
                System.out.print("时间戳:" + rowKV.getTimestamp() + " ");
                System.out.print("列族名:" + new String(rowKV.getFamily()) + " ");
                System.out.print("列名:" + new String(rowKV.getQualifier()) + " ");
                System.out.println("值:" + new String(rowKV.getValue()));
            }
        }
    }

    // 主函数
    public static void main(String[] args) {
        String tableNameString = "pspu:u_area_h";
        try {
            String tableName = "student";
            // 第一步：创建数据库表：“student”
            String[] columnFamilys = {"info", "course"};
            HBaseUtil.createTable(tableName, columnFamilys);
            // 第二步：向数据表的添加数据
            // 添加第一行数据
            if (isExist(tableName)) {
                HBaseUtil.addRow(tableName, "zpc", "info", "age", "20");
                HBaseUtil.addRow(tableName, "zpc", "info", "sex", "boy");
                HBaseUtil.addRow(tableName, "zpc", "course", "china", "97");
                HBaseUtil.addRow(tableName, "zpc", "course", "math", "128");
                HBaseUtil.addRow(tableName, "zpc", "course", "english", "85");
                // 添加第二行数据
                HBaseUtil.addRow(tableName, "henjun", "info", "age", "19");
                HBaseUtil.addRow(tableName, "<span style=\"font-family: Arial, Helvetica, sans-serif;\">henjun</span>",
                    "info", "sex", "boy");
                HBaseUtil.addRow(tableName, "henjun", "course", "china", "90");
                HBaseUtil.addRow(tableName, "henjun", "course", "math", "120");
                HBaseUtil.addRow(tableName, "henjun", "course", "english", "90");
                // 添加第三行数据
                HBaseUtil.addRow(tableName, "niaopeng", "info", "age", "18");
                HBaseUtil.addRow(tableName,
                    "<span style=\"font-family: Arial, Helvetica, sans-serif;\">niaopeng</span>", "info", "sex",
                    "girl");
                HBaseUtil.addRow(tableName, "niaopeng", "course", "china", "100");
                HBaseUtil.addRow(tableName, "niaopeng", "course", "math", "100");
                HBaseUtil.addRow(tableName, "niaopeng", "course", "english", "99");
                // 第三步：获取一条数据
                System.out.println("**************获取一条(zpc)数据*************");
                HBaseUtil.getRow(tableName, "zpc");
                // 第四步：获取所有数据
                System.out.println("**************获取所有数据***************");
                HBaseUtil.getAllRows(tableName);

                // 第五步：删除一条数据
                System.out.println("************删除一条(zpc)数据************");
                HBaseUtil.delRow(tableName, "zpc");
                HBaseUtil.getAllRows(tableName);
                // 第六步：删除多条数据
                System.out.println("**************删除多条数据***************");
                String rows[] = new String[] {"qingqing", "xiaoxue"};
                HBaseUtil.delMultiRows(tableName, rows);
                HBaseUtil.getAllRows(tableName);
                // 第七步：删除数据库
                System.out.println("***************删除数据库表**************");
                HBaseUtil.deleteTable(tableName);
                System.out.println("表" + tableName + "存在吗？" + isExist(tableName));
            } else {
                System.out.println(tableName + "此数据库表不存在！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
