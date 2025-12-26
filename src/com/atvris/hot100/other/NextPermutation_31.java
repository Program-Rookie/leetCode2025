package com.atvris.hot100.other;

/**
 * @author zjh
 * @date 2025/12/25 15:47
 */
public class NextPermutation_31 {

    public void nextPermutation(int[] nums) {
        // 找到右侧第一个变小的数x
        // 找到右侧第一个比x大的数y
        // 交换x，y。x所在下标右侧是递减的，翻转一下
        int n = nums.length;

        int i = n - 2;
        // 这里两个>=需要注意
        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            reverse(nums, 0, n);
            return;
        }
        int j = n - 1;
        // 这里第一个条件和两个>=需要注意
        while(j >= 0 && nums[j] <= nums[i]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i + 1, n);
    }

    private void reverse(int[] nums, int start, int end) {
        int i = start, j = end - 1;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
