package com.aaron.algorithm.leecase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * lc4. 寻找两个正序数组的中位数
 * 
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 
 * @author huangbo
 * @date 2021/3/19
 */
public class LC00004_FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[] {2};
        int[] nums2 = new int[] {};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n1 = 0;
        int n2 = 0;
        while (nums1.length > 0 || nums2.length > 0) {
            if (nums1.length == 0) {
                if (nums2.length % 2 == 0) {
                    return nums2[(nums1.length + nums2.length) / 2 - 1] + nums2[(nums1.length + nums2.length) / 2];
                }
            }
        }

        return 0;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> mergeArrays = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            mergeArrays.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++) {
            mergeArrays.add(nums2[j]);
        }
        Collections.sort(mergeArrays);
        System.out.println(mergeArrays);
        if ((nums1.length + nums2.length) % 2 == 0) {
            Integer total = mergeArrays.get((nums1.length + nums2.length) / 2 - 1)
                + mergeArrays.get((nums1.length + nums2.length) / 2);
            return (double)total / 2;
        } else {
            return mergeArrays.get((nums1.length + nums2.length) / 2);
        }

    }
}
