package com.atvris.hot100;

import com.atvris.TreeNode;
import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，
 * 求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * @author zjh
 * @date 2025/12/16 16:34
 */
public class PathSum_437 {

    // 第一反应是区分是否把当前节点加在路径里
    // 如果加进去，后续路径上的节点都得加进去 -> rootSum
    // 如果不加进去，看子任务 -> pathSum
    // 注意targetSum的数据类型为long，避免边界问题
    public  int pathSum(TreeNode root, long targetSum) {
        if(root == null) {
            return 0;
        }

        int res = rootSum(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;

    }

    private  int rootSum(TreeNode root, long targetSum) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        if (root.val == targetSum) {
            res++;
        }
        res += rootSum(root.left, targetSum - root.val);
        res += rootSum(root.right, targetSum - root.val);
        return res;
    }

    /**
     * 前缀和解法
     * 某路径的节点值之和 = curSum（尾节点前缀和） - preSum(头结点前缀和) = targetSum
     * 计算路径的数目就是计算 以每个节点作为尾节点，存在命中上述条件的头结点的个数之和
     * 统计前缀和 出现的次数
      */
    private int pathSumV2(TreeNode root, long targetSum) {
        Map<Long, Integer> matchCurSumCountMap = new HashMap<>();
        return dfs(root, 0, targetSum, matchCurSumCountMap);
    }
    
    private int dfs(TreeNode root, long preSum, long targetSum, Map<Long, Integer> matchCurSumCountMap) {
        if (root == null) {
            return 0;
        }
        long curSum = preSum + root.val;
        int preSumCount = matchCurSumCountMap.getOrDefault(curSum - targetSum, 0);
        matchCurSumCountMap.put(curSum, matchCurSumCountMap.getOrDefault(curSum, 0) + 1);
        preSumCount += dfs(root.left, curSum, targetSum, matchCurSumCountMap);
        preSumCount += dfs(root.right, curSum, targetSum, matchCurSumCountMap);
        matchCurSumCountMap.put(curSum, matchCurSumCountMap.get(curSum) - 1);
        return preSumCount;
    }
    
    
}
