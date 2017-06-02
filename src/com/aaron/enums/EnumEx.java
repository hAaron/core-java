package com.aaron.enums;

enum ExEnum {
	YY,RED, BLUE, GREEN;

}

public class EnumEx {
	public static void main(String[] args) {
		ExEnum ex = ExEnum.YY;
		switch (ex) {
		case RED:
			System.out.println("红色");
			break;
		case BLUE:
			System.out.println("蓝色");
			break;
		case GREEN:
			System.out.println("绿色");
			break;
		default:
			System.out.println("未知");
			break;
		}
	}
}
