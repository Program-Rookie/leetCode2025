package com.atvris.hot100.greed;

/**
 * @author zjh
 * @date 2025/12/24 17:25
 */
public class MaxProfit_121 {

    public int maxProfit(int[] prices) {
        // 每个位置上出售的获利= prices[i] - minLeft
        int max = 0;
        int minLeft = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] - minLeft);
            minLeft = Math.min(minLeft, prices[i]);
        }
        return max;
    }
}
