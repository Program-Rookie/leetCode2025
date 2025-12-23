package com.atvris.hot100;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * @author zjh
 * @date 2025/12/23 17:22
 */
public class SearchRange_34 {

    /**
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int left = lowerSearch(nums, target);
        int right = search(nums, target);
        if (left < nums.length && nums[left] == target) {
            return new int[]{left, right - 1};
        }
        return new int[]{-1, -1};
    }

    private int lowerSearch(int[] nums, int target) {
        // 找到目标值所在位置或所应插入的位置
        int left = 0, right = nums.length -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int search(int[] nums, int target) {
        // 找到目标值所在位置或所应插入的位置
        int left = 0, right = nums.length -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
