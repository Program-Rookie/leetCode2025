package com.atvris.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 课程表
 * @author zjh
 * @date 2025/12/19 15:02
 */
public class CanFinish_207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 有向无环图 转成线性排序 = 拓扑排序
        // 入度，从入度为0的入口开始，每次选中一个节点，对应节点的后续节点入度-1
        // 直到不存在入度为0的节点
        // 因此需要
        // 1.数组记录每个节点的入度，
        // 2.链表记录每个节点链接的下一个节点列表方便减少它们的入度
        // 3.用队列实现入度为0的节点遍历
        // 4.遍历过程中记录拓扑排序节点数量判断是否完整，不完整返回false
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        Queue<Integer> queue = new LinkedList<>();
        int n = prerequisites.length;
        // 初始化，避免空指针
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        // 入度数组、邻接表初始化
        for (int i = 0; i < n; i ++) {
            inDegree[prerequisites[i][0]] += 1;
            List<Integer> link = adjList.get(prerequisites[i][1]);
            link.add(prerequisites[i][0]);
        }
        // 初始入度为空的队列
        for(int i = 0; i < numCourses;i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()) {
            Integer head = queue.poll();
            count++;
            List<Integer> afterList =  adjList.get(head);
            for(int i = 0; i < afterList.size();i++) {
                Integer after = afterList.get(i);
                inDegree[after] -= 1;
                // 邻接表节点如果入度减少到0，可以入队
                if (inDegree[after] == 0) {
                    queue.offer(after);
                }
            }
        }
        if (count == numCourses) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
}
