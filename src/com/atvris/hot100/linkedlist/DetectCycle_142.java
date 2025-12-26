package com.atvris.hot100.linkedlist;

import com.atvris.hot100.ListNode;

/**
 * 环形链表 II
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/26 16:43
 */
public class DetectCycle_142 {

    public ListNode detectCycle(ListNode head) {
        // a b c
        // 2(a + b) = (a + b) + n(b + c)
        // a + b = nb + nc
        // a = (n-1)(b+c) + c
        // 先让快慢指针相遇
        if (head == null || head.next == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0, head);
        ListNode slow = dummyHead, fast = dummyHead;
        while(fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                // 相遇时一个新指针从开头开始
                ListNode np = dummyHead;
                while(np != slow) {
                    np = np.next;
                    slow = slow.next;
                }
                return np;
            }
        }

        return null;
    }
}
