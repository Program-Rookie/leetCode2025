package com.atvris.hot100.binarysearch;

/**
 * 二分法，专注于这两种写法即可
 * @author zjh
 * @date 2025/12/23 16:21
 */
public class SearchInsert_35 {

    public int searchInsert(int[] nums, int target) {
        // 注意插入的位置[)可以保证最后为插入的位置
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int searchInsertV2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
