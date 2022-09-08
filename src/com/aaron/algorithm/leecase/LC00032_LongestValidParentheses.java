package com.aaron.algorithm.leecase;

import java.util.Deque;
import java.util.LinkedList;

/**
 * lc32. 最长有效括号
 * 
 * @author huangbo
 * @date 2021/11/17
 */
public class LC00032_LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

}
