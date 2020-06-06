package leetcode.swordOffer.medium;

import leetcode.entity.ListNode;

import java.util.Stack;

/**
 * @Author long
 * @Date 2020/4/14 10:04
 * @Title 445. 两数相加 II
 * @Description //TODO
 **/

public class AddTwoNumbers {


    //栈实现：执行用时 :4 ms, 在所有 Java 提交中击败了71.10%的用户
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = null;
        ListNode prev = null;
        while (stack1.size() > 0 || stack2.size() > 0) {
            int a = 0, b = 0;
            if (stack1.size() > 0) a = stack1.pop().val;
            if (stack2.size() > 0) b = stack2.pop().val;
            head = new ListNode(a + b + carry);
            carry = head.val / 10;
            head.val = head.val % 10;
            head.next = prev;
            prev = head;
        }
        if (carry > 0) {
            head = new ListNode(1);
            head.next = prev;
        }
        return head;
    }


    //递归实现：执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
    public ListNode addTwoNumbersI(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        int length1 = length(l1);
        int length2 = length(l2);
        ListNode node = add(l1, l2, length1, length2);
        if (node.val >= 10) {
            ListNode head = new ListNode(1);
            node.val = node.val % 10;
            head.next = node;
            return head;
        } else {
            return node;
        }
    }

    public ListNode add(ListNode node1, ListNode node2, int length1, int length2) {
        if (length1 == 0 && length2 == 0) return null;
        ListNode node;
        ListNode carry;
        if (length1 > length2) {
            carry = add(node1.next, node2, length1 - 1, length2);
            if (carry == null) node = new ListNode(node1.val);
            else node = new ListNode(node1.val + carry.val / 10);
        } else if (length1 < length2) {
            carry = add(node1, node2.next, length1, length2 - 1);
            if (carry == null) node = new ListNode(node2.val);
            else node = new ListNode(node2.val + carry.val / 10);
        } else {
            carry = add(node1.next, node2.next, length1 - 1, length2 - 1);
            if (carry == null) node = new ListNode(node1.val + node2.val);
            else node = new ListNode(node1.val + node2.val + carry.val / 10);
        }
        if (carry != null) carry.val = carry.val % 10;
        node.next = carry;
        return node;
    }

    public int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}
