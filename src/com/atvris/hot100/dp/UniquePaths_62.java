package com.atvris.hot100.dp;

/**
 * 不同路径
 * https://leetcode.cn/problems/unique-paths/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/25 12:56
 */
public class UniquePaths_62 {

    /**
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0 ;i < m;i++) {
            dp[i][0] = 1;
            for(int j = 1; j < n;j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m -1][n -1];
    }
    
    // TODO 组合数学
}
