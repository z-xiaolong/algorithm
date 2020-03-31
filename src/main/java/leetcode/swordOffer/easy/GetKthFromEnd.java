package leetcode.swordOffer.easy;

import leetcode.entity.ListNode;

/**
 * @Author long
 * @Date 2020/3/6 20:22
 * @Title 面试题22. 链表中倒数第k个节点
 * @Description //TODO
 **/

public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
