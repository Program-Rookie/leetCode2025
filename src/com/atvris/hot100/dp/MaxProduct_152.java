package com.atvris.hot100.dp;

/**
 * @author zjh
 * @date 2025/12/24 22:19
 */
public class MaxProduct_152 {

    /**
     * 最开始的写法，有很大问题，因为：
     * 当前位置的最优解未必是由前一个位置的最优解转移得到的。
     * 比如 [-2, 3, -4]
     */
    @Deprecated
    public int maxProduct(int[] nums) {
        // 以i为结尾的连续子数组乘积要么是具备增大条件的，要么是只有它自己
        // dp[i] = max(nums[i] * dp[i - 1], nums[i]);
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < n;i++) {
            int multi = nums[i] * dp[i - 1];
            dp[i] = multi > dp[i - 1] ? multi : nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 这道题目的启发是状态转移方程不一定只有一个
     * @param nums
     * @return
     */
    public int maxProductV2(int[] nums) {
        // 因为负数×负数可能变成更大的值（相比正数*正数），
        // 所以最小乘积也要记录
        // 状态转移方程:
        // nums[i]
        // maxDp[i] = max(nums[i] * maxDp[i - 1], nums[i] * minDp[i - 1], nums[i])
        // minDp[i] = min(nums[i] * maxDp[i - 1], nums[i] * minDp[i - 1], nums[i])
        int n = nums.length;
        int[] maxDp = new int[n];
        int[] minDp = new int[n];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int ans = maxDp[0];
        for (int i = 1; i < n; i++) {
            int maxDpNew = nums[i] * maxDp[i - 1];
            int minDpNew = nums[i] * minDp[i - 1];
            maxDp[i] = Math.max(Math.max(maxDpNew, minDpNew), nums[i]);
            minDp[i] = Math.min(Math.min(maxDpNew, minDpNew), nums[i]);
            ans = Math.max(Math.max(maxDp[i], minDp[i]), ans);
        }
        return ans;
    }
}
