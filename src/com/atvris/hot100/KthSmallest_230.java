package com.atvris.hot100;

import com.atvris.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树中第K小的元素
 * @author zjh
 * @date 2025/12/14 17:43
 */
public class KthSmallest_230 {

    private static int kthSmallest(TreeNode root, int k) {
        // 中序遍历中的第K个元素，还原出中序遍历即可
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res.get(k - 1); // 下标对应k -1
    }
    
    private static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    private static int kthSmallestByStack(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            i++;
            if (i == k) {
                return root.val;
            }
            root = root.right;
        }
        return 0;
    }
    
    // TODO AVL方式
    
    public static void main(String[] args) {
        
    }
}
