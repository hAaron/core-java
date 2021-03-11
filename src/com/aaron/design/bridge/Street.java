package com.aaron.design.bridge;

/**
 * 
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.bridge
 */
public class Street extends AbstractRoad {
    @Override
    void run() {
        super.run();
        aCar.run();
        System.out.println("在市区街道行驶");
    }
}
