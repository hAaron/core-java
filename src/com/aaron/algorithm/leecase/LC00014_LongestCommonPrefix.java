package com.aaron.algorithm.leecase;

/**
 * lc14. 最长公共前缀
 * 
 * @author huangbo
 * @date 2021/10/22
 */
public class LC00014_LongestCommonPrefix {

    public static void main(String[] args) {

        String[] strs = new String[] {"", "dddff", "ccccdd"};
        LC00014_LongestCommonPrefix name = new LC00014_LongestCommonPrefix();
        System.out.println(name.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        String tempStr = strs[0];
        for (String str : strs) {
            while (!str.startsWith(tempStr)) {
                if (tempStr.length() == 0) {
                    return "";
                }

                tempStr = tempStr.substring(0, tempStr.length() - 1);
            }
        }

        return tempStr;

    }

}
