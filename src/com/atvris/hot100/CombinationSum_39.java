package com.atvris.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 * @author zjh
 * @date 2025/12/23 11:10
 */
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 遍历过程：当前元素要么被选择，要么跳过,被选择后退出时要从和中去掉
        // 遍历范围：index~n，因为同一元素可以被重复选取
        // 终止条件：满足和为target(也可以在遍历中target变小直到target==0)
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        backtrack(0, 0, candidates, target, result, output);
        return result;
    }
    private void backtrack(int sum, int idx, int[] candidates, int target, List<List<Integer>> result, List<Integer> output) {
        if (sum > target || idx == candidates.length) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(output));
            return;
        }
        backtrack(sum, idx + 1, candidates, target, result, output);
        sum += candidates[idx];
        output.add(candidates[idx]);
        backtrack(sum, idx, candidates, target, result, output);
        output.remove(output.size() - 1);
        sum -= candidates[idx];
    }
}
