package com.atvris.hot100.linkedlist;

import com.atvris.hot100.ListNode;

import java.util.PriorityQueue;

/**
 * 合并 K 个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/26 15:05
 */
public class MergeKList_23 {

    /**
     * 最笨的办法
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode temp = lists[0];
        for(int i = 1; i < lists.length; i++) {
            temp = merge(temp, lists[i]);
        }
        return temp;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(head1!= null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 != null) {
            cur.next = head1;
        } else {
            cur.next = head2;
        }
        return dummy.next;
    }

    /**
     * 二分
     * @param lists
     * @return
     */
    public ListNode mergeKListsV2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int n = lists.length;
        ListNode en = merge(0, n-1, lists);
        return en;
    }

    private ListNode merge(int left, int right, ListNode[] lists) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left)/2;
        ListNode leftNode = merge(left, mid, lists);
        ListNode rightNode = merge(mid+1, right, lists);
        return merge(leftNode, rightNode);
    }

    public ListNode mergeKListsV3(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int n = lists.length;
        // 最小堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i <n;i++) {
            if (lists[i] != null)
                queue.offer(lists[i]);
        }
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        while(!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            pre.next = minNode;
            pre = pre.next;
            if (minNode.next != null) {
                queue.offer(minNode.next);
            }
        }
        return dummy.next;
    }
}
