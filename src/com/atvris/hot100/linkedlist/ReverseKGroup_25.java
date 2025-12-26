package com.atvris.hot100.linkedlist;

import com.atvris.hot100.ListNode;

/**
 * @author zjh
 * @date 2025/12/26 12:02
 */
public class ReverseKGroup_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // 创建 dummy 节点，方便处理头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy; // prev 指向当前组的前一个节点

        while (prev != null) {
            // step 1: 检查后面是否有 k 个节点
            ListNode tail = prev;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next; // 不足 k 个，直接返回
                }
            }

            // step 2: 记录下一组的开始（翻转后要连接）
            ListNode nextGroup = tail.next;

            // step 3: 翻转 prev.next 到 tail 这 k 个节点
            ListNode[] reversed = reverseRange(prev.next, tail);
            ListNode newHead = reversed[0]; // 翻转后的头
            ListNode newTail = reversed[1]; // 翻转后的尾

            // step 4: 连接三段：prev → newHead ... newTail → nextGroup
            prev.next = newHead;
            newTail.next = nextGroup;

            // step 5: 移动 prev 到当前组的尾部（即 newTail），准备处理下一组
            prev = newTail;
        }

        return dummy.next;
    }

    // 翻转从 start 到 end 的子链表（闭区间），返回 [newHead, newTail]
    private ListNode[] reverseRange(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode curr = start;
        ListNode endNext = end.next; // 保存 end 的下一个，防止断链

        while (curr != endNext) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 翻转后，start 变成尾，end 变成头
        return new ListNode[]{end, start};
    }
}
