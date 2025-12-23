package com.atvris.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集 回溯
 * @author zjh
 * @date 2025/12/23 10:27
 */
public class Subsets_78 {

    /**
     * 位运算解法
     * 长度为n的数组，其子集的总个数为2的n次方-1（组合Cn1+Cn2+...Cnn）
     * 同时，如果将每个位置看做单独的二进制位，则每个元素有唯一的二进制位，
     * 每个组合都有唯一对应的二进制编码
     * 如 [1,2,3]
     * 1 001    2 010   [1,2] 011   3 100   [1,3] 101   [2,3] 110   [1,2,3] 111
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int n = nums.length;
//        int mask = (int) Math.pow(2, n) - 1; // 第一反应
        int mask = 1 << n - 1;
        // 根据二进制编码递增遍历，找到每个编码对应的组合
        for (int i = 0; i <= mask; i++) {
            // 清理掉上一轮新增的
            output.clear();
            for ( int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    output.add(nums[j]);
                }
            }
            result.add(new ArrayList<>(output));
        }
        return result;
    }

    /**
     * 递归法 - 学了全排列46之后这个方法很容易写出来
     * 但需要重点理解：
     * 1.带当前元素与不带当前元素
     * 2.带当前元素时，回溯回来后如何删除之前加进去的元素
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsV2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int n = nums.length;
        backtrack(0, nums, n, output, result);
        return result;
    }
    private void backtrack(int first, int[] nums, int n, List<Integer> output, List<List<Integer>> result) {
        if (first == n) {
            result.add(new ArrayList<>(output));
            return;
        }
        // 带自己的
        output.add(nums[first]);
        backtrack(first + 1, nums, n, output, result);
        // 
        output.remove(output.size() - 1);
        // 不带自己的
        backtrack(first + 1, nums, n, output, result);
    }
}
