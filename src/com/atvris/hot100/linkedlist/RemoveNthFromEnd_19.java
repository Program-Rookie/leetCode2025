package com.atvris.hot100.linkedlist;

import com.atvris.hot100.ListNode;

/**
 * 删除链表的倒数第 N 个结点
 * @author zjh
 * @date 2025/12/26 16:00
 */
public class RemoveNthFromEnd_19 {
    
    // 第一种办法遍历一遍获得长度N，倒数第n个节点即下标为N-n的位置，不写了

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 双指针 找到倒数第n+1个节点，把下一个节点删除
        // 右指针先走n+1步
        ListNode dummyHead = new ListNode(0, head);
        ListNode cur = dummyHead;
        for(int i = 0; i < n + 1; i++) {
            cur = cur.next;
        }
        ListNode left = dummyHead;
        while(cur !=null) {
            left = left.next;
            cur = cur.next;
        }
        left.next = left.next.next;
        return dummyHead.next;
    }
}
