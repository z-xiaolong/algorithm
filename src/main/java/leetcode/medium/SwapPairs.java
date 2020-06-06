package leetcode.medium;

import leetcode.entity.ListNode;

/**
 * @Author long
 * @Date 2020/3/3 13:33
 * @Title 24. 两两交换链表中的节点
 * @Description 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 **/

public class SwapPairs {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        swapPairs(node1);
    }


    //递归
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode second = swapPairs(head.next.next);
        ListNode next = head.next;
        next.next = head;
        head.next = second;
        return next;
    }

    //迭代
    public static ListNode swapPairsI(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode index = head;
        ListNode next = index.next;
        ListNode pre = h;
        while (index.next != null) {
            index.next = next.next;
            next.next = index;
            pre.next = next;
            pre = index;
            index = index.next;
            if (index == null || index.next == null) {
                return h.next;
            }
            next = index.next;
        }
        return h.next;
    }
}
