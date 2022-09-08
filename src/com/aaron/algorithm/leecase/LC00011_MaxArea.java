package com.aaron.algorithm.leecase;

/**
 * lc11. 盛最多水的容器
 * 
 * @author huangbo
 * @date 2021/10/19
 */
public class LC00011_MaxArea {

    public static void main(String[] args) {
        LC00011_MaxArea name = new LC00011_MaxArea();
        int[] a = {1, 6, 3, 4};
        System.out.println(name.maxArea(a));
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] < height[j] ? Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
