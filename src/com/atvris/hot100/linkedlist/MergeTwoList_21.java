package com.atvris.hot100.linkedlist;

import com.atvris.hot100.ListNode;

/**
 * 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/26 16:22
 */
public class MergeTwoList_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead, temp1 = list1, temp2 = list2;
        while(temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                cur.next = temp1;
                temp1 = temp1.next;
            } else {
                cur.next = temp2;
                temp2 = temp2.next;
            }
            cur = cur.next;
        }
        ListNode temp = temp1 != null ? temp1 : temp2;
        cur.next = temp;
        return dummyHead.next;
    }
}
