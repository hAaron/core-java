package com.aaron.design.bridge;

/**
 * 效果及实现要点： 1．Bridge模式使用“对象间的组合关系”解耦了抽象和实现之间固有的绑定关系，使得抽象和实现可以沿着各自的维度来变化。
 * 2．所谓抽象和实现沿着各自维度的变化，即“子类化”它们，得到各个子类之后，便可以任意它们，从而获得不同路上的不同汽车。
 * 3．Bridge模式有时候类似于多继承方案，但是多继承方案往往违背了类的单一职责原则（即一个类只有一个变化的原因），复用性比较差。Bridge模式是比多继承方案更好的解决方法。
 * 4．Bridge模式的应用一般在“两个非常强的变化维度”，有时候即使有两个变化的维度，但是某个方向的变化维度并不剧烈——换言之两个变化不会导致纵横交错的结果，并不一定要使用Bridge模式。
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.bridge
 */
public class TestBridge {

    public static void main(String[] args) {
        // AbstractRoad abstractRoad = new SpeedWay();
        // abstractRoad.aCar = new Bus();
        // abstractRoad.run();

        AbstractRoad abstractRoad = new SpeedWay();
        abstractRoad.aCar = new Bus();

        AbstractPeople people = new Woman();
        people.road = abstractRoad;
        people.run();
    }
}