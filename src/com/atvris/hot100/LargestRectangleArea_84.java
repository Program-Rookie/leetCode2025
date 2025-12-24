package com.atvris.hot100;

import java.util.Stack;

/**
 * 柱状图中最大的矩形
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/24 11:43
 */
public class LargestRectangleArea_84 {

    /**
     * 这是我想的动态规划优化后方法，优化前超了空间复杂度，优化后超了时间复杂度
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        // 知道min[i][j]就能计算出来
        // min[i][j] = min(min[i][j-1], heights[j])
        int n = heights.length;
        int minHeight = 0;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for(int j = i; j < n;j++) {
                if (i == j) {
                    minHeight = heights[i];
                } else {
                    minHeight = Math.min(minHeight, heights[j]);
                }
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }

    public int largestRectangleAreaV2(int[] heights) {
        // 每个柱子都要当“最矮的”，看能撑多宽。
        // 这样就是找左右边界
        // 左边界用单调递增栈（上一个小于当前柱子的下标）
        // 右边界（向右遍历过程中遍历高度小于当前柱子的下标）
        // 特殊case [1, 1] [2, 4]

        int[] arr = new int[heights.length + 1];
        System.arraycopy(heights, 0, arr, 0, heights.length);
        arr[heights.length] = 0; // 哨兵 真牛逼了

        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // 这也是牛逼
        int n = arr.length;
        int maxArea = 0;
        for (int i = 0; i < n;i++) {
            while(stack.peek() != -1 && arr[i] < arr[stack.peek()]) {
                int idx = stack.pop();
                int height = arr[idx];
                int width =  i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
