package com.atvris.hot100.dp;

/**
 * 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/25 13:29
 */
public class LongestPalindrome_5 {

    /**
     * 直觉写出来的中心扩散法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        int startIdx = 0;
        for (int i = 0; i < n;i++) {
            // 以当前元素作为奇数中心
            int left = i, right = i;
            while(left > -1 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int len = right - left - 1;
            if (len > maxLen) {
                startIdx = left + 1;
                maxLen = len;
            }
            // 以当前元素作为偶数中心左边
            left = i; right = i + 1;
            while(left > -1 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            len = right - left - 1;
            if (len > maxLen) {
                startIdx = left + 1;
                maxLen = len;
            }
        }
        // 注意substring的用法是[) startIdx, endIdx
        return s.substring(startIdx, startIdx + maxLen);
    }
    
    public String longestPalindromeV2(String s) {
        // dp[i][j] = dp[i + 1][j - 1] && si == sj; 长度大于2子串
        // dp[i][i+1] = si==si+1                    长度等于2子串
        // dp[i][i] = true
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1, startIdx = 0;
        for(int i = 0; i < n;i++) {
            dp[i][i] = true;
        }
        // !!!!!!怎么遍历可以解决i+1先计算,j-1先计算!!!!!
        for (int j = 1; j < n;j++) {
            for (int i = 0; i < j;i++) {
                if (s.charAt(i)!=s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i > 2) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] && (j - i + 1) > maxLen) {
                    startIdx = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(startIdx, startIdx + maxLen);
    }
    
    // TODO Manacher 算法
}
