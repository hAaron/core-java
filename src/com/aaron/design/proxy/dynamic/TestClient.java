package com.aaron.design.proxy.dynamic;

/**
 * 通过看静态代理可以动态扩展我们的对象，但是有个问题，在我们进行方法扩展的时候，
 * 比如我们的日志功能：每个前面都得写第一步、第二步。如果我们要再一些其他的东西，
 * 比如权限校验、代码说明，一个两个方法还好，万一方法成百个呢，那我们岂不是要累死。
 * 这就是动态代理要解决的问题，只需要写一次就可以。
 * 这里主要将额外的方法放在了代理类中实现(AOP)，不改变原来的代码结构
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.proxy.dynamic
 */
public class TestClient {
	public static void main(String[] args) {
		Calculator cal = new CalculatorImpl();

		Calculator proxy = new CalCulatorDynamicProxy(cal).getCalculator();

		int add = proxy.add(29, 1);

		int sub = proxy.sub(9, 2);

		int mul = proxy.mul(3, 7);

		double div = proxy.div(6, 8);
	}
}
