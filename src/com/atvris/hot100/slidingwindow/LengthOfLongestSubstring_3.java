package com.atvris.hot100.slidingwindow;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/31 15:08
 */
public class LengthOfLongestSubstring_3 {

    /**
     * 时间复杂度O(n) 空间复杂度O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口+hash
        Deque<Character> deque = new LinkedList<>();
        Map<Character,Integer> charMap = new HashMap<>();
        int n = s.length();
        int maxLen = 0;
        for(int i = 0; i < n;i++) {
            char c = s.charAt(i);
            if (charMap.containsKey(c)) {
                while(deque.peek() != c) {
                    Character dc = deque.poll();
                    charMap.remove(dc); // 要把这之前放在map里的清掉
                }
                deque.poll();
            }
            charMap.put(c, i);
            deque.offer(c);
            maxLen = Math.max(maxLen, deque.size());
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(new LengthOfLongestSubstring_3().lengthOfLongestSubstring(s));
    }
}
