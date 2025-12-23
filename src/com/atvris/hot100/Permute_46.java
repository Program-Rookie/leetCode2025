package com.atvris.hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列 回溯
 * @author zjh
 * @date 2025/12/19 15:53
 */
public class Permute_46 {
    
    // 不懂回溯的情况下有点难
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    private void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        if (first == n) {
            res.add(new ArrayList<Integer>(output)); // copy
            return;
        }

        for (int k = first; k < n; k++) {
            Collections.swap(output, first, k);
            backtrack(n, output, res, first + 1);
            Collections.swap(output, first, k);
        }
    }
}
