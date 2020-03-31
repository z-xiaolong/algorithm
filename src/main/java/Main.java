import algorithm.chapter10.Stack;
import leetcode.entity.ListNode;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

    }


    public static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = mid(nums, left, right);
        sort(nums, left, mid - 1);
        sort(nums, mid + 1, right);
    }

    public static int mid(int[] nums, int left, int right) {
        if (left >= right) {
            return left;
        }
        int k = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= k) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= k) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = k;
        return left;
    }

    public static int findDup(String str) {
        int value = 0;
        int count = 0;
        for (int i = 4; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == str.charAt(i - 1)) {
                count++;
                value = Math.max(count, value);
            } else {
                count = 0;
            }
        }
        return value + 1;
    }

    public static int findOrder(String str) {
        int value = 1;
        int count = 0;
        for (int i = 4; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c - str.charAt(i - 1) == 1) {
                count++;
                value = Math.max(count, value);
            } else {
                count = 0;
            }
        }
        return value;
    }


    public static boolean check(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode temp = head;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            temp.next = node;
            temp = node;
        }
        temp.next = null;
        return head;
    }


}
