package com.aaron.design.visitor;

/**
 * 访问者模式的优点 好的扩展性：能够在不修改对象结构中的元素的情况下，为对象结构中的元素添加新的功能。 好的复用性：可以通过访问者来定义整个对象结构通用的功能，从而提高复用程度。
 * 分离无关行为：可以通过访问者来分离无关的行为，把相关的行为封装在一起，构成一个访问者，这样每一个访问者的功能都比较单一。
 * 
 * 访问者模式的缺点 对象结构变化很困难：不适用于对象结构中的类经常变化的情况，因为对象结构发生了改变，访问者的接口和访问者的实现都要发生相应的改变，代价太高。
 * 破坏封装：访问者模式通常需要对象结构开放内部数据给访问者和ObjectStructrue，这破坏了对象的封装性。
 * 
 * @author Aaron
 * @date 2017年6月11日
 * @version 1.0
 * @package_name com.aaron.design.visitor
 */
public class TestVisitor {
    public static void main(String[] args) {
        // 创建一个结构对象
        ObjectStructure os = new ObjectStructure();
        // 给结构增加一个节点
        os.add(new NodeA());
        // 给结构增加一个节点
        os.add(new NodeB());
        // 创建一个访问者
        Visitor visitor = new VisitorA();
        os.action(visitor);
    }
}
