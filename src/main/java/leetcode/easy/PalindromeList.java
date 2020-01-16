package leetcode.easy;

import leetcode.entity.ListNode;

/**
 * @Author long
 * @Date 21:19 2019/10/18
 * @Title 234. 回文链表
 * @Description 请判断一个链表是否为回文链表。
 * 快慢指针
 **/

public class PalindromeList {

    private ListNode head;

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        PalindromeList list = new PalindromeList(nums);
        list.print();
        list.reverseBetween(list.head,1,9);
        System.out.println();
        list.print();
        //System.out.println(list.isPalindrome(list.getHead()));

    }

    public PalindromeList(int[] nums) {
        head = new ListNode(nums[0]);
        ListNode node = head;
        for (int i = 1; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
    }

    public ListNode getHead() {
        return head;
    }

    public void print() {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null) {
                System.out.print("->");
            }
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode next = head.next;
        ListNode prev = null;
        while (fast != null && next != null) {
            if (fast.next == null) {
                slow = slow.next;
                break;
            }
            fast = fast.next.next;
            slow.next = prev;
            prev = slow;
            slow = next;
            next = next.next;
        }
        while (prev != null && slow != null) {
            if (prev.val == slow.val) {
                prev = prev.next;
                slow = slow.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        ListNode next = head.next;
        ListNode prev = null;
        while (next != null) {
            node.next = prev;
            prev = node;
            node = next;
            next = next.next;
        }
        node.next = prev;
        return node;
    }

    /* 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
    说明:1 ≤ m ≤ n ≤ 链表长度。*/
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode right;
        ListNode prev = null;
        ListNode node = head;
        ListNode left = head;
        ListNode next = node.next;
        while (next != null && n > 1) {
            if (m > 1) {
                left = node;
                node = next;
                next = next.next;
                m--;
            } else {
                node.next = prev;
                prev = node;
                node = next;
                next = next.next;
            }
            n--;
        }
        right = node.next;
        node.next = prev;
        if(left.next != null){
            left.next.next = right;
            left.next = node;
            return head;
        } else {
            left.next = right;
            return node;
        }
    }
}
