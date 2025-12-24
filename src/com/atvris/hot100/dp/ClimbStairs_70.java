package com.atvris.hot100.dp;

/**
 * 爬楼梯
 * https://leetcode.cn/problems/climbing-stairs/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/24 18:48
 */
public class ClimbStairs_70 {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1]; // 别把i写成n...
        }
        return dp[n];
    }
}
