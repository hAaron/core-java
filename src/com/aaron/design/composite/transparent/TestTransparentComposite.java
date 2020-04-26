package com.aaron.design.composite.transparent;

/**
 * 与安全式的合成模式不同的是，透明式的合成模式要求所有的具体构件类，不论树枝构件还是树叶构件，均符合一个固定接口。
 * 客户端无需再区分操作的是树枝对象(Composite)还是树叶对象(Leaf)了；对于客户端而言，操作的都是Component对象。
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.composite.transparent
 */
public class TestTransparentComposite {
	public static void main(String[] args) {
		Component root = new Composite("服装");
		Component c1 = new Composite("男装");
		Component c2 = new Composite("女装");

		Component leaf1 = new Leaf("衬衫");
		Component leaf2 = new Leaf("夹克");
		Component leaf3 = new Leaf("裙子");
		Component leaf4 = new Leaf("套装");

		root.addChild(c1);
		root.addChild(c2);
		c1.addChild(leaf1);
		c1.addChild(leaf2);
		c2.addChild(leaf3);
		c2.addChild(leaf4);

		root.printStruct("");
	}
}
