package com.aaron.design.prototype;

/**
 * 原型模式：</br>
 * 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象</br>
 * 通过一个已经存在的对象，复制出更多的具有与此对象具有相同类型的新的对象</br>
 * 
 * 对象深、浅复制的概念：</br>
 * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。</br>
 * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。</br>
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.prototype
 */
public class TestPrototype {

    public static void main(String[] args) {

        ConcretePrototype prototypeByOwnClone = new ConcretePrototype();
        prototypeByOwnClone.setName("prototypeByOwnClone");
        ConcretePrototype newPrototype1 = (ConcretePrototype)prototypeByOwnClone.cloneMethod();
        System.out.println(newPrototype1);

        System.out.println("........................");
        ConcretePrototype2 prototypeByCloneable = new ConcretePrototype2();
        prototypeByCloneable.setName("prototypeByCloneable");
        ConcretePrototype2 newPrototype2 = (ConcretePrototype2)prototypeByCloneable.cloneMethod();
        System.out.println(newPrototype2);

        System.out.println("........................");
        ConcretePrototype3 prototypeBySerializable = new ConcretePrototype3();
        prototypeBySerializable.setName("prototypeBySerializable");
        ConcretePrototype3 newPrototype3 = (ConcretePrototype3)prototypeBySerializable.cloneMethod();
        System.out.println(newPrototype3);
    }
}