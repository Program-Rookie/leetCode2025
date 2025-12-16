package com.atvris.hot100;

import com.atvris.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 对称二叉树
 * @author zjh
 * @date 2025/12/9 16:33
 */
public class SymmerTric_101 {

    private boolean isSymmerTric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSame(root.left, root.right);
    }
    
    private boolean isSame(TreeNode left, TreeNode right) {
        // 值不相等或任意一个为null返回false
        if(left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            return isSame(left.left, right.right) && isSame(left.right, right.left);
        }
        return false;
    }
    
    private static boolean isSymmerTricBFSStack(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            stack.push(right.right);
            stack.push(left.left);
            stack.push(right.left);
            stack.push(left.right);
        }
        return true;
    }

    private static boolean isSymmerTricBFSQueue(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()) {
            TreeNode right = queue.poll();
            TreeNode left = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
    
    public static void main(String[] args) {
        
    }
}
