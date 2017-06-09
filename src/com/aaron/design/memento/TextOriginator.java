package com.aaron.design.memento;

/**
 * 由于“自述历史”作为一个备忘录模式的特殊实现形式非常简单易懂，它可能是备忘录模式最为流行的实现形式。
 * 
 * @author Aaron
 * @date 2017年6月9日
 * @version 1.0
 * @package_name com.aaron.design.memento
 */
public class TextOriginator {
	public static void main(String[] args) {

		Originator o = new Originator();
		// 修改状态
		o.changeState("state 0");
		// 创建备忘录
		MementoIF memento = o.createMemento();
		// 修改状态
		o.changeState("state 1");
		// 按照备忘录恢复对象的状态
		o.restoreMemento(memento);
	}
}