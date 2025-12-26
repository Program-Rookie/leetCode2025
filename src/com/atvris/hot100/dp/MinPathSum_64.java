package com.atvris.hot100.dp;

/**
 * 最小路径和
 * https://leetcode.cn/problems/minimum-path-sum/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/25 13:09
 */
public class MinPathSum_64 {

    /**
     * 强化可读性
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        // dp[i][j] = Math.min(dp[i - 1][j], dp[i][j-1]) + grid[i][j]
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1;i<m;i++) {
            dp[i][0] = dp[i -1][0] + grid[i][0];
        }
        for (int i = 1; i < n;i++) {
            dp[0][i] = dp[0][i -1] + grid[0][i];
        }
        for (int i =1;i<m;i++) {
            for(int j =1;j < n;j++) {
                dp[i][j] = Math.min(dp[i -1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
