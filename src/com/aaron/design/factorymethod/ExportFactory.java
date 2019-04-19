package com.aaron.design.factorymethod;

/**
 * 首先是抽象工厂角色源代码。它声明了一个工厂方法，要求所有的具体工厂角色都实现这个工厂方法。
 * 参数type表示导出的格式是哪一种结构，如：导出HTML格式有两种结构，一种是标准结构，一种是财务需要的结构。
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.factorymethod
 */
public interface ExportFactory {
	/**
	 * 工厂
	 * @param type
	 * @return
	 */
	public ExportFile factory(String type);
}