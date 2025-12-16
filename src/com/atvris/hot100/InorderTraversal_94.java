package com.atvris.hot100;

import com.atvris.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 * @author zjh
 * @date 2025/12/9 14:05
 */
public class InorderTraversal_94 {

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }
    
    private static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
    
    private static List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 为什么不仅判断stack非空呢？
        // 因为如果左子树遍历完了，根节点出栈，此时要放入右子树，
        // 如果仅判断stack非空右子树则无法遍历
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
    
    static class Node {
        TreeNode node;
        int color;
        
        public Node(TreeNode node, int color) {
            this.node = node;
            this.color = color;
        }
    }
    
    // 第三种方法 颜色标记法
    private static List<Integer> inorderTraversalV3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(root, 1));
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            if (cur.node == null) {
                continue;
            }
            if (cur.color == 1) {
                stack.push(new Node(cur.node.right, 1));
                stack.push(new Node(cur.node, 2));
                stack.push(new Node(cur.node.left, 1));
            } else {
                result.add(cur.node.val);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(inorderTraversalV2(root));
    }
}
