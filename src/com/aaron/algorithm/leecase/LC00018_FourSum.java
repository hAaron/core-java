package com.aaron.algorithm.leecase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * lc18. 四数之和
 * 
 * @author huangbo
 * @date 2021/10/29
 */
public class LC00018_FourSum {

    public static void main(String[] args) {

        int[] nums = new int[] {1, 0, -1, 0, -2, 2};
        int target = 8;
        LC00018_FourSum name = new LC00018_FourSum();
        System.out.println(name.fourSum(nums, target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) { // O(n^3)
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums); // O(nlogn)
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) { // O(n^3)
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 跳过重复
            }
            for (int j = i + 1; j < len - 2; j++) { // same as threeSum O(n^2)
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue; // 跳过重复
                }
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // 跳过重复, 可以先不看
                        while (left < right && nums[left + 1] == nums[left])
                            left++;
                        while (left < right && nums[right - 1] == nums[right])
                            right--;

                        // 逼近中间
                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else { // sum < target
                        left++;
                    }
                }
            }
        }

        return res;
    }
}
