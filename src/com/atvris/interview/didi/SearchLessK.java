package com.atvris.interview.didi;

/**
 * 二分查找小于指定值的最大数
 * @author zjh
 * @date 2025/12/31 14:49
 */
public class SearchLessK {
    
    private int searchLessK(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int left = 0, right = n - 1;
        // [ 0, 1, 2]  2
        // [ 0, 1, 2, 3] 2
        while(left < right) {
            int mid = left + (right - left + 1)/2; // 避免死循环 
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        // 判断最终返回的 left 对应的元素是否真的小于 target
        return nums[left] < target ? left : -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 2};
        int target = 2;
        System.out.println(new SearchLessK().searchLessK(nums,target));
        nums = new int[] {0, 1, 2, 3};
        System.out.println(new SearchLessK().searchLessK(nums, target));
    }
}
