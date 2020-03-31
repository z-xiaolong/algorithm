package leetcode.swordOffer.easy;

import leetcode.entity.ListNode;

/**
 * @Author long
 * @Date 2020/3/6 20:29
 * @Title 面试题25. 合并两个排序的链表
 * @Description //TODO
 **/

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            } else {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            node.next = l1;
            node = node.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            node.next = l2;
            node = node.next;
            l2 = l2.next;
        }
        return head.next;
    }
}
