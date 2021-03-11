package com.aaron.util.file;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 文件的读写
 *
 * @author Aaron
 * @version 1.0
 * @date 2017年5月22日
 * @package_name com.aaron.util.file
 */
public class FileUtil {

    /**
     * 并且按照指定的标志截取字符串 放入到list集合中
     *
     * @param file
     * @return
     */
    public static List getList(File file) {
        List result = new ArrayList();
        int len = 0;
        StringBuffer sb = new StringBuffer("");
        try {
            FileInputStream is = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(reader);
            String line = null;
            while ((line = br.readLine()) != null) {
                if (len != 0) {
                    result.add(strList(line, "\\|"));
                    sb.append("\r\n" + line);
                } else {
                    result.add(strList(line, "\\|"));
                    sb.append(line);
                }
                len++;
            }
            br.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List strList(String str, String pattern) {

        List<String> list = new ArrayList<String>();
        String[] strings = str.split(pattern);
        list = Arrays.asList(strings);
        return list;
    }

    /**
     * 列出某文件夹及其子文件夹下面的文件，并可根据扩展名过滤
     *
     * @param path
     */
    public static void list(File path) {
        if (!path.exists()) {
            System.out.println("文件名称不存在!");
        } else {
            if (path.isFile()) {
                if (path.getName().toLowerCase().endsWith(".pdf") || path.getName().toLowerCase().endsWith(".doc")
                    || path.getName().toLowerCase().endsWith(".chm") || path.getName().toLowerCase().endsWith(".html")
                    || path.getName().toLowerCase().endsWith(".htm")) {// 文件格式
                    System.out.println(path);
                    System.out.println(path.getName());
                }
            } else {
                File[] files = path.listFiles();
                for (int i = 0; i < files.length; i++) {
                    list(files[i]);
                }
            }
        }
    }

    /**
     * 拷贝一个目录或者文件到指定路径下，即把源文件拷贝到目标文件路径下
     *
     * @param source
     * @param target
     */
    public static void copy(File source, File target) {
        File tarpath = new File(target, source.getName());
        if (source.isDirectory()) {
            tarpath.mkdir();
            File[] dir = source.listFiles();
            for (int i = 0; i < dir.length; i++) {
                copy(dir[i], tarpath);
            }
        } else {
            try {
                InputStream is = new FileInputStream(source); // 用于读取文件的原始字节流
                OutputStream os = new FileOutputStream(tarpath); // 用于写入文件的原始字节的流
                byte[] buf = new byte[1024];// 存储读取数据的缓冲区大小
                int len = 0;
                while ((len = is.read(buf)) != -1) {
                    os.write(buf, 0, len);
                }
                is.close();
                os.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * MultipartFile 转成 file文件
     * 
     * @param file
     * @return
     * @throws Exception
     */
    // public static File multipartFileToFile(MultipartFile file) throws Exception {
    // File toFile = null;
    // if (file.equals("") || file.getSize() <= 0) {
    // file = null;
    // } else {
    // InputStream ins = null;
    // ins = file.getInputStream();
    // toFile = new File(file.getOriginalFilename());
    // inputStreamToFile(ins, toFile);
    // ins.close();
    // }
    // return toFile;
    // }

    /**
     * inpustream 转成 file
     * 
     * @param ins
     * @param file
     */
    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除本地临时文件
     *
     * @param file
     */
    public static void delteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
            del.delete();
        }
    }

    // public static FileItem createFileItem(File file, String fieldName) {
    // FileItemFactory factory = new DiskFileItemFactory(16, null);
    // FileItem item = factory.createItem(fieldName, "text/plain", true, file.getName());
    // int bytesRead = 0;
    // byte[] buffer = new byte[8192];
    // try {
    // FileInputStream fis = new FileInputStream(file);
    // OutputStream os = item.getOutputStream();
    // while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
    // os.write(buffer, 0, bytesRead);
    // }
    // os.close();
    // fis.close();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // return item;
    // }

    // public static void main(String[] args) {
    // MultipartFile file = null;
    // MultipartFile thunfile = null;
    // log.info("-------start-------------");
    // System.out.println(file.getName());
    // System.out.println(file.getOriginalFilename());
    // File tempFile = null;
    // try {
    // tempFile = multipartFileToFile(thunfile);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // System.out.println(tempFile.getAbsolutePath());
    // thunfile = new CommonsMultipartFile(createFileItem(tempFile, "file"));
    // delteTempFile(tempFile);
    // System.out.println(thunfile.getName());
    // System.out.println(thunfile.getOriginalFilename());
    //
    // }

    public static void main(String[] args) {
        File source = new File("D:\\迅雷下载\\Java常用工具类\\file\\FileUtil.java");
        File target = new File("D:\\迅雷下载\\Java常用工具类\\file\\11");
        copy(source, target);
    }

}
