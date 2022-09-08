package com.aaron.algorithm.leecase;

/**
 * lc42. 接雨水
 * 
 * @author huangbo
 * @date 2021/11/30
 */
public class LC00042_Trap {
    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { // 向左扫描记录左边最大值
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) { // 向右扫描记录右边最大值
                max_right = Math.max(max_right, height[j]);
            } // 下标i处能接到的水量
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }
}
