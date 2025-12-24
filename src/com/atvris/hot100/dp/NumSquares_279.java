package com.atvris.hot100.dp;

/**
 * 完全平方数
 * https://leetcode.cn/problems/perfect-squares/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/24 21:20
 */
public class NumSquares_279 {
    /**
     * 这是我第一直觉写出来的，还有优化空间
     * 1.合并两个判断
     * 2.不使用Math
     * @param n
     * @return
     */
    public int numSquares(int n) {
        // 1 如果自己是一个完全平方数
        // 否则 dp[n - x2] + 1
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            int t = (int) Math.sqrt(i);
            if (Math.pow(t, 2) == i) {
                dp[i] = 1;
            } else {
                Integer dpi = Integer.MAX_VALUE;
                for(int j = t; j > 0;j--) {
                    dpi = Math.min(dpi, dp[i - (int) Math.pow(j, 2)] + 1);
                }
                dp[i] = dpi;
            }
        }
        return dp[n];
    }
}
