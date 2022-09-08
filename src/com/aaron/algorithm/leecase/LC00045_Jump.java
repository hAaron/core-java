package com.aaron.algorithm.leecase;

/**
 * lc45. 跳跃游戏 II
 * 
 * @author huangbo
 * @date 2021/11/30
 */
public class LC00045_Jump {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        // 记录跳跃的次数
        int count = 0;
        // 当前的覆盖最大区域
        int curDistance = 0;
        // 最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            // 在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance, i + nums[i]);
            // 说明当前一步，再跳一步就到达了末尾
            if (maxDistance >= nums.length - 1) {
                count++;
                break;
            }
            // 走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i == curDistance) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }
}
