package com.aaron.algorithm.leecase;

import java.util.ArrayList;
import java.util.List;

/**
 * lc22. 括号生成
 * 
 * @author huangbo
 * @date 2021/11/12
 */
public class LC00022_GenerateParenthesis {
    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        LC00022_GenerateParenthesis name = new LC00022_GenerateParenthesis();
        System.out.println(name.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {

        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String curStr) {
        System.out.println(curStr);
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            System.out.println("res》》》》" + res);
            return;
        }

        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")");
        }
    }
}
