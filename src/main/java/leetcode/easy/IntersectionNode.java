package leetcode.easy;

import leetcode.entity.ListNode;

/**
 * @Author long
 * @Date 21:12 2019/11/9
 * @Title 160. 相交链表
 * @Description 编写一个程序，找到两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 **/

public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode heada, ListNode headB) {
        ListNode intersectionNode = null;
        int lengthA = getLength(heada);
        int lengthB = getLength(headB);
        if (lengthA > lengthB) {
            while (lengthA != lengthB) {
                heada = heada.next;
                lengthA--;
            }
        } else {
            while (lengthA != lengthB) {
                headB = headB.next;
                lengthB--;
            }
        }
        while (heada != null && headB != null && heada != headB) {
            heada = heada.next;
            headB = headB.next;
        }
        intersectionNode = heada;
        return intersectionNode;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
