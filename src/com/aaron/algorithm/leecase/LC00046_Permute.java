package com.aaron.algorithm.leecase;

import java.util.ArrayList;
import java.util.List;

/**
 * lc46. 全排列
 * 
 * @author huangbo
 * @date 2021/11/30
 */
public class LC00046_Permute {

    public static void main(String[] args) {
        LC00046_Permute name = new LC00046_Permute();
        int[] nums = new int[] {1, 2, 3};
        System.out.println(name.permute(nums));

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
                backtrack(res, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
