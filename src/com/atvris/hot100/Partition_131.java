package com.atvris.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 分割回文串
 * @author zjh
 * @date 2025/12/23 15:08
 */
public class Partition_131 {

    List<List<String>> result = new ArrayList<>();
    List<String> output = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(0, s);
        return result;
    }

    /**
     * 解法1，回溯过程中判断i-j是否是回文串
     * @param i
     * @param s
     */
    private void dfs(int i, String s) {
        if (i == s.length()) {
            result.add(new ArrayList<>(output));
            return;
        }
        for (int j = i; j < s.length();j++) {
            if(isPartition(i, j, s)) {
                output.add(s.substring(i, j + 1));
                dfs(j + 1, s);
                output.remove(output.size() - 1);
            }
        }
    }

    private boolean isPartition(int i, int j, String s) {
        while(i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 在解法1的基础上增加数组维护是否回文串
     * p[i][j] = p[i + 1][j - 1]
     * @param s
     * @return
     */
    public List<List<String>> partitionV2(String s) {
        int n = s.length();
        boolean[][] p = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            // 对于j=i+1的情况，p[i+1][i]是一个无效的，要赋值为true方便循环计算
            Arrays.fill(p[i], true); 
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 这里对于i+1 > j-1即i+2>j的情况，可以单独判断，也可以不做调整，让上面Array.fill处理
                p[i][j] = p[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        dfsV2(0, s, p);
        return result;
    }

    private void dfsV2(int i, String s, boolean[][] p) {
        if (i == s.length()) {
            result.add(new ArrayList<>(output));
            return;
        }
        for (int j = i; j < s.length();j++) {
            if(p[i][j]) {
                output.add(s.substring(i, j + 1));
                dfs(j + 1, s);
                output.remove(output.size() - 1);
            }
        }
    }

}
