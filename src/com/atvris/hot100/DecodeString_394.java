package com.atvris.hot100;

import java.util.Stack;

/**
 * 解码字符串
 * @author zjh
 * @date 2025/12/24 10:39
 */
public class DecodeString_394 {

    /**
     * AI建议的解法，同样是双栈但不好理解
     * 重点在于strStack里放的是什么，curr是什么含义
     * @param s
     * @return
     */
    public String decodeString(String s) {
        // 需要用栈维护左右括号匹配
        Stack<String> strStack = new Stack<>();// 字符串栈
        Stack<Integer> numStack = new Stack<>(); // 数字栈
        int n = s.length();
        int num = 0;
        StringBuilder curr = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(curr.toString());
                num = 0;
                curr = new StringBuilder();
            } else if (c != ']') {
                curr.append(c);
            } else {
                int t = numStack.pop();
                String prev = strStack.pop();
                StringBuilder re = new StringBuilder();
                for (int j = 0; j < t;j++) {
                    re.append(curr);
                }
                curr = new StringBuilder(prev).append(re);
            }
        }
        return curr.toString();
    }

    /**
     * 个人倾向的更倾向直觉的方法
     * 字符串栈里会放字符和符号，检测到终点时弹出合成新字符
     * @param s
     * @return
     */
    public String decodeStringV2(String s) {
        Stack<String> strStack = new Stack<>();// 字符串栈
        Stack<Integer> numStack = new Stack<>(); // 数字栈
        int n = s.length();
        int i = 0;
        while(i < n) {
            int num = 0;
            char c = s.charAt(i);
            while(c >='0' && c <= '9') {
                num = num * 10 + (c - '0');
                i++;
                c = s.charAt(i);
            }
            if (num > 0) {
                numStack.push(num);
            }
            if (c != ']') {
                strStack.push(c + ""); 
            } else {
                String temp = "";
                // 注意这里字符串对象和字符串常量池中对象==判断可能不一致，用equals
                while(!strStack.peek().equals("[")) {
                    String cc = strStack.pop();
                    temp = cc + temp;
                }
                strStack.pop(); // 弹出[
                Integer count = numStack.pop();
                String re = "";
                for (int j = 0; j < count; j++) {
                    re += temp;
                }
                strStack.push(re);
            }
            i++;
        }
        String str = "";
        while(!strStack.isEmpty()) {
            str = strStack.pop() + str;
        }
        return str;
    }
}
