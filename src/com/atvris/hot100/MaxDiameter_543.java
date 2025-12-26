package com.atvris.hot100;

import com.atvris.TreeNode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 二叉树的直径 - 路径上的边数
 * @author zjh
 * @date 2025/12/9 16:50
 */
public class MaxDiameter_543 {
    
    // node 左子树最大深度L，右子树R
    // node为拐点的路径长度=L+R
    // 二叉树的直径=所有节点的L+R的最大值
    
    
    /**
     * max(左子树深度+右子树深度)
     * @param root
     * @return
     */
    private  int diameter = 0;
    private  int maxDiameter(TreeNode root) {
        maxDepth(root);
        return diameter;
    }
    
    private  int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1; // 注意这里是+1
    }

    /**
     * 后序遍历实现
     * @param root
     * @return
     */
    private  int maxDiameterTraversal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        HashMap<TreeNode, Integer> depthMap = new HashMap<>();
        while(!stack.isEmpty()) {
            TreeNode node = stack.peek(); // 不要pop因为后续还要输出
            if (node.right != null && !depthMap.containsKey(node.right)) {
                stack.push(node.right);
            } else if (node.left != null && !depthMap.containsKey(node.left)) {
                stack.push(node.left);
            } else {
                TreeNode pop = stack.pop();
                Integer leftDepth = depthMap.getOrDefault(pop.left, 0);
                Integer rightDepth = depthMap.getOrDefault(pop.left, 0);
                depthMap.put(node, Math.max(leftDepth, rightDepth));
                diameter = Math.max(leftDepth + rightDepth, diameter);
            }
        }
        return diameter;
    }
    

    public  void main(String[] args) {
        
    }
}
