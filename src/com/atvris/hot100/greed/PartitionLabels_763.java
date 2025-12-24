package com.atvris.hot100.greed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zjh
 * @date 2025/12/24 18:40
 */
public class PartitionLabels_763 {

    /**
     * 重点是分割条件
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        // 每个字符的最后一个下标位置
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < n;i++) {
            Character c = s.charAt(i);
            charMap.put(c, i);
        }
        List<Integer> res = new ArrayList<>();
        int maxRight = 0, left = 0;
        for (int i = 0; i < n; i++) {
            // 看每一段最远到哪里，再分割
            int right = charMap.get(s.charAt(i));
            maxRight = Math.max(maxRight, right);
            // 分割条件
            if (i == maxRight) {
                res.add(i - left + 1);
                maxRight = Math.max(maxRight, right);
                left = i + 1;
            }

        }
        return res;
    }
}
