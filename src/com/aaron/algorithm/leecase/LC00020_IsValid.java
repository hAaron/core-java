package com.aaron.algorithm.leecase;

import java.util.Stack;

/**
 * lc20. 有效的括号
 * 
 * @author huangbo
 * @date 2021/11/2
 */
public class LC00020_IsValid {

    public static void main(String[] args) {
        String s = "([)]";
        LC00020_IsValid name = new LC00020_IsValid();
        System.out.println(name.isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // 遇到左括号，将相应的右括号入栈
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            // 遇到右括号且匹配
            else if (!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            // 出现右括号多余或者右括号不匹配
            else
                return false;
        }
        // 如果字符串遍历结束，栈中仍有字符，说明有左括号多余
        // 否则反之
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }

        return s.length() == 0;
    }
}
