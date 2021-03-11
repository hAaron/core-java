package com.aaron.design.visitor;

/**
 * 具体节点(ConcreteNode)角色：实现了抽象节点所规定的接受操作。
 * 
 * @author Aaron
 * @date 2017年6月11日
 * @version 1.0
 * @package_name com.aaron.design.visitor
 */
public class NodeB extends Node {

    /**
     * 接受方法
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * NodeB特有的方法
     */
    public String operationB() {
        return "NodeB";
    }

}
