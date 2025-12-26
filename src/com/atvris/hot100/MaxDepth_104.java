package com.atvris.hot100;

import com.atvris.TreeNode;

import java.util.*;

/**
 * 树的最大深度
 * @author zjh
 * @date 2025/12/9 16:04
 */
public class MaxDepth_104 {
    
    private  int maxDepthBFS(TreeNode root) {
        // dfs
        if (root == null) {
            return 0;
        }
        // 强依赖自底向上。你无法在不知道子树深度的情况下计算当前深度。（后序写法）
        return Math.max(maxDepthBFS(root.left), maxDepthBFS(root.right)) + 1;
    }
    
    private  int maxDepthBFSQueue(TreeNode root) {
        // 层序遍历
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            level++;
        }
        return level;
    }
    
    private  int maxDepthBFSStack(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int depth = 0;
        while(!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = stack.pop();
                if (pop.left != null) {
                    stack.push(pop.left);
                }
                if (pop.right != null) {
                    stack.push(pop.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        new TreeNode();
    }
}
