package com.atvris.hot100;

/**
 * @author zjh
 * @date 2025/12/23 18:14
 */
public class FindMin_153 {

    /**
     * 做完33题目后，这道题就很简单
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        // 不用关心旋转了几次，只需要二分找到最小值
        int n = nums.length;
        int left = 0, right = n - 1;
        int min = 5001;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[left] > nums[mid]) {
                right = mid - 1;
            } else {
                if (nums[right] < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return min;
    }
}
