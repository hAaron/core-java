package com.aaron.design.command;

/**
 * 请求者(Invoker)角色：负责调用命令对象执行请求，相关的方法叫做行动方法。 请求者角色，由键盘类扮演
 * 
 * @author Aaron
 * @date 2017年6月9日
 * @version 1.0
 * @package_name com.aaron.design.command
 */
public class Keypad {

	private Command playCommand;
	private Command rewindCommand;
	private Command stopCommand;

	public void setPlayCommand(Command playCommand) {
		this.playCommand = playCommand;
	}

	public void setRewindCommand(Command rewindCommand) {
		this.rewindCommand = rewindCommand;
	}

	public void setStopCommand(Command stopCommand) {
		this.stopCommand = stopCommand;
	}

	/**
	 * 执行播放方法
	 */
	public void play() {
		playCommand.execute();
	}

	/**
	 * 执行倒带方法
	 */
	public void rewind() {
		rewindCommand.execute();
	}

	/**
	 * 执行播放方法
	 */
	public void stop() {
		stopCommand.execute();
	}
}
