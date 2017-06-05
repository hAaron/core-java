package com.aaron.design.factorymethod;

/**
 * 具体导出角色类
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.factorymethod
 */
public class ExportFinancialPdfFile implements ExportFile{

	@Override
	public boolean export(String data) {
		// TODO Auto-generated method stub
        /**
         * 业务逻辑
         */
        System.out.println("导出财务版PDF文件");
        return true;
	}

}
