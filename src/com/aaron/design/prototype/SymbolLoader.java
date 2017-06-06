package com.aaron.design.prototype;

import java.util.*;

/**
 * 原型管理器角色保持一个聚集，作为对所有原型对象的登记， 这个角色提供必要的方法， 供外界增加新的原型对象和取得已经登记过的原型对象。
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.prototype
 */
public class SymbolLoader {

	/**
	 * 用来记录原型的编号和原型实例的对应关系
	 */
	private Hashtable<String, Object> symbols = new Hashtable<String, Object>();

	public SymbolLoader() {
		symbols.put("Line", new LineSymbol());
		symbols.put("Note", new NoteSymbol());
	}

	public Hashtable<String, Object> getSymbols() {
		return symbols;
	}
}