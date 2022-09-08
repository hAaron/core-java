package com.aaron.algorithm.leecase;

/**
 * lc28. 实现 strStr()
 * 
 * @author huangbo
 * @date 2021/11/15
 */
public class LC00028_StrStr {
    public static void main(String[] args) {
        String haystack = "aaaaa";
        String needle = "bba";
        LC00028_StrStr name = new LC00028_StrStr();
        System.out.println(name.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {

        if (needle == null || "".equals(needle)) {
            return 0;
        }
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        } else {
            return -1;
        }

    }
}
