package com.aaron.algorithm.leecase;

/**
 * lc27. 移除元素
 * 
 * @author huangbo
 * @date 2021/11/15
 */
public class LC00027_RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 2, 3};
        int val = 3;
        LC00027_RemoveElement name = new LC00027_RemoveElement();
        System.out.println(name.removeElement(nums, val));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }

    public int removeElement(int[] nums, int val) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            } else {
                nums[count] = nums[i];
            }
            count++;
        }

        return count;
    }
}
