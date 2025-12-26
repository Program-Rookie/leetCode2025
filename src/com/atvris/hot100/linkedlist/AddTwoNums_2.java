package com.atvris.hot100.linkedlist;

import com.atvris.hot100.ListNode;

/**
 * 两数相加
 * https://leetcode.cn/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/26 16:18
 */
public class AddTwoNums_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 位相加时候看进位是多少
        // 位计算时需要带上上一轮计算后的进位
        // 若其中一个链表先遍历完，另一个链表需要继续计算
        // 如果最后都遍历完了还有进位，需要进位算进去
        int inp = 0;
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while(l1 != null || l2 != null) {
            int add = (l1 == null? 0 :l1.val) + (l2 == null ? 0 :l2.val) + inp;
            cur.next = new ListNode(add % 10);
            cur = cur.next;
            inp = add / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (inp > 0) {
            cur.next = new ListNode(inp);
        }
        return dummyHead.next;
    }
}
