package leetcode.hard;

import leetcode.entity.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author long
 * @Date 2020/4/26 9:52
 * @Title 23. 合并K个排序链表
 * @Description //TODO
 **/

public class MergeKLists {

    public static void main(String[] args) {
        System.out.println(5 >>> 1);
    }

    //执行用时 :8 ms, 在所有 Java 提交中击败了44.66%的用户
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        ListNode temp = head;
        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            temp.next = min;
            temp = temp.next;
            if (min.next != null) queue.add(min.next);
        }
        temp.next = null;
        return head.next;
    }

    //暴力法：执行用时 :9 ms, 在所有 Java 提交中击败了41.89%的用户
    public ListNode mergeKListsI(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }
        ListNode temp = head;
        while (!queue.isEmpty()) {
            temp.next = queue.poll();
            temp = temp.next;
        }
        temp.next = null;
        return head.next;
    }
}
