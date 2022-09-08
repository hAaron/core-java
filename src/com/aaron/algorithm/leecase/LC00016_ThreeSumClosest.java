package com.aaron.algorithm.leecase;

import java.util.Arrays;

/**
 * lc16. 最接近的三数之和
 * 
 * @author huangbo
 * @date 2021/10/22
 */
public class LC00016_ThreeSumClosest {

    public static void main(String[] args) {

        int[] nums = new int[] {-1, 2, 1, -4};
        int target = 2;
        LC00016_ThreeSumClosest name = new LC00016_ThreeSumClosest();
        System.out.println(name.threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
