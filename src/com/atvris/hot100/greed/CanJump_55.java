package com.atvris.hot100.greed;

/**
 * 跳跃游戏
 * https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/24 17:37
 */
public class CanJump_55 {
    int jumpMaxIdx = 0;
    public boolean canJump(int[] nums) {
        // 跳跳跳 看能否跳到>=最后一个位置
        for(int i = 0; i < nums.length; i++) {
            if (i <= jumpMaxIdx) {
                // 如果能跳到当前位置上，计算更远的位置
                int curMaxJumpRight = i + nums[i];
                jumpMaxIdx = Math.max(jumpMaxIdx, curMaxJumpRight);
            }
        }
        return jumpMaxIdx >= nums.length - 1;
    }
}
