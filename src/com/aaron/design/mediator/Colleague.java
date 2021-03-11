package com.aaron.design.mediator;

/**
 * 抽象同事类(Colleague)角色：定义出调停者到同事对象的接口。同事对象只知道调停者而不知道其余的同事对象。
 * 
 * @author Aaron
 * @date 2017年6月12日
 * @version 1.0
 * @package_name com.aaron.design.mediator
 */
public abstract class Colleague {
    // 持有一个调停者对象
    private Mediator mediator;

    /**
     * 构造函数
     */
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 获取当前同事类对应的调停者对象
     */
    public Mediator getMediator() {
        return mediator;
    }
}