package com.aaron.algorithm.leecase;

/**
 * lc9. 回文数
 * 
 * @author huangbo
 * @date 2021/10/15
 */
public class LC00009_IsPalindrome {
    public static void main(String[] args) {
        int x = 10;

        LC00009_IsPalindrome name = new LC00009_IsPalindrome();
        System.out.println(name.isPalindrome(x));

    }

    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        // 小于0或者是10的倍数都不是回文数
        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return x == reverse || x == reverse / 10;

    }

}
