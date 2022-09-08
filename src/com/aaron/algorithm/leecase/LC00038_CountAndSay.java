package com.aaron.algorithm.leecase;

/**
 * lc38. 外观数列
 * 
 * @author huangbo
 * @date 2021/11/25
 */
public class LC00038_CountAndSay {

    public static void main(String[] args) {
        int n = 4;
        LC00038_CountAndSay solution = new LC00038_CountAndSay();
        System.out.println(solution.countAndSay(n));
    }

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        else {
            String lastStr = countAndSay(n - 1); // 1 2 1 1
            StringBuilder ans = new StringBuilder();
            int i = 0, j = 1, len = lastStr.length();
            while (j < len) {
                if (lastStr.charAt(i) != lastStr.charAt(j)) {
                    ans.append(j - i).append(lastStr.charAt(i));
                    i = j;
                }
                j++;
            }
            ans.append(j - i).append(lastStr.charAt(i));
            return ans.toString();
        }
    }

}
