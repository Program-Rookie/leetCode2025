package com.atvris.hot100.linkedlist;

import com.atvris.hot100.ListNode;

/**
 * 反转链表
 * https://leetcode.cn/problems/reverse-linked-list/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/26 17:24
 */
public class ReverseList_206 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while(cur != null) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }
}
