import algorithm.chapter10.MyStack;
import leetcode.entity.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void exception(int i) {
        throw new RuntimeException();
    }

    private static int Main(int i) {
        System.out.println("Main()");
        return -1;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Stack<Integer> prevStack = new Stack<>();
        Stack<Integer> nextStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            operate(prevStack, nextStack, str);
        }
    }

    public static void operate(Stack<Integer> prevStack, Stack<Integer> nextStack, String str) {
        if (str.contains("add")) {
            int num = Integer.parseInt(str.split(" ")[1]);
            prevStack.push(num);
        } else if ("peek".equals(str)) {
            if (nextStack.isEmpty()) {
                while (!prevStack.isEmpty()) {
                    nextStack.push(prevStack.pop());
                }
            }
            System.out.println(nextStack.peek());
        } else if ("poll".equals(str)) {
            if (nextStack.isEmpty()) {
                while (!prevStack.isEmpty()) {
                    nextStack.push(prevStack.pop());
                }
            }
            nextStack.pop();
        }
    }

    public static long parent(long x, int k) {
        int level = 0;
        long temp = x;
        while (temp > 0) {
            temp >>= 1;
            level++;
        }
        if (level <= k) return -1;
        long parent = x;
        while (level > k) {
            parent >>= 1;
            level--;
        }
        return parent;
    }

    public static void operate(Queue<Integer> queue, String str) {
        if (str.contains("add")) {
            int num = Integer.parseInt(str.split(" ")[1]);
            queue.add(num);
        } else if ("peek".equals(str)) {
            System.out.println(queue.peek());
        } else if ("poll".equals(str)) {
            queue.poll();
        }
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
        MyStack<ListNode> myStack = new MyStack<>();
        while (head != null) {
            myStack.push(head);
            head = head.next;
        }
        head = myStack.pop();
        ListNode temp = head;
        while (!myStack.isEmpty()) {
            ListNode node = myStack.pop();
            temp.next = node;
            temp = node;
        }
        temp.next = null;
        return head;
    }


}
