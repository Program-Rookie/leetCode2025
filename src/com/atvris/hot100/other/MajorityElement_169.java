package com.atvris.hot100.other;

/**
 * 多数元素
 * https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/25 14:53
 */
public class MajorityElement_169 {

    /**
     * Boyer-Moore 投票算法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for (int i = 0; i < nums.length;i++) {
            if (count == 0) {
                candidate = nums[i];
                count++;
            } else {
                if(candidate == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }
    
    // TODO 众数、哈希、二分众数、随机众数
}
