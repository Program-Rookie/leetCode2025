package com.atvris.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * @author zjh
 * @date 2025/12/23 11:58
 */
public class GenerateParenthesis_22 {

    /**
     * 方法1 暴力解，回溯终止时判断是否有效
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] output = new char[2 * n];
        backtrack(0, 2 * n, output, result);
        return result;
    }

    private void backtrack(int pos, int max, char[] output, List<String> result) {
        if (pos == max) {
            if (valid(output)) {
                result.add(new String(output));
            }
        } else {
            // 刚开始想用StringBuilder，但是发现没办法快速修改
            output[pos] = '(';
            backtrack(pos + 1, max, output, result);
            output[pos] = ')';
            backtrack(pos + 1, max, output, result);
        }
    }

    /**
     * 括号匹配则为true
     * 1.任意前缀中（数量大于等于）数量
     * 2.总的数量一样
     * @param output
     * @return
     */
    private boolean valid (char[] output) {
        int balance = 0;
        for (int i = 0; i < output.length; i++) {
            if (output[i] == '(') {
                balance ++;
            } else {
                balance --;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    /**
     * 方法2 动态回溯，只回溯有效的括号组合
     * @param n
     * @return
     */
    public List<String> generateParenthesisV2(int n) {
        List<String> result = new ArrayList<>();
        int left = 0, right = 0;
        StringBuilder str = new StringBuilder();
        backtrackV2(n, left, right, str, result);
        return result;
    }
    
    private void backtrackV2(int max, int left, int right, StringBuilder str, List<String> result) {
        if (left + right == max * 2) {
            result.add(str.toString());
            return;
        }
        // 目前子串中左右括号一样多，下一个只能是左括号
        if (left == right) {
            str.append('(');
            backtrackV2(max, left + 1, right, str, result);
            str.deleteCharAt(str.length() - 1);
        } else {
            // 左括号多，下一个可左(如果有剩余的话)可右
            if (left < max) {
                str.append('(');
                backtrackV2(max, left + 1, right, str, result);
                str.deleteCharAt(str.length() - 1);
            }
            str.append(')');
            backtrackV2(max, left, right + 1, str, result);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
