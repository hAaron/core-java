package com.aaron.design.observer;

import java.util.*;

/**
 * 主题接口，定义方法
 * 
 * @author Aaron
 * @date 2017年6月1日
 * @version 1.0
 * @package_name com.aaron.design.observer
 */
public interface Subject {
	public abstract void attach(Observer o);

	public abstract void detach(Observer o);

	public abstract void sendNotify();

	public abstract Vector getState();

	public abstract void setState(String act, String str);
}