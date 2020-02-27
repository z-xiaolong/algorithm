package leetcode.medium;

import leetcode.entity.ListNode;

/**
 * @Author long
 * @Date 2020/2/12 15:42
 * @Title 19. 删除链表的倒数第N个节点
 * @Description 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 **/

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode quick = head;
        ListNode slow = head;
        while (n > 0) {
            quick = quick.next;
            n--;
        }
        if(quick == null){
            return head.next;
        }
        while (quick.next != null) {
            quick = quick.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
