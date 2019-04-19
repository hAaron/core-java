package com.aaron.design.factorymethod;

/**
 * 抽象导出角色类
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.factorymethod
 */
public interface ExportFile {
	
	/**
	 * 导出
	 * @param data
	 * @return
	 */
	public boolean export(String data);
}