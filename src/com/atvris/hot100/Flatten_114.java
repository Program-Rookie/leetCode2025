package com.atvris.hot100;

import com.atvris.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树展开为链表
 * @author zjh
 * @date 2025/12/15 21:07
 */
public class Flatten_114 {
    
    private  void flatten(TreeNode root) {
        // 与先序遍历相同，要求左子树始终为null，右子树指向下一个节点
        // 如果某个节点存在右子树，那它的右子树必然会挂在某个左子树的节点上
        List<TreeNode> treeNodes = new ArrayList<>();
        preorder(root, treeNodes);
        // 这里留意最后一个左右子树都是为空的，不用处理
        for (int i = 0; i < treeNodes.size() - 1; i++) {
            treeNodes.get(i).left = null;
            treeNodes.get(i).right = treeNodes.get(i + 1);
        }
    }
    
    private  void preorder(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        res.add(root);
        preorder(root.left, res);
        preorder(root.right, res);
    }
    
    private  void flattenByStack(TreeNode root) {
        // 这种在先序遍历的基础上需要记住上一次遍历的节点，因为需要让其右子树指向本次遍历的节点
        // 除此之外不需要额外空间，在栈遍历过程中执行操作即可
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode last = null;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
            pop.right = pop.left;
            pop.left = null;
            if (last != null) {
                last.right = pop;
            }
            last = pop;
        }
    }
    
    private  void flattenByCur(TreeNode root) {
        // 要原地修改。在前序遍历过程中，
        // 如果当前节点左子树为空，该节点不需要做展开
        // 否则要将左子树中最后一个访问的节点的右子树指向当前节点右子树的第一个节点
        // 重点是找到左子树中最后一个访问的节点。
        // 这个过程不太能一次性找到，因而是找'被最后访问的位置'
        TreeNode cur = root;
        while(cur != null) {
            if (cur.left != null) {
                TreeNode preNode = cur.left;
                while(preNode.right != null) {
                    preNode = preNode.right;
                }
                preNode.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
    

    public  void main(String[] args) {
        
    }
}
