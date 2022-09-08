package com.aaron.algorithm.leecase;

/**
 * lc41. 缺失的第一个正数
 * 
 * @author huangbo
 * @date 2021/11/26
 */
public class LC00041_FirstMissingPositive {
    public static void main(String[] args) {
        LC00041_FirstMissingPositive solution = new LC00041_FirstMissingPositive();
        int[] nums = new int[] {7, 8, 9, 11, 12};
        System.out.println(solution.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {

        // 遍历一次数组把大于等于1的和小于数组大小的值放到原数组对应位置，然后再遍历一次数组查当前下标是否和值对应，如果不对应那这个下标就是答案，否则遍历完都没出现那么答案就是数组长度加1。
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 1 && nums[i] <= nums.length) {
                temp[nums[i] - 1] = nums[i];
            }
        }

        int i;
        for (i = 0; i < nums.length; i++) {
            if (temp[i] != (i + 1)) {
                break;
            }
        }

        return i + 1;
    }
}
