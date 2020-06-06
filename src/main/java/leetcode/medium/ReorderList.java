package leetcode.medium;

import leetcode.entity.ListNode;

import java.util.Stack;

/**
 * @Author long
 * @Date 2020/5/16 10:47
 * @Title 143. 重排链表
 * @Description //TODO
 **/

public class ReorderList {

    public static void main(String[] args) {
        ReorderList list = new ReorderList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        list.reorderList(node1);
    }


    //执行用时 :2 ms, 在所有 Java 提交中击败了81.85%的用户
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode preMid = getMidNode(head);
        ListNode nextMid = reverse(preMid.next);
        preMid.next = null;
        merge(head, nextMid);
    }

    public void merge(ListNode head, ListNode mid) {
        while (mid != null) {
            ListNode next = head.next;
            ListNode midNext = mid.next;
            head.next = mid;
            mid.next = next;
            head = next;
            mid = midNext;
        }
    }

    public ListNode reverse(ListNode node) {
        ListNode cur = node;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode getMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //执行用时 :4 ms, 在所有 Java 提交中击败了29.10%的用户
    public void reorderListI(ListNode head) {
        if (head == null) return;
        ListNode midNode = getMidNode(head).next;
        Stack<ListNode> stack = new Stack<>();
        while (midNode != null) {
            stack.add(midNode);
            midNode = midNode.next;
        }
        ListNode pre = head;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            ListNode temp = pre.next;
            pre.next = node;
            node.next = temp;
            pre = temp;
        }
        pre.next = null;
    }


    public int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
