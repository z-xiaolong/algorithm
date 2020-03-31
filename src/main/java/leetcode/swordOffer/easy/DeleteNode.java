package leetcode.swordOffer.easy;

import leetcode.entity.ListNode;

/**
 * @Author long
 * @Date 2020/3/6 18:00
 * @Title 面试题18. 删除链表的节点
 * @Description //TODO
 **/

public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = head;
        ListNode prev = node;
        while (node != null) {
            if (node.val == val) {
                break;
            }
            prev = node;
            node = node.next;
        }
        if (node == head) {
            return head.next;
        }
        prev.next = node.next;
        node.next = null;
        return head;
    }
}
