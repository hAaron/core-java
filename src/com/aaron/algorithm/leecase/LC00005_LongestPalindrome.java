package com.aaron.algorithm.leecase;

/**
 * lc5. 最长回文子串
 * 
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 
 * 输入：s = "babad"
 * 
 * 输出："bab"
 * 
 * 解释："aba" 同样是符合题意的答案。
 * 
 * @author huangbo
 * @date 2021/3/22
 */
public class LC00005_LongestPalindrome {

    public static void main(String[] args) {

        String s = "abababbbbb";

        LC00005_LongestPalindrome longestPalindrome = new LC00005_LongestPalindrome();
        String result = longestPalindrome.longestPalindrome(s);
        System.out.println(result);
    }

    public static int findLongest(char[] str, int low, int[] range) {
        // 查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
        // 定位中间部分的最后一个字符
        int ans = high;
        // 从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        // 记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // 保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            // 把回文看成中间的部分全是同一字符，左右部分相对称
            // 找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }
}
