package com.atvris.hot100;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前 K 个高频元素
 * https://leetcode.cn/problems/top-k-frequent-elements/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/24 15:42
 */
public class TopKFrequent_347 {

    /**
     * 堆解法
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        // 对于每个比较的对象，需要有其值和统计次数，用int[]最方便
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1]-n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey(), val = entry.getValue();
            if (queue.size() == k) {
                // 满了挤出去一个
                if (queue.peek()[1] < val) {
                    queue.poll();
                    queue.offer(new int[] {num, val});
                }
            } else {
                queue.offer(new int[]{num, val});
            }
        }
        int[] re = new int[k];
        for(int i = 0; i < k;i++) {
            re[i] = queue.poll()[0];
        }
        return re;
    }

    /**
     * TODO 快速排序解法
     */
}
