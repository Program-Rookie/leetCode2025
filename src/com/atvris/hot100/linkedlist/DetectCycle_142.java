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
        // 边界条件：链表为空或只有一个节点，无环
        if (head == null || head.next == null) {
            return null;
        }

        // 阶段1：快慢指针从头节点出发，判断是否有环并相遇
        ListNode slow = head;
        ListNode fast = head;
        // 优化外层循环条件：同时判断fast和fast.next，避免空指针
        while (fast != null && fast.next != null) {
            slow = slow.next; // 慢指针走1步
            fast = fast.next.next; // 快指针走2步

            // 快慢指针相遇，说明有环，跳出循环进入阶段2
            if (slow == fast) {
                break;
            }
        }

        // 补充判断：若循环结束是因为fast或fast.next为null，说明无环
        if (fast == null || fast.next == null) {
            return null;
        }

        // 阶段2：重置慢指针（或新指针）到头节点，快慢指针以1步/次移动，找环起点
        ListNode np = head; // 新指针从头节点出发
        while (np != slow) {
            np = np.next;
            slow = slow.next;
        }

        // 相遇节点即为环起点
        return np;
    }
}
