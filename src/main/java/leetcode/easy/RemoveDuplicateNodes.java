package leetcode.easy;

import leetcode.entity.ListNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Author long
 * @Date 2020/6/11 10:26
 * @Title
 * @Description //TODO
 **/

public class RemoveDuplicateNodes {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode temp = head;
        while (temp != null) {
            if (temp.next != null && set.contains(temp.next.val)) {
                remove(temp);
            } else {
                if (temp.next != null) set.add(temp.next.val);
                temp = temp.next;
            }
        }
        return head;
    }

    public void remove(ListNode node) {
        if (node.next == null) return;
        node.next = node.next.next;
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int majorityNum = 0;
        for (int num : nums) {
            if (count == 0) {
                majorityNum = num;
                count++;
            } else if (majorityNum != num) {
                count--;
            } else {
                count++;
            }
        }
        return majorityNum;
    }

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        while (!stack.isEmpty() && slow != null) {
            if (slow.val != stack.pop()) return false;
            slow = slow.next;
        }
        return true;
    }
}
