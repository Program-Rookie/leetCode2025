package com.atvris.hot100;

import com.atvris.TreeNode;

import java.util.*;

/**
 * 二叉树的右视图
 * @author zjh
 * @date 2025/12/15 20:45
 */
public class RightSideView_199 {

    public  List<Integer> rightSideView(TreeNode root) {
        // 每一层上最后一个节点
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }
    
    private  List<Integer> rightSizeViewDFS(TreeNode root) {
        // 深度优先遍历时，优先遍历右子树，当遍历到第一个该层元素时认为是目标元素之一
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }
    
    private  void dfs(TreeNode root, List<Integer> result, int level) {
        if (root == null) {
            return;
        }
        if (result.size() < level + 1) {
            result.add(root.val);
        }
        dfs(root.right, result, level + 1);
        dfs(root.left, result, level + 1);
    }
    
     class Node {
        private TreeNode node;
        private int depth;
        
        public Node(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    
    private  List<Integer> rightSideViewByStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(root, 1));
        int maxDepth = 0;
        while(!stack.isEmpty()) {
            Node pop = stack.pop();
            // 重点是不知道遍历到哪的时候到了第几层，是不是这层的第一个，所以node维护层深
            if (maxDepth < pop.depth) {
                result.add(pop.node.val);
                maxDepth++;
            }
            if (pop.node.left != null) {
                stack.push(new Node(pop.node.left, pop.depth + 1));
            }
            if (pop.node.right != null) {
                stack.push(new Node(pop.node.right, pop.depth + 1));
            }
        }
        return result;
    }
    
    public  void main(String[] args) {
        
    }
}
