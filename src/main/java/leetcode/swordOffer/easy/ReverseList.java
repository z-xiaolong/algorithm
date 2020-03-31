package leetcode.swordOffer.easy;

import leetcode.entity.ListNode;

/**
 * @Author long
 * @Date 2020/3/6 17:46
 * @Title 面试题24. 反转链表
 * @Description //TODO
 **/

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode next = head.next;
        while (next != null) {
            ListNode node = next.next;
            next.next = pre;
            pre = next;
            next = node;
        }
        head.next = null;
        return pre;
    }
}
