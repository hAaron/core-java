package com.aaron.algorithm.leecase;

/**
 * lc34. 在排序数组中查找元素的第一个和最后一个位置
 * 
 * @author huangbo
 * @date 2021/11/19
 */
public class LC00034_SearchRange {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 2, 3, 45};
        int target = 2;
        LC00034_SearchRange name = new LC00034_SearchRange();
        System.out.println(name.searchRange(nums, target)[0] + "==" + name.searchRange(nums, target)[1]);

    }

    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target); // 二分查找

        if (index == -1) { // nums 中不存在 target，直接返回 {-1, -1}
            return new int[] {-1, -1}; // 匿名数组
        }
        // nums 中存在 targe，则左右滑动指针，来找到符合题意的区间
        int left = index;
        int right = index;
        // 向左滑动，找左边界
        while (left - 1 >= 0 && nums[left - 1] == nums[index]) { // 防止数组越界。逻辑短路，两个条件顺序不能换
            left--;
        }
        // 向左滑动，找右边界
        while (right + 1 < nums.length && nums[right + 1] == nums[index]) { // 防止数组越界。
            right++;
        }
        return new int[] {left, right};
    }

    /**
     * 二分查找
     * 
     * @param nums
     * @param target
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 不变量：左闭右闭区间

        while (left <= right) { // 不变量：左闭右闭区间
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1; // 不变量：左闭右闭区间
            }
        }
        return -1; // 不存在
    }
}
