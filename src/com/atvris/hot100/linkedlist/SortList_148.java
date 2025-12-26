package com.atvris.hot100.linkedlist;

import com.atvris.hot100.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 排序链表
 * https://leetcode.cn/problems/sort-list/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/26 14:27
 */
public class SortList_148 {

    /**
     * 转数组排序后转链表
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        List<Integer> ls = new ArrayList<>();
        ListNode cur = head;
        while(cur != null) {
            ls.add(cur.val);
            cur = cur.next;
        }
        Collections.sort(ls);
        ListNode dummy = new ListNode();
        cur = dummy;
        for(Integer item:ls) {
            cur.next = new ListNode(item);
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 归并排序
     */
    public ListNode sortListV2(ListNode head) {
        // 边界退出
        if (head == null) return head;
        // 自下向上归并
        // 计算长度n
        ListNode cur = head;
        int n = 0;
        while(cur != null) {
            n++;
            cur = cur.next;
        }
        // 按长度1 2 4...n/2归并
        ListNode dummyHead = new ListNode(0, head);
        for(int len = 1; len < n;len<<=1) {
            // 注意别写成cur = head;pre=new ListNode();
            cur = dummyHead.next; ListNode pre = dummyHead;
            while(cur != null) {
                // 分割得到子部分
                ListNode head1 = cur;
                for(int i = 1;i<len && cur.next != null;i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next; // 到底是cur还是cur.next想一想
                cur.next = null; // 断链接
                cur = head2;
                for(int i = 1; i<len &&cur != null && cur.next != null;i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                // 两两合并子部分
                ListNode newHead = merge(head1, head2);
                // 头尾部链接
                pre.next = newHead;
                ListNode newTail = findLast(newHead);
                // newTail.next = next;
                cur = next;
                pre = newTail;
            }
        }
        return dummyHead.next;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode temp1 = head1, temp2 = head2, cur = dummy;
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
        if (temp1 != null) {
            cur.next = temp1;
        } else if (temp2 != null) {
            cur.next = temp2;
        }
        return dummy.next;
    }

    private ListNode findLast(ListNode node) {
        ListNode temp = node;
        while(temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
}
