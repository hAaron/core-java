package com.aaron.test;

public enum EnumTest {
	MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THURSDAY("星期四"), FRIDAY("星期五"), SATURDAY("星期六"), SUNDAY("星期日");// 记住要用分号结束

	private String desc;

	private EnumTest() {
	}

	private EnumTest(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
}
