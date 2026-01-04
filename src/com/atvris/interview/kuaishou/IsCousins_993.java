package com.atvris.interview.kuaishou;

import com.atvris.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * x y 是否是堂兄弟节点
 * @author zjh
 * @date 2025/12/31 16:13
 */
public class IsCousins_993 {

    /**
     * 堂兄弟需要满足的条件：
     * 1.在同一层上
     * 2.父节点不是同一个
     * @param root
     * @param x
     * @param y
     * @return
     */
    
    
    public boolean isCousins(TreeNode root, int x, int y) {
        // 层序遍历+hash
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Map<Integer, TreeNode> xyMap = new HashMap<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean matchX = false;
            boolean matchY = false;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val == x) {
                    matchX = true;
                }
                if (node.val == y) {
                    matchY = true;
                }
                if (matchX && matchY && xyMap.get(x) != xyMap.get(y)) {
                    return true;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.left.val == x) {
                        xyMap.put(x, node);
                    }
                    if (node.left.val == y) {
                        xyMap.put(y, node);
                    }
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    if (node.right.val == x) {
                        xyMap.put(x, node);
                    }
                    if (node.right.val == y) {
                        xyMap.put(y, node);
                    }
                }
            }
        }
        return false;
    }
}
