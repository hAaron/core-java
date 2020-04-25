package com.aaron.design.mediator;

import java.io.*;

/**
 * 同事类——光驱.
 * 具体同事类(ConcreteColleague)角色：所有的具体同事类均从抽象同事类继承而来。实现自己的业务，在需要与其他同事通信的时候，
 * 就与持有的调停者通信，调停者会负责与其他的同事交互。
 * 
 * @author Aaron
 * @date 2017年6月12日
 * @version 1.0
 * @package_name com.aaron.design.mediator
 */
public class CDDriver extends Colleague {
	// 光驱读取出来的数据
	private String data = "";

	/**
	 * 构造函数
	 */
	public CDDriver(Mediator mediator) {
		super(mediator);
	}

	/**
	 * 获取光盘读取出来的数据
	 */
	public String getData() {
		return data;
	}

	/**
	 * 读取光盘
	 */
	public void readCD() {
		// 逗号前是视频显示的数据，逗号后是声音
		this.data = "One Piece,海贼王我当定了";
		// 通知主板，自己的状态发生了改变
		getMediator().changed(this);
	}
}