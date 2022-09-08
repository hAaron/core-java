package com.aaron.files;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * https://d.shikey.com/jike <br>
 * 已完结的课程
 * 
 * @author huangbo
 * @date 2021/4/29
 */
public class DownloadFile {

    public static void main(String[] args) throws IOException {
        List<String> filePaths = new ArrayList<>();
        // filePaths.add("D:\\files-person\\jike\\60 软件工程之美\\01-开篇词 (1讲)");
        // filePaths.add("D:\\files-person\\jike\\60 软件工程之美\\02-特别放送 (1讲)");
        filePaths.add("D:\\files-person\\jike\\07 微服务架构核心20讲");

        for (int i = 0; i < filePaths.size(); i++) {
            String filePath = filePaths.get(i);
            String fileName = filePath + "\\url.txt";
            List<String> downloadUrls = listDownloadUrl(fileName);
            System.out.println("current filePath :" + filePath);
            downloadUrls.stream().forEach(downloadUrl -> {
                String downloadFileName = downloadUrl.substring(downloadUrl.lastIndexOf("/") + 1, downloadUrl.length());
                try {
                    downloadFileName = URLDecoder.decode(downloadFileName, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                try {
                    downLoadFromUrl(downloadUrl, downloadFileName, filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("download success :" + downloadFileName);
            });
        }

    }

    public static List<String> listDownloadUrl(String fileName) throws IOException {
        List<String> downloadUrls = new ArrayList<>();
        // BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str;
        while ((str = bufferedReader.readLine()) != null) {
            downloadUrls.add(str);
        }

        // close
        inputStream.close();
        bufferedReader.close();
        return downloadUrls;
    }

    /**
     * 从网络Url中下载文件
     * 
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void downLoadFromUrl(String urlStr, String fileName, String savePath) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        // 设置超时间为3秒
        conn.setConnectTimeout(300 * 1000);
        // 防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        // 得到输入流
        InputStream inputStream = conn.getInputStream();
        // 获取自己数组
        byte[] getData = readInputStream(inputStream);

        // 文件保存位置
        File saveDir = new File(savePath);
        if (!saveDir.exists()) {
            saveDir.mkdir();
        }
        File file = new File(saveDir + File.separator + fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if (fos != null) {
            fos.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }

    }

    /**
     * 从输入流中获取字节数组
     * 
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
}
