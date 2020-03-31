package leetcode.swordOffer.easy;

import algorithm.chapter10.Stack;
import leetcode.entity.ListNode;

/**
 * @Author long
 * @Date 2020/3/1 20:16
 * @Title
 * @Description //TODO
 **/

public class ReversePrint {
    private int index = 0;

    //栈
    public int[] reversePrint(ListNode head) {
        int size = 0;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
            size++;
        }
        int index = 0;
        int[] nums = new int[size];
        while (!stack.isEmpty()) {
            nums[index++] = stack.pop().val;
        }
        return nums;
    }

    //递归解, 递归来实现栈的功能
    public int[] recursion(ListNode node, int count) {
        if (node == null) {
            return new int[count];
        }
        int[] nums = recursion(node.next, count + 1);
        nums[index++] = node.val;
        return nums;
    }
}
