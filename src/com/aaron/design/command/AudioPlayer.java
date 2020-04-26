package com.aaron.design.command;

/**
 * 接收者角色，由录音机类扮演 
 * 接收者(Receiver)角色：负责具体实施和执行一个请求。任何一个类都可以成为接收者，实施和执行请求的方法叫做行动方法。
 * 
 * @author Aaron
 * @date 2017年6月9日
 * @version 1.0
 * @package_name com.aaron.design.command
 */
public class AudioPlayer {
	/**
	 * 真正执行命令相应的操作
	 */
	public void play() {
		System.out.println("播放...");
	}

	public void rewind() {
		System.out.println("倒带...");
	}

	public void stop() {
		System.out.println("停止...");
	}
}
