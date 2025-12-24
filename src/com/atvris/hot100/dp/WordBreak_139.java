package com.atvris.hot100.dp;

import java.util.List;

/**
 * 单词拆分
 * @author zjh
 * @date 2025/12/24 21:51
 */
public class WordBreak_139 {

    /**
     * 这里是首次自己写的版本，这里可以优化不去循环wordDict，不改是为了方便以后回顾
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] |= dp[i - wordDict.length()] && s.substring() == wordDict
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 1; i <= n;i++) {
            for(String word : wordDict) {
                if (i >= word.length()) {
                    dp[i] |= dp[i - word.length()] && s.substring(i-word.length(), i).equals(word);
                }
            }
        }
        return dp[n];
    }
}
