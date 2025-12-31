package com.atvris.hot100.linkedlist;

import com.atvris.hot100.ListNode;

/**
 * 回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/26 17:17
 */
public class IsPalindrome_234 {

    public boolean isPalindrome(ListNode head) {
        // 第一种是遍历获得数组后双指针
        // 第二种获得长度后判断奇数偶数长度，
        // 前半段加入到栈里，后半段逐个和栈顶元素对比弹出
        // 第三种是快慢指针找到中间，翻转后半部分，再遍历看是否一致，然后再恢复回来
        // 这种关注奇数情况下中点的认定
        ListNode leftTail = findFirstLast(head);
        ListNode rightHead = reverse(leftTail.next);
        ListNode leftp = head;
        ListNode rightp = rightHead;
        boolean result = true;
        while(result && rightp != null) {
            if (leftp.val != rightp.val) {
                result = false;
            }
            leftp = leftp.next;
            rightp = rightp.next;
        }
        reverse(rightHead);
        return result;
    }

    ListNode findFirstLast(ListNode head) {
        ListNode slow = head, fast = head;
        // 奇数情况下 1 + i , 1 + 2i = n;
        // 偶数情况下 1 + j, 1 + 2j = n - 1
        // i = (n - 1)/2, j = n/2-1 fast到末尾时slow到前半部分尾部
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode reverse(ListNode head) {
        // 实际上是头插法
        ListNode cur = head, pre = null;
        while(cur != null) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }
}
