package com.aaron.design.future.owner;

/**
 * 真是数据，其构造过程是比较慢的
 * 
 * @author Aaron
 * @date 2019年7月30日
 * @version 1.0
 * @package_type com.aaron.design.future.owner.RealData
 */
public class RealData implements Data {
    protected final String result;

    public RealData(String para) {
        StringBuffer buffer = new StringBuffer();
        System.out.println("RealData 正在构造真实数据。。。");
        for (int i = 0; i < 10; i++) {
            buffer.append(para);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("RealData 真实数据构造完成。。。");
        result = buffer.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
