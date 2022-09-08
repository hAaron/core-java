package com.aaron.algorithm.leecase;

/**
 * 12. 整数转罗马数字
 * 
 * @author huangbo
 * @date 2021/10/20
 */
public class LC00012_IntToRoman {

    public static void main(String[] args) {
        LC00012_IntToRoman name = new LC00012_IntToRoman();
        int num = 1994;
        System.out.println(name.intToRoman(num));
    }

    public String intToRoman(int num) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(rom[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }
}
