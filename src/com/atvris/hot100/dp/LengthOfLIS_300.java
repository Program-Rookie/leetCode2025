package com.atvris.hot100.dp;

/**
 * 最长递增子序列
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/24 22:06
 */
public class LengthOfLIS_300 {

    /**
     * 之前做的动态规划题目都是以长度下标作为状态变量的
     * 这是头一个以结果集中最后一个元素下标作为状态变量
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        // dp[i] = max(dp[j]) + 1 // 以i j为最后一个元素
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i;j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
