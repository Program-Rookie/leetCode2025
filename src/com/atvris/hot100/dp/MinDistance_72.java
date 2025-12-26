package com.atvris.hot100.dp;

/**
 * 编辑距离
 * https://leetcode.cn/problems/edit-distance/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/25 14:38
 */
public class MinDistance_72 {

    /**
     * dp[i][j]代表把word1的前i个字符转换成word2的前j个字符所需要的最小操作数
     * 替换、插入、删除
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        // dp[i][j] = dp[i -1][j -1] , word1[i -1] = word2[j-1]
        // dp[i][j] = min(dp[i -1][j] + 1, dp[i][j -1] + 1,dp[i -1][j -1] + 1)
        // dp[0][j] = j, dp[i][0] = i
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m;i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <=n;j++) {
            dp[0][j] = j;
        }
        for(int i = 1; i <= m;i++) {
            for (int j = 1; j <= n;j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i -1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1), dp[i-1][j-1]+1);
                }
            }
        }
        return dp[m][n];
    }
}
