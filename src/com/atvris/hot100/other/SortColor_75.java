package com.atvris.hot100.other;

/**
 * @author zjh
 * @date 2025/12/25 15:14
 */
public class SortColor_75 {

    public void sortColors(int[] nums) {
        int n = nums.length;
        int redIdx = 0, blueIdx = n - 1;
        // 红、蓝
        int i = 0;
        while (i <= blueIdx) {
            if (nums[i] == 2) {
                swap(nums, i, blueIdx);
                blueIdx--;
            } else if(nums[i] == 0) {
                swap(nums, i, redIdx);
                redIdx++;
                i++;
            } else {
                i++;
            }
        }
        for(int j = redIdx; j<= blueIdx;j++) {
            nums[j] = 1;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
