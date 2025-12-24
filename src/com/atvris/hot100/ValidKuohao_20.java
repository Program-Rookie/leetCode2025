package com.atvris.hot100;

import java.util.Stack;

/**
 * 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/23 21:01
 */
public class ValidKuohao_20 {
    public boolean isValid(String s) {
        // 用栈，当( [ { 出现时无脑入栈，否则要看栈顶是否匹配
        // 栈顶匹配则出栈，直到最后
        // 如果栈不为空，则括号无效
        Stack<Character> stack = new Stack<>();
        int i = 0, n = s.length();
        while(i < n) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' ||s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                // 留意这个必须得有，因为有些特殊的字符串上来就以右括号开始
                if (stack.isEmpty()) {
                    return false;
                }
                if (s.charAt(i) == ')' && stack.peek() != '(') {
                    return false;
                }
                if (s.charAt(i) == '}' && stack.peek() != '{') {
                    return false;
                }
                if (s.charAt(i) == ']' && stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
            i++;
        }
        return stack.isEmpty();
    }
}
