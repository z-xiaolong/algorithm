import algorithm.chapter10.MyStack;
import leetcode.entity.ListNode;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        System.out.println(solution(1, 1));
    }

    public static int solution(int x, int y) {
        int[][] matrix = new int[x + 1][y + 1];
        return dfs(matrix, 0, 0);
    }

    public static int dfs(int[][] matrix, int i, int j) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (i == n - 1 && j == m - 1) return 1;
        int count = 0;
        if (i + 1 < n) {
            count += dfs(matrix, i + 1, j);
        }
        if (j + 1 < m) {
            count += dfs(matrix, i, j + 1);
        }
        return count;
    }


    public static void exception(int i) {
        throw new RuntimeException();
    }

    private static int Main(int i) {
        System.out.println("Main()");
        return -1;
    }

    static int maxBoxes(int[][] boxes) {
        int n = boxes.length;
        if (n == 0) return 0;
        int len = 1;
        Arrays.sort(boxes, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            else return o2[1] - o1[1];
        });
        int[] dp = new int[n + 1];
        dp[len] = boxes[0][1];
        for (int i = 1; i < n; i++) {
            if (boxes[i][1] > dp[len]) {
                dp[++len] = boxes[i][1];
            } else {
                int left = 1;
                int right = len;
                int pos = 0;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (dp[mid] < boxes[i][1]) {
                        pos = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                dp[pos + 1] = boxes[i][1];
            }
        }
        return len;
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

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

}


class Trie {
    private boolean isWord;
    private final Trie[] next;
    private int count = 0;
    private int stopCount = 0;

    public Trie() {
        isWord = false;
        next = new Trie[26];
    }


    public void insert(String word) {
        Trie curTrie = this;
        int i = 0;
        while (i < word.length()) {
            char c = word.charAt(i);
            if (curTrie.next[c - 'a'] == null) {
                curTrie.next[c - 'a'] = new Trie();
            }
            curTrie = curTrie.next[c - 'a'];
            curTrie.count++;
            i++;
        }
        curTrie.isWord = true;
        curTrie.stopCount++;
    }

    public void delete(String word) {
        Trie curTrie = this;
        int i = 0;
        if (!search(word)) return;
        while (i < word.length()) {
            char c = word.charAt(i);
            curTrie = curTrie.next[c - 'a'];
            curTrie.count--;
            i++;
        }
        curTrie.stopCount--;
        if (curTrie.stopCount == 0) {
            curTrie.isWord = false;
        }
    }

    public boolean search(String word) {
        Trie curTrie = this;
        int i = 0;
        while (i < word.length()) {
            if (curTrie == null) return false;
            char c = word.charAt(i);
            if (curTrie.next[c - 'a'] == null || curTrie.next[c - 'a'].count < 1) {
                return false;
            }
            curTrie = curTrie.next[c - 'a'];
            i++;
        }
        return curTrie.isWord;
    }

    public int prefixNumber(String word) {
        Trie curTrie = this;
        int i = 0;

        int cnt = Integer.MAX_VALUE;
        while (i < word.length()) {
            char c = word.charAt(i);
            if (curTrie.next[c - 'a'] == null || curTrie.next[c - 'a'].count < 1) {
                return 0;
            }
            curTrie = curTrie.next[c - 'a'];
            cnt = Math.min(cnt, curTrie.count);
            i++;
        }
        return cnt;
    }
}