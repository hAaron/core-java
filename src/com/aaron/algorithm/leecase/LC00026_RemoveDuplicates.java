package com.aaron.algorithm.leecase;

/**
 * lc26. 删除有序数组中的重复项
 * 
 * @author huangbo
 * @date 2021/11/12
 */
public class LC00026_RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 2, 3, 45};
        LC00026_RemoveDuplicates name = new LC00026_RemoveDuplicates();
        System.out.println(name.removeDuplicates(nums));

    }

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
