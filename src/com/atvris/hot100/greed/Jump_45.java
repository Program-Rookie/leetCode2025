package com.atvris.hot100.greed;

/**
 * 跳跃游戏 II
 * https://leetcode.cn/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/24 18:07
 */
public class Jump_45 {

    public int jump(int[] nums) {
        // 每次往后跳前都看下跳完之后能跳的最长距离
        // 这样跳到最长距离只需要两步
        // 通过这样的判断来选择下一个起跳点
        int n = nums.length;
        // 下一次能跳的最长距离
        int maxNextRight = 0;
        // 能达到的最远距离
        int reachableRight = 0;
        int step = 0;
        for(int i = 0; i < n - 1; i++) {
            int right = i + nums[i];
            if (i <= maxNextRight) {
                maxNextRight = Math.max(maxNextRight, right);
                if (i == reachableRight) {
                    reachableRight = maxNextRight;
                    step++;
                }
            }
        }
        return step;
    }
}
