package com.aaron.util.ftp;

import java.io.*;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 * 测试ftp传输
 * 
 * @author Aaron
 * @date 2017年5月25日
 * @version 1.0
 * @package_name com.aaron.util.ftp
 */
public class FTPMain {

    /**
     * @author 作者姓名
     * 
     *         方法描述：主测试方法
     * @param args
     */
    public static void main(String[] args) {
        String ftpHost = "10.88.70.75";// 服务器地址
        int ftpPort = 21;// 服务器端口
        String ftpUsername = "gxk";// 登录用户名
        String ftpPassword = "gxk";// 登录密码

        FTPClient ftpClient = getFTPClient(ftpHost, ftpPassword, ftpUsername, ftpPort);
        /* 
         * 测试上传 
         */
        // upload(ftpClient, "test.txt", "H:\\vito_work\\test.txt");

        /* 
         * 测试下载 
         */
        download(ftpClient, "", "test.txt", "H:\\vito_work");
    }

    /**
     * 获取FTPClient对象
     * 
     * @param ftpHost
     *            主机服务器
     * @param ftpPassword
     *            密码
     * @param ftpUsername
     *            用户名
     * @param ftpPort
     *            端口默认为21
     * @return
     */
    public static FTPClient getFTPClient(String ftpHost, String ftpPassword, String ftpUsername, int ftpPort) {
        FTPClient ftpClient = new FTPClient();
        try {
            // 获取连接
            ftpClient.connect(ftpHost, ftpPort);
            // 登录
            ftpClient.login(ftpUsername, ftpPassword);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ftpClient;

    }

    /**
     * @author 作者姓名
     * 
     *         方法描述：上传文件
     * @param ftpClient
     * @param ftpPath
     *            ftp保存路径
     * @param localPath
     *            本地路径
     */
    public static void upload(FTPClient ftpClient, String ftpPath, String localPath) {

        File ftpFile = new File(ftpPath);
        File localFile = new File(localPath);

        try {
            FileInputStream fis = new FileInputStream(localFile);// 输入流
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);// 文件类型
            int reply = ftpClient.getReplyCode();// 响应编码

            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                return;
            }

            ftpClient.storeFile(localFile.getName(), fis);
            // System.out.println("***********");

            fis.close();
            ftpClient.logout();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @author 作者姓名
     * 
     *         方法描述：下载ftp上的文件到本地
     * @param ftpClient
     *            ftp服务
     * @param ftpPath
     *            ftp上的相对路径
     * @param fileName
     *            下载的文件名
     * @param localPath
     *            本地存储路径
     * @return
     */
    public static void download(FTPClient ftpClient, String ftpPath, String fileName, String localPath) {
        int reply = ftpClient.getReplyCode();// 响应编码

        try {

            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                return;
            }

            ftpClient.changeWorkingDirectory(ftpPath);// 转移到FTP服务器目录

            FTPFile[] ffs = ftpClient.listFiles();// 下载文件列表

            for (FTPFile ff : ffs) {
                if (ff.getName().equals(fileName)) {
                    File localFile = new File(localPath + "\\" + ff.getName());

                    OutputStream os = new FileOutputStream(localFile);

                    ftpClient.retrieveFile(ff.getName(), os);
                    // System.out.println("+++++++++++++");
                    os.close();
                }
            }

            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
