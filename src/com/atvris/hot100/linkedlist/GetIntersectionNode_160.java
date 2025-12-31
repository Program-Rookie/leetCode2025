package com.atvris.hot100.linkedlist;

import com.atvris.hot100.ListNode;

/**
 * @author zjh
 * @date 2025/12/26 17:35
 */
public class GetIntersectionNode_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 走完自己走对方，直到相交
        ListNode temp1 = headA, temp2 = headB;
        // 留意循环条件,有可能是null == null退出，所以不用担心死循环
        while(temp2 != temp1) {
            // 到终点时从另一个链表开始
            if (temp1 == null) {
                temp1 = headB;
            } else {
                temp1 = temp1.next;
            }
            if (temp2 == null) {
                temp2 = headA;
            } else {
                temp2 = temp2.next;
            }
        }
        return temp1;
    }
}
