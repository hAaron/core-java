package com.aaron.design.factorymethod;

/**
 * 客户端创建ExportHtmlFactory对象，这时客户端所持有变量的静态类型为ExportFactory，
 * 而实际类型为ExportHtmlFactory。然后客户端调用ExportHtmlFactory对象的工厂方法factory()，
 * 接着后者调用ExportFinancialHtmlFile的构造子创建出导出对象。
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.factorymethod
 */
public class TestFacatoryMethod {
	
	public static void main(String[] args) {
		ExportFactory factory = new ExportHtmlFactory();
		ExportFactory factory2 = new ExportPdfFactory();
		factory.factory("standard").export("");
		factory2.factory("financial").export("");
		
	}

}
