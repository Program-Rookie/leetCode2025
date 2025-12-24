package com.atvris.hot100.dp;

import java.util.Arrays;

/**
 * 零钱兑换
 * https://leetcode.cn/problems/coin-change/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/24 21:39
 */
public class CoinChange_322 {

    /**
     * 在写的时候没想好dp应该怎么附默认值，
     * 第一反应是在j层循环时计算一个最小值，默认为Integer.MAX_VALUE
     * 但是这种情况会导致dp+1越界，因此顺着这个思路又需要对dp做特殊处理，会很混乱
     * 后来看到官解的Arrays.fill(dp, amount + 1); 简直是神来之笔
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        // dp[i] = min(dp[i - coinsX],..., -1) + 1;
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n;j++) {
                if (i - coins[j] > -1) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
