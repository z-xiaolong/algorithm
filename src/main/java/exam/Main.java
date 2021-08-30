package exam;

import leetcode.entity.ListNode;
import leetcode.entity.TreeNode;
import org.omg.PortableInterceptor.INACTIVE;
import redis.clients.jedis.Transaction;

import java.util.*;

/**
 * @Author long
 * @Date 2020/3/29 20:01
 * @Title
 * @Description //TODO
 **/

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        String[] words1 = str1.split(" ");
        String[] words2 = str2.split(" ");
        Map<String, Integer> map = new HashMap<>();
        Set<String> output = new HashSet<>();
        for (String s : words1) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) output.add(entry.getKey());
        }
        Set<String> set = new HashSet<>(Arrays.asList(words2));

        for (String word : words1) {
            if (!set.contains(word)) output.add(word);
        }

        for (String word : output) {
            System.out.print(word + " ");
        }
    }

    public static void operate(Stack<Integer> prevStack, Stack<Integer> nextStack, String str) {
        if (str.contains("add")) {
            int num = Integer.parseInt(str.split(" ")[1]);
            prevStack.push(num);
        } else if (str.contains("peek")) {
            if (nextStack.isEmpty()) {
                while (!prevStack.isEmpty()) {
                    nextStack.push(prevStack.pop());
                }
            }
            System.out.println(nextStack.peek());
        } else if (str.contains("poll")) {
            if (nextStack.isEmpty()) {
                while (!prevStack.isEmpty()) {
                    nextStack.push(prevStack.pop());
                }
            }
            nextStack.pop();
        }
    }


    public String notReCuPreOrder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        if (root == null) {
            return builder.toString();
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            builder.append(node.val).append(",");
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
