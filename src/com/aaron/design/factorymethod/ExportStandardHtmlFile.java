package com.aaron.design.factorymethod;

/**
 * 具体导出角色类
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.factorymethod
 */
public class ExportStandardHtmlFile implements ExportFile {

    @Override
    public boolean export(String data) {
        // TODO
        /**
         * 业务逻辑
         */
        System.out.println("导出标准HTML文件");
        return true;
    }

}
