package com.aaron.files;

import java.io.File;
import java.io.IOException;

/**
 * 测试类
 * 
 * @author Aaron
 * @date 2017年6月3日
 * @version 1.0
 * @package_name com.aaron.files
 */
public class TestFile {

    public static void main(String[] args) throws IOException {
        final String FILE_PATHS = "E:" + File.separator + "temp";

        // 创建一个新的文件
        // FileOperator.createFile();

        // 删除文件
        // FileOperator.deleteFile();

        // 创建一个文件夹
        // FileOperator.createDir();

        // 列出指定目录的全部文件（包括隐藏文件）
        // FileOperator.listFiles();

        // 判断一个指定的路径是否为目录
        // FileOperator.isDirectory();

        // 搜索指定目录的全部内容
        // FileOperator.listFilesByCondition();

        // 使用RandomAccessFile写入文件
        // FileOperator.byRandomAccessFile();

        // 字节流 向文件中写入字符串
        // FileOperator.ziJieLiu();

        // 向文件中追加内容
        // FileOperator.zhuiJiaXie();

        // 字节流 读文件内容
        // FileOperator.readInputStream();

        // 根据读取文件是否已经到末尾来判断文件长度 是否为-1
        // FileOperator.chekcByEnd();

        // 字符流 写入数据 （write读）
        // FileOperator.writerOut();

        // 字符流 从文件中读内容（read）
        // FileOperator.readIn();

        // 当然最好采用循环读取的方式，因为我们有时候不知道文件到底有多大。 循环读文件内容
        // FileOperator.xunHuanRead();

        // 复制文件
        // FileOperator.copyFile(FILE_PATHS + File.separator + "myfile1.txt",
        // FILE_PATHS + File.separator + "myfile1bak.txt");

        // 将字节输出流转化为字符输出流 将字符串写进文件中
        // FileOperator.ziJieZhuanZiFuLiuWriter();

        // 将字节输入流变为字符输入流 将文件中的内容读出来
        // FileOperator.ziJieZhuanZiFuLiuReader();

        // 数据流写文件
        // FileOperator.dataOutputStreamWrite();

        // 数据流读文件
        // FileOperator.dataInputStreamRead();
    }

}
