package com.aaron.design.templatemethod;

/**
 * 子类可以置换掉父类的可变部分，但是子类却不可以改变模板方法所代表的顶级逻辑。
 * 
 * @author Aaron
 * @date 2017年6月8日
 * @version 1.0
 * @package_name com.aaron.design.templatemethod
 */
public class TestTemplatemethod {
    public static void main(String[] args) {
        AbstractAccount account = new MoneyMarketAccount();
        System.out.println("货币市场账号的利息数额为：" + account.calculateInterest());
        System.out.println("******************************************");
        account = new RegularIntervalsAccount();
        System.out.println("定期账号的利息数额为：" + account.calculateInterest());
    }
}