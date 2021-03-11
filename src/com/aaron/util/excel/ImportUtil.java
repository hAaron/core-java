package com.aaron.util.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 导入excel工具类
 * 
 * @author Aaron
 * @date 2017年5月22日
 * @version 1.0
 * @package_name com.aaron.util.excel
 */
public class ImportUtil {

    public static List<Map<String, Object>> loadScoreInfo(String xlsPath) throws IOException {
        List<Map<String, Object>> list = new ArrayList();
        FileInputStream fileIn = new FileInputStream(xlsPath);
        // 防止2003 2007不兼容问题
        Workbook book = null;
        try {
            book = new XSSFWorkbook(fileIn);
        } catch (Exception ex) {
            book = new HSSFWorkbook(fileIn);
        }
        // 获取Excel文档中的第一个表单
        Sheet sheet = book.getSheetAt(0);

        // 对Sheet中的每一行进行迭代
        for (Row r : sheet) {
            // 如果当前行的行号（从0开始）未达到2（第三行）则从新循环
            if (r.getRowNum() < 1) {
                continue;
            }
            // 创建实体类
            Map<String, Object> map = new HashMap<String, Object>();
            // 取出当前行第1个单元格数据，并封装在info实体stuName属性上
            DecimalFormat df = new DecimalFormat("0");
            map.put("id", df.format(r.getCell(0).getNumericCellValue()));
            map.put("name", r.getCell(1).toString().trim());
            map.put("ip", r.getCell(2).toString().trim());
            map.put("room", r.getCell(3).toString().trim());
            list.add(map);
        }
        fileIn.close();
        System.out.println(list);
        return list;
    }

}
