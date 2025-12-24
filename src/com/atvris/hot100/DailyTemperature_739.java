package com.atvris.hot100;

import java.util.Stack;

/**
 * 每日温度
 * https://leetcode.cn/problems/daily-temperatures/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/24 11:21
 */
public class DailyTemperature_739 {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> idxStack = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i ++) {
            if (idxStack.isEmpty()) {
                idxStack.push(i);
            } else {
                while (!idxStack.isEmpty() && temperatures[idxStack.peek()] < temperatures[i]) {
                    Integer idx = idxStack.pop();
                    res[idx] = i - idx;
                }
                idxStack.push(i);
            }
        }
        return res;
    }
}
