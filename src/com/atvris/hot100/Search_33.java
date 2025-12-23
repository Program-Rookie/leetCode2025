package com.atvris.hot100;

/**
 * 搜索旋转排序数组
 * [4,5,6,7,0,1,2] target = 0
 * @author zjh
 * @date 2025/12/23 18:03
 */
public class Search_33 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                // 左半部分 [left, mid] 是有序的
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右半部分 [mid, right] 是有序的
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
