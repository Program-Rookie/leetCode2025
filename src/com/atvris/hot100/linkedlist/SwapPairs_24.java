package com.atvris.hot100.linkedlist;

import com.atvris.hot100.ListNode;

/**
 * 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/26 15:59
 */
public class SwapPairs_24 {

    /**
     * 重点是连接条件
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        //
        if (head == null || head.next == null) {
            return head;
        }
        // pre cur
        // 当扫到cur时，要交换cur和cur.next，把pre.next连接到cur.next
        // cur连接到原cur.next.next
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy, cur = dummy.next;
        while(cur != null && cur.next != null) {
            // 被交换的节点
            ListNode next = cur.next;

            pre.next = next; // 连第一个
            cur.next = next.next; // 连下一个
            next.next = cur; // 连中间

            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
