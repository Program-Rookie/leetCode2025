package com.atvris.hot100;

import com.atvris.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 前序遍历+中序遍历还原二叉树
 * @author zjh
 * @date 2025/12/16 16:05
 */
public class BuildTree_105 {
    // 3 9 20 15 7
    // 9 3 15 20 7
    
    // 3 9 20 null null 15 7
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inIndexMap = new HashMap<>();
        for(int i = 0; i < preorder.length; i++) {
            inIndexMap.put(inorder[i], i);
        }
        int n = preorder.length;
        return myBuildTree(preorder, inorder, 0, n -1, 0, n -1, inIndexMap);

    }

    private static TreeNode myBuildTree(int[] preorder, int[] inorder, int preleft, int preright, int inleft, int inright, Map<Integer, Integer> inIndexMap) {
        if (preleft > preright) {
            return null;
        }
        int rootVal = preorder[preleft];
        TreeNode root = new TreeNode(rootVal);
        // 在中序中的下标
        Integer inIndex = inIndexMap.get(rootVal);
        // 中序左侧长度
        Integer leftLen = inIndex - inleft;
        // preleft + 1, preleft + leftLen
        // inleft, inIndex - 1
        root.left = myBuildTree(preorder, inorder, preleft+1,preleft+leftLen, inleft, inIndex - 1, inIndexMap);
        // preleft+leftLen + 1, preright
        // inIndex + 1, inright
        root.right = myBuildTree(preorder, inorder, preleft+leftLen + 1, preright, inIndex + 1, inright, inIndexMap);
        return root;
    }
    
    // TODO 非递归解法
}
