package com.atvris.hot100;

import com.atvris.TreeNode;

/**
 * 数组转平衡二叉搜索树
 * @author zjh
 * @date 2025/12/14 16:48
 */
public class SortedArrayToBST_108 {

    public  TreeNode sortedArrayToBST(int[] nums) {
        // 中序遍历已经有了，并没有说是唯一的，选中间元素作为根节点
        int left = 0, right = nums.length - 1;
        return toBST(nums, left, right);
    }

    private  TreeNode toBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums, left, mid - 1);
        root.right = toBST(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-10,-3,0, 5, 9};
        System.out.println(new SortedArrayToBST_108().sortedArrayToBST(nums));
    }
}
