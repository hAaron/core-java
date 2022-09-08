package com.aaron.algorithm.leecase;

/**
 * lc7. 整数反转
 * 
 * @author huangbo
 * @date 2021/10/14
 */
public class LC00007_Reverse {

    public static void main(String[] args) {
        int x = -321632;
        LC00007_Reverse reverse = new LC00007_Reverse();
        System.out.println(reverse.reverse(x));
    }

    public int reverse(int x) {

        int result = 0;
        while (x != 0) {

            int tmp = result;
            result = result * 10 + x % 10;
            // 取整数
            x = x / 10;
            // 将计算之后的结果 / 10，判断是否与计算之前相同，如果不同，证明发生溢出，返回0
            if (result / 10 != tmp) {
                return 0;
            }
        }

        return result;
    }

}
