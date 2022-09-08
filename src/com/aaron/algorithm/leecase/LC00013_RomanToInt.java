package com.aaron.algorithm.leecase;

/**
 * lc13. 罗马数字转整数
 * 
 * @author huangbo
 * @date 2021/10/21
 */
public class LC00013_RomanToInt {
    public static void main(String[] args) {
        LC00013_RomanToInt name = new LC00013_RomanToInt();
        String str = "MCMXCIV";
        System.out.println(name.romanToInt(str));
    }

    public int romanToInt(String s) {
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += getValue(s.charAt(i));
        }
        return res;
    }

    public int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            case 'a':
                return 4;
            case 'b':
                return 9;
            case 'c':
                return 40;
            case 'd':
                return 90;
            case 'e':
                return 400;
            case 'f':
                return 900;
        }
        return 0;
    }
}
