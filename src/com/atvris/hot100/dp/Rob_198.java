package com.atvris.hot100.dp;

/**
 * 打家劫舍
 * https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/24 19:08
 */
public class Rob_198 {

    public int rob(int[] nums) {
        // 到达一间房屋时要么偷，要么不偷
        // 偷的前提是前一家没偷；
        // 转移方程 dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])
        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]); // 重点，别忽略了
        for(int i = 2; i < n;i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return Math.max(dp[n - 1], dp[n - 2]);
    }
}
