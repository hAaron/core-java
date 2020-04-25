package com.aaron.enums;

import java.awt.Color;

enum ExEnum1 {
	RED("红色", Color.RED),

	BLUE("蓝色", Color.BLUE),

	GREEN("绿色", Color.GREEN);

	private String summary;
	private Color color;

	private ExEnum1(String summary, Color color) {
		this.summary = summary;
		this.color = color;
	}

	public String getSummary() {
		return this.summary;
	}

	public Color getColor() {
		return this.color;
	}

}

public class EnumEx1 {
	public static void main(String[] args) {

		for (ExEnum1 string : ExEnum1.values()) {
			System.out.print(string + "--");
			System.out.print(string.getColor() + "--");
			System.out.print(string.getSummary());
			System.out.println();
		}
	}

}
