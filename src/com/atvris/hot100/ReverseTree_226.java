package com.atvris.hot100;

import com.atvris.TreeNode;

import java.util.Stack;

/**
 * 翻转二叉树
 * @author zjh
 * @date 2025/12/9 16:20
 */
public class ReverseTree_226 {

    private static TreeNode reverseTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 交换左右子树，弱依赖，自顶向下处理逻辑（前序写法）
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        reverseTree(root.left);
        reverseTree(root.right);
        return root;
    }
    
    private static TreeNode reverseTreeByStack(TreeNode root) {
        // 前序遍历翻转
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right); // 实际是左
            }
        }
        return root;
    }
    
    public static void main(String[] args) {
        
    }
}
