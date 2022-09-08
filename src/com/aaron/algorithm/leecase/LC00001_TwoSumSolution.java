package com.aaron.algorithm.leecase;

import java.util.HashMap;
import java.util.Map;

/**
 * lc1. 两数之和
 * 
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 
 * 输入：nums = [2,7,11,15], target = 9
 * 
 * 输出：[0,1]
 * 
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 
 *
 * @author huangbo
 * @date 2021/3/11
 */
class LC00001_TwoSumSolution {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int taget = 17;
        int[] result = twoSum2(nums, taget);
        if (result != null) {
            System.out.println(result[0] + "#" + result[1]);
        }

    }

    /**
     * 暴力枚举: 时间复杂度 O(N2) 空间复杂度 O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = null;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }

        }

        return result;
    }

    /**
     * 哈希匹配: 时间复杂度 O(N) 空间复杂度 O(N)，哈希表
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] result = null;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return result;
    }

}