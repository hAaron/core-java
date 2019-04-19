package com.aaron.design.factorymethod;

/**
 * 具体工厂角色类
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.factorymethod
 */
public class ExportPdfFactory implements ExportFactory{

	@Override
	public ExportFile factory(String type) {
        if("standard".equals(type)){
            
            return new ExportStandardPdfFile();
            
        }else if("financial".equals(type)){
            
            return new ExportFinancialPdfFile();
            
        }else{
            throw new RuntimeException("没有找到对象");
        }
	}

}
