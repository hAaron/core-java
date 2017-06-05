package com.aaron.design.proxy.staticp;

/**
 * 开始买票 
 * 所谓静态代理即在程序运行前代理类就已经存在，也就是说我们编写代码的时候就已经把代理类的代码写好了，</br>
 * 而动态代理则是在程序运行时自动生成代理类。
 * 
 * @author Aaron
 * @date 2017年6月5日
 * @version 1.0
 * @package_name com.aaron.design.proxy.staticp
 */
public class TestClient {

	public static void main(String[] args) {
		BuyReal real = new BuyReal();
		BuyProxy proxy = new BuyProxy(real);
		proxy.buy();
	}

}
