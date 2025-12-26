package com.atvris.hot100.dp;

import java.util.Stack;

/**
 * 有点难，动态规划不太好列出转移方程
 * 最长有效括号
 * https://leetcode.cn/problems/longest-valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/25 10:45
 */
public class LongestValidParentheses_32 {

    /**
     * dp[i] 代表以i为结尾的有效字符串最大长度
     * 如果i位置上是'(' dp[i]肯定匹配无效
     * 否则，如果i-1位置上是'(',刚好i i -1 形成一个有效对 那就是dp[i-2] + 2
     * 否则，i-1位置上是')'，要看i-1对应的左括号的前一个字符是不是'('，从而和i位置匹配上
     * 匹配上之后，还得看下更前一个字符结尾的字符串最大长度，这样可以拼在一起
     * 也就是说j = i - 1 - dp[i - 1],j位置上字符是(则
     *  dp[i] = dp[i - 1] + 2 + dp[j - 1]
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];// 以i为结尾的最长字符串
        int maxLen = 0;
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    int len = dp[i - 1];
                    int j = i - 1 - len;
                    if (j >= 0 && s.charAt(j) == '(') {
                        dp[i] = dp[i - 1] + 2 + (j > 0 ? dp[j - 1] : 0);
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    /**
     * 栈中存储下标
     * 初始压入 -1 作为“基准”
     * 遇到 '('：压入当前下标
     * 遇到 ')'：
     *  弹出栈顶
     *  如果栈空 → 说明这个 ')' 无法匹配，压入当前下标作为新基准
     *  否则 → 当前有效长度 = i - stack.peek()
     * FIXME 这个过程是怎么想到先把一个基准放进去的，很难凭自己想到
     * @param s
     * @return
     */
    public int longestValidParenthesesV2(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int n = s.length();
        int maxLen = 0;
        for (int i = 0; i < n;i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();// 取出栈顶
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    Integer headIdx = stack.peek();
                    maxLen = Math.max(maxLen, i - headIdx);
                }
            }
        }
        return maxLen;
    }

    /**
     * 有效括号必须满足：left == right，且过程中 left >= right（从左到右）。
     * 但像 "(()" 这种，left > right 永远不等，所以需要双向扫描
     * @param s
     * @return
     */
    public int longestValidParenthesesV3(String s) {
        int left = 0, right = 0;
        // 左右括号数量
        int n = s.length();
        int maxLen = 0;
        for (int i = 0; i < n;i++) {
            if(s.charAt(i) == '('){
                left++;
            } else {
                right++;
            }
            if(left < right) {
                left=0;
                right=0;
            } else if(left == right){
                maxLen = Math.max(maxLen, right * 2);
            }
        }
        left = 0; right = 0;
        for (int i = n -1 ; i > 0;i--) {
            if(s.charAt(i) == '('){
                left++;
            } else {
                right++;
            }
            if(left > right) {
                left=0;
                right=0;
            } else if (left == right) {
                maxLen = Math.max(maxLen, right * 2);
            }
        }
        return maxLen;
    }
}
