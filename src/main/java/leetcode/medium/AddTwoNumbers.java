package leetcode.medium;

import leetcode.entity.ListNode;

/**
 * @Author long
 * @Date 2019/11/29 17:03
 * @Title 2.两数之和
 * @Description 计算链表表示的两数之和
 **/

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode sum = head;
        int carryBit = 0;
        while (l1 != null && l2 != null) {
            head.next = new ListNode((l1.val + l2.val + carryBit) % 10);
            head = head.next;
            carryBit = (l1.val + l2.val + carryBit) > 9 ? 1 : 0;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            head.next = new ListNode((l1.val + carryBit) % 10);
            head = head.next;
            carryBit = (l1.val + carryBit) > 9 ? 1 : 0;
            l1 = l1.next;
        }
        while (l2 != null) {
            head.next = new ListNode((l2.val + carryBit) % 10);
            head = head.next;
            carryBit = (l2.val + carryBit) > 9 ? 1 : 0;
            l2 = l2.next;
        }
        if (carryBit > 0) {
            head.next = new ListNode(carryBit);
        }
        return sum.next;
    }
}
