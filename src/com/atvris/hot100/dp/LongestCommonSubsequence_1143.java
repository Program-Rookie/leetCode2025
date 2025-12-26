package com.atvris.hot100.dp;

/**
 * 最长公共子序列
 * https://leetcode.cn/problems/longest-common-subsequence/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/25 14:22
 */
public class LongestCommonSubsequence_1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j] 代表text1[:i]和text2[:j]的最长公共子序列长度
        // dp[i][j] = dp[i - 1][j - 1] + 1  , text1[i-1] == text2[j-1]   
        // dp[i][j] = max(dp[i - 1][j], dp[i][j-1]), text1[i-1] != text2[j-1]
        // dp[i][0] = 0, dp[0][j] = 0
        int m = text1.length(), n = text2.length();
        // 注意要设置成m+1和n+1，因为dp[i][j]任意一个为空选时都是0
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m;i++) {
            for (int j = 1; j <= n;j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][ j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
