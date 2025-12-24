package com.atvris.hot100;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 数组中的第K个最大元素
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/24 14:25
 */
public class FindKthLargest_215 {

    /**
     * 本人的直觉解法，但其实写的时候也知道用了优先队列就意味着偷懒了，只是想不到其他算法
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i = 0; i < nums.length;i++) {
            queue.offer(nums[i]);
        }
        int r = 0;
        for(int i = 0; i< k;i++) {
            r = queue.poll();
        }
        return r;
    }


    private Random random = new Random();

    /**
     * 方法二是AI辅导写出来的
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestV2(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k); // 目标索引 = n - k
    }

    private int quickSelect(int[] arr, int left, int right, int kIndex) {
        if (left == right) {
            return arr[left];
        }

        // 随机选择 pivot 并移到末尾
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(arr, randomIndex, right);

        // 分区，获得 pivot 的最终位置
        int pivotIndex = partition(arr, left, right);

        if (pivotIndex == kIndex) {
            return arr[pivotIndex];
        } else if (pivotIndex > kIndex) {
            return quickSelect(arr, left, pivotIndex - 1, kIndex);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, kIndex);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {// 不做等于判断可以在大量重复数值时减少操作
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
