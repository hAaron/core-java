package com.aaron.algorithm.leecase;

import java.util.HashMap;
import java.util.Map;

/**
 * lc3. 无重复字符的最长子串
 * 
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 输入: s = "abcabcbb"
 * 
 * 输出: 3
 * 
 * @author huangbo
 * @date 2021/3/19
 */
public class LC00003_LengthOfLongestSubstring {

    public static void main(String[] args) {
        String str = "pwwkea";

        System.out.println(lengthOfLongestSubstring2(str));

    }

    /**
     * 使用哈希表存储字符以及对应的索引，窗口右边界right不断右移将新元素加入窗口，如果遇到重复的元素，就将窗口左边界left更新为 max(left, 重复元素的下一个位置)，取两者之中的较大值是防止左边界left向左移动。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < s.length(); end++) {

            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
            System.out.println("ans:" + ans + ", map:" + map);
        }

        return ans;
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            // 初始化
            last[i] = -1;
        }

        int start = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            ans = Math.max(ans, i - start + 1);
            last[index] = i;
        }

        return ans;
    }
}
