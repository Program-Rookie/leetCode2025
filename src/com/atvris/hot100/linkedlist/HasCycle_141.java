package com.atvris.hot100.linkedlist;

import com.atvris.hot100.ListNode;

/**
 * @author zjh
 * @date 2025/12/26 16:45
 */
public class HasCycle_141 {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
