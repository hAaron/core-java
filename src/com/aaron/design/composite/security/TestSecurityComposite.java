package com.aaron.design.composite.security;

/**
 * 安全模式的合成模式要求管理聚集的方法只出现在树枝构件类中，而不出现在树叶构件类中。 可以看出，树枝构件类(Composite)给出了addChild()、removeChild()以及getChild()等方法的声明和实现，
 * 而树叶构件类则没有给出这些方法的声明或实现。这样的做法是安全的做法， 由于这个特点，客户端应用程序不可能错误地调用树叶构件的聚集方法，因为树叶构件没有这些方法，调用会导致编译错误。
 * 安全式合成模式的缺点是不够透明，因为树叶类和树枝类将具有不同的接口。
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.composite.security
 */
public class TestSecurityComposite {
    public static void main(String[] args) {
        Composite root = new Composite("服装");
        Composite c1 = new Composite("男装");
        Composite c2 = new Composite("女装");

        Leaf leaf1 = new Leaf("衬衫");
        Leaf leaf2 = new Leaf("夹克");
        Leaf leaf3 = new Leaf("裙子");
        Leaf leaf4 = new Leaf("套装");

        root.addChild(c1);
        root.addChild(c2);
        c1.addChild(leaf1);
        c1.addChild(leaf2);
        c2.addChild(leaf3);
        c2.addChild(leaf4);

        root.printStruct("");
    }
}
