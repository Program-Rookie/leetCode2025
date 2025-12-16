package com.atvris;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjh
 * @date 2025/12/9 14:06
 */
public class TreeNode {
    
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {
        
    }
    public TreeNode(int val) {
        this.val = val;
    }
    
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preO(root, res);
        return res;
    }
    private void preO(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preO(root.left, res);
        preO(root.right, res);
    }
    
    @Override
    public String toString() {
        return preOrder(this).toString();
    }
}
