package com.atvris.hot100.other;

/**
 * 只出现一次的数字
 * https://leetcode.cn/problems/single-number/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/25 14:43
 */
public class SingleNumber_136 {

    public int singleNumber(int[] nums) {
        // 通过异或运算得到
        int res = 0;
        for (int i = 0; i < nums.length;i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
