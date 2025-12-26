package com.atvris.hot100;

import com.atvris.TreeNode;

/**
 * 二叉树中的最大路径和
 * @author zjh
 * @date 2025/12/17 17:07
 */
public class MaxPathSum_124 {

    private  int maxSum = 0;
    public  int maxPathSum(TreeNode root) {
        // 讲贡献
        maxGain(root);
        return maxSum;
    }

    private  int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左右子树贡献
        int leftMaxGain = Math.max(maxGain(root.left), 0);
        int rightMaxGain = Math.max(maxGain(root.right), 0);
        // 最大贡献（当前节点可能作为路径中的一个节点）
        int curMaxGain = root.val + leftMaxGain + rightMaxGain;
        maxSum = Math.max(curMaxGain, maxSum);
        // 当前节点作为路径一端的贡献
        return root.val + Math.max(leftMaxGain, rightMaxGain);
    }
}
