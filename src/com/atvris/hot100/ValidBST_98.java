package com.atvris.hot100;

import com.atvris.TreeNode;

import java.util.Stack;

/**
 * 验证是否为二叉搜索树
 * @author zjh
 * @date 2025/12/14 17:14
 */
public class ValidBST_98 {
    // 二叉搜索树是什么特征？左边小、右边大
    private static boolean isValidBST(TreeNode root) {
        // 注意这里直接用root，没有必要分成left和right去做与操作；
        // 其次题干中限定了值的范围在int范围内，这里上下界用long去避免边界问题
       return isValidBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left,min, root.val)
                && isValidBST(root.right, root.val, max);
    }
    
    // 左边小右边大的特征转化后就是中序遍历递增
    private static boolean isValidBSTByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long tail = Long.MIN_VALUE;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val <= tail) {
                return false;
            }
            tail = root.val;
            root = root.right; // 这一行别写成stack.push(root.right)了，下次循环的时候会执行
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}
