package com.atvris.hot100;

import com.atvris.TreeNode;

import java.util.*;

/**
 * 二叉树的公共祖先 LCA
 * @author zjh
 * @date 2025/12/17 15:59
 */
public class LowestCommonAncestor_236 {
    
    private  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 正着找：从根节点开始的路径的最后一个相同的节点
        // 逆着找：从节点到根，路径上第一个相同的祖先
        // 考虑遍历二叉树的时候记住各个节点的父节点，遍历完从p、q开始找父节点
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        dfs(root, parentMap);
        List<TreeNode> pVisitedParent = new ArrayList<>();
        while(p != null) {
            pVisitedParent.add(p);
            p = parentMap.get(p);
        }
        // 如果拜访过对应的父节点，则返回
        while(q != null) {
            if (pVisitedParent.contains(q)) {
                return q;
            }
            q = parentMap.get(q);
        }
        return root;
    }
    private  void dfs(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parentMap.put(root.left, root);
            dfs(root.left, parentMap);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
            dfs(root.right, parentMap);
        }
    }
    
    // 方法2，后序遍历判断p、q在不在当前子树中，如果p在左（右）子树中、q在右（左）子树中，则认为是祖先节点
    private  TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        return postorder(root, p, q);
    }
    
    // 上头了，非得用stack方式解，必须增加visitedmap
    // 然后因为遍历过程中不好区分到底包含q还是p，又增加了个nodeStatusmap
    private  TreeNode postorder(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Boolean> hasVisitedMap = new HashMap<>();
        // 1包含p、2包含q、3 包含p、q
        Map<TreeNode, Integer> nodeStatusMap = new HashMap<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (!hasVisitedMap.containsKey(peek)) {
                hasVisitedMap.put(peek, true);
                if (peek.right != null) {
                    stack.push(peek.right);
                }
                if (peek.left != null) {
                    stack.push(peek.left);
                }
            } else {
                TreeNode pop = stack.pop();
                Integer status = 0;
                if (pop == p) {
                    status |= 1;
                }
                if (pop == q) {
                    status |= 2;
                }
                if (pop.left != null) {
                    status |= nodeStatusMap.get(pop.left);
                }
                if (pop.right != null) {
                    status |= nodeStatusMap.get(pop.right);
                }
                nodeStatusMap.put(pop, status);
                if (status == 3) {
                    return pop;
                }
            }
        }
        return root;
    }

    private  TreeNode ans = null;

    // 这次是递归解法，想想怎么找到p或q
    private  TreeNode lowestCommonAncestorV3(TreeNode root, TreeNode p, TreeNode q) {
        dfsV2(root, p, q);
        return ans;
    }
    // 要避免ans作为参数传进来，java是值传递
    private  boolean dfsV2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lmatch = dfsV2(root.left, p, q);
        boolean rmatch = dfsV2(root.right, p, q);
        if (lmatch && (root == p || root == q)) {
            ans = root;
            return true;
        }
        if (rmatch && (root == p || root == q)) {
            ans = root;
            return true;
        }
        if (lmatch && rmatch) {
            ans = root;
            return true;
        }
        return false;
    }
}
