package com.atvris.hot100.dp;

/**
 * 416. 分割等和子集
 * @author zjh
 * @date 2025/12/24 23:06
 */
public class CanPartition_416 {

    /**
     * TODO 有点难 没太看懂为什么倒序遍历
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 如果总和是奇数，无法平分
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // 和为0总是可以

        for (int num : nums) {
            // 倒序遍历，避免重复使用当前 num
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
