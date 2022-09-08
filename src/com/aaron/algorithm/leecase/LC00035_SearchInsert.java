package com.aaron.algorithm.leecase;

/**
 * lc35. 搜索插入位置
 * 
 * @author huangbo
 * @date 2021/11/19
 */
public class LC00035_SearchInsert {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 2, 3, 45};
        int target = 2;
        LC00035_SearchInsert name = new LC00035_SearchInsert();
        System.out.println(name.searchInsert(nums, target));

    }

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        // 特殊判断
        if (nums[len - 1] < target) {
            return len;
        }

        // 程序走到这里一定有 nums[len - 1] >= target
        int left = 0;
        int right = len - 1;
        // 在区间 nums[left..right] 里查找第 1 个大于等于 target 的元素的下标
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 下一轮搜索的区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 [left..mid]
                right = mid;
            }
        }
        return left;
    }

}
