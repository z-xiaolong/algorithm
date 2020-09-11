package leetcode;

import com.sun.jndi.cosnaming.CNCtx;
import leetcode.entity.TreeNode;

import java.util.*;

/**
 * @author long
 */
public class LeetCode {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode flag = listNode;
        int k = 0;
        int number1 = 0;
        int number2 = 0;
        while (l1 != null) {
            number1 = l1.val * (10 ^ k) + number1;
            k++;
        }
        k = 0;
        while (l2 != null) {
            number2 = l2.val * (10 ^ k) + number2;
            k++;
        }
        int number = number1 + number2;
        while (number > 9) {
            listNode = new ListNode(number % 10);
            number = number / 10;
            listNode = listNode.next;
        }
        return flag.next;
    }

    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i)) == false) {
                list.add(s.charAt(i));
                length = Math.max(length, list.size());
            } else {
                length = Math.max(length, list.size());
                int index = list.indexOf(s.charAt(i));
                for (int j = 0; j <= index; j++) {
                    list.remove(0);
                }
                list.add(s.charAt(i));
            }
        }
        return length;
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int k = m;
            m = n;
            n = k;
        }
        int iMin = 0;
        int iMax = m;
        int halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }


    public static double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }
        int subLeft = 0;
        int subRight = 0;
        for (int i = 0; i <= 2 * length; i++) {
            int left = i % 2 == 0 ? i - 1 : i;
            int right = i % 2 == 0 ? i + 1 : i;
            while (left >= 0 && right <= 2 * length && s.charAt(left / 2) == s.charAt(right / 2)) {
                if ((right - left) > (subRight - subLeft)) {
                    subLeft = left;
                    subRight = right;
                }
                left = left - 2;
                right = right + 2;
            }
        }
        return s.substring(subLeft / 2, subRight / 2 + 1);
    }

    //70. 爬楼梯
    public int climbStairs(int n) {
        if (n == 0) return 0;
        int one = 1;
        int two = 1;
        for (int i = 2; i <= n; i++) {
            int temp = two;
            two = two + one;
            one = temp;
        }
        return two;
    }

    //1137. 第 N 个泰波那契数
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int T0 = 0;
        int T1 = 1;
        int T2 = 1;
        for (int i = 3; i <= n; i++) {
            int temp = T2;
            T2 = T0 + T1 + T2;
            T0 = T1;
            T1 = temp;
        }
        return T2;
    }


    public static void backtrack(int i) {
        System.out.println(i);
        try {
            backtrack(i + 1);
        } catch (StackOverflowError error) {
            error.printStackTrace();
        }
    }

    public static int maximum(int a, int b) {
        long sum = (long) a + (long) b;
        long diff = (long) b - (long) a;
        long abs_diff = (diff ^ (diff >> 63)) - (diff >> 63);
        return (int) ((sum + abs_diff) / 2);
    }

    //14. 最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String s1 = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(s1) != 0) {
                s1 = s1.substring(0, s1.length() - 1);
            }
        }
        return s1;
    }

    //面试题 02.07. 链表相交 执行用时 :3 ms, 在所有 Java 提交中击败了18.32%的用户
    public ListNode getIntersectionNodeI(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        ListNode temp = headA;
        while (temp != null) {
            stackA.push(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            stackB.push(temp);
            temp = temp.next;
        }
        ListNode node = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode a = stackA.pop();
            ListNode b = stackB.pop();
            if (a == b) node = a;
            else break;
        }
        return node;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            if (nodeA == null) nodeA = headB;
            else nodeA = nodeA.next;
            if (nodeB == null) nodeB = headA;
            else nodeB = nodeB.next;
        }
        return nodeA;
    }

    public int exchangeBits(int num) {
        return ((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) << 1);
    }


    public boolean canPermutePalindrome(String s) {
        int[] hash = new int[128];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }
        int count = 0;
        for (int h : hash) {
            if (h % 2 == 1) count++;
            if (count > 1) return false;
        }
        return true;
    }

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String s = s2 + s2;
        return s.contains(s1);
    }


    //67. 二进制求和
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        int carry = 0;
        while (lenA >= 0 && lenB >= 0) {
            int charA = a.charAt(lenA) - '0';
            int charB = b.charAt(lenB) - '0';
            int sum = charA + charB + carry;
            carry = sum / 2;
            builder.append(sum % 2);
            lenA--;
            lenB--;
        }
        while (lenA >= 0) {
            int charA = a.charAt(lenA) - '0';
            int sum = charA + carry;
            carry = sum / 2;
            builder.append(sum % 2);
            lenA--;
        }
        while (lenB >= 0) {
            int charB = b.charAt(lenB) - '0';
            int sum = charB + carry;
            carry = sum / 2;
            builder.append(sum % 2);
            lenB--;
        }
        if (carry > 0) builder.append(carry);
        return builder.reverse().toString();
    }

    //139. 单词拆分
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<Integer> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(hash(word, 0, word.length()));
        }
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(hash(s, j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public int hash(String s, int left, int right) {
        int hash = 0;
        for (int i = left; i < right; i++) {
            hash = hash * 33 + s.charAt(i);
        }
        return hash;
    }


    public boolean wordBreakI(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        Set<String> words = new HashSet<>(wordDict);
        List<Integer> set = new ArrayList<>();
        set.add(0);
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j : set) {
                String w = s.substring(j, i);
                if (wordDict.contains(w)) {
                    dp[i] = true;
                    set.add(i);
                    break;
                }
            }
        }
        return dp[length];
    }

    //面试题 02.01. 移除重复节点
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        Set<Integer> set = new HashSet<>();
        ListNode temp = head;
        set.add(temp.val);
        while (temp.next != null) {
            if (set.contains(temp.next.val)) {
                temp.next = temp.next.next;
                continue;
            }
            set.add(temp.next.val);
            temp = temp.next;
        }
        return head;
    }


    //41. 缺失的第一个正数 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
    public int firstMissingPositiveI(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) set.add(num);
        }
        int i = 1;
        while (set.contains(i)) {
            i++;
        }
        return i;
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i <= n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    //209. 长度最小的子数组
    public int minSubArrayLen(int s, int[] nums) {
        int left;
        int right;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (left = 0, right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int index = partition(nums, left, right);
        while (index != k - 1) {
            if (index > k - 1) {
                right = index - 1;
            } else if (index < k - 1) {
                left = index + 1;
            } else {
                break;
            }
            index = partition(nums, left, right);
        }
        return nums[index];
    }

    public int partition(int[] nums, int left, int right) {
        int mid = (left + right) >> 1;
        int temp = nums[mid];
        nums[mid] = nums[left];
        nums[left] = temp;
        int pivotal = nums[left];
        while (left < right) {
            while (left < right && nums[right] <= pivotal) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] >= pivotal) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivotal;
        return left;
    }

    //剑指 Offer 09. 用两个栈实现队列
    class CQueue {

        private final Stack inStack;
        private final Stack outStack;

        public CQueue() {
            inStack = new Stack();
            outStack = new Stack();
        }

        public void appendTail(int value) {
            inStack.push(value);
        }

        public int deleteHead() {
            if (!outStack.isEmpty()) {
                return outStack.pop();
            } else {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            if (outStack.isEmpty()) return -1;
            return outStack.pop();
        }

        class Stack {
            private int top;
            private int[] stack;

            public Stack() {
                stack = new int[16];
                top = 0;
            }

            public void push(int num) {
                if (top >= stack.length) {
                    grow();
                }
                stack[top] = num;
                top++;
            }

            public void grow() {
                int oldSize = stack.length;
                int newSize = oldSize + oldSize << 1;
                stack = Arrays.copyOf(stack, newSize);
            }

            public int pop() {
                if (top == 0) return -1;
                return stack[--top];
            }

            public boolean isEmpty() {
                return top == 0;
            }
        }
    }

    //32. 最长有效括号
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c == ')' && stack.peek() >= 0 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                max = Math.max(max, i - stack.peek());
            } else {
                stack.push(i);
            }
            i++;
        }
        return max;
    }


    //面试题 02.05. 链表求和
    public ListNode addTwoNumbersI(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            temp.next = l1;
            l1 = l1.next;
            l2 = l2.next;
            temp = temp.next;
        }
        while (l2 != null) {
            int sum = carry + l2.val;
            l2.val = sum % 10;
            carry = sum / 10;
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        while (l1 != null) {
            int sum = carry + l1.val;
            l1.val = sum % 10;
            carry = sum / 10;
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return head.next;
    }


    //120. 三角形最小路径和
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            List<Integer> prev = triangle.get(i + 1);
            for (int j = 0; j < list.size(); j++) {
                int temp = list.get(j) + Math.min(prev.get(j), prev.get(j + 1));
                list.set(j, temp);
            }
        }
        return triangle.get(0).get(0);
    }


    //1025. 除数博弈
    public boolean divisorGame(int N) {
        if (N <= 2) return N == 2;
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j * j < i; j++) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }


    //130. 被围绕的区域
    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) return;
        int m = board[0].length;
        boolean[][] flag = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfs(flag, board, i, 0);
            }
            if (board[i][m - 1] == 'O') {
                dfs(flag, board, i, m - 1);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                dfs(flag, board, 0, i);
            }
            if (board[n - 1][i] == 'O') {
                dfs(flag, board, n - 1, i);
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j] == 'O' && !flag[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(boolean[][] flag, char[][] board, int i, int j) {
        if (flag[i][j]) return;
        flag[i][j] = true;
        int n = board.length;
        int m = board[0].length;
        if (i + 1 < n && !flag[i + 1][j] && board[i + 1][j] == 'O') {
            dfs(flag, board, i + 1, j);
        }
        if (j + 1 < m && !flag[i][j + 1] && board[i][j + 1] == 'O') {
            dfs(flag, board, i, j + 1);
        }
        if (i - 1 >= 0 && !flag[i - 1][j] && board[i - 1][j] == 'O') {
            dfs(flag, board, i - 1, j);
        }
        if (j - 1 >= 0 && !flag[i][j - 1] && board[i][j - 1] == 'O') {
            dfs(flag, board, i, j - 1);
        }

    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode temp = new TreeNode(-1);
        dfs(root, temp);
    }

    public TreeNode dfs(TreeNode node, TreeNode preNode) {
        if (node == null) return preNode;
        TreeNode right = node.right;
        preNode.right = node;
        TreeNode next = dfs(node.left, node);
        node.left = null;
        return dfs(right, next);
    }


    public static int solution(int N, int k, int[] goods) {
        Arrays.sort(goods);
        int index = 0;
        int count = 0;
        int n = goods.length;
        while (index + k <= n) {
            if (goods[index] > 0) {
                goods[index]--;
                for (int i = n - 1; i > n - k; i--) {
                    goods[i]--;
                }
                Arrays.sort(goods);
                count++;
            }
            if (goods[index] == 0) index++;
        }
        return count;
    }


    public static int solution(int n) {
        if (n <= 7) return n;
        int[][] dp = new int[n + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (i == 0) {
                    dp[0][j] = dp[0][j - 1] + 1;
                    continue;
                }
                if (i == j) {
                    dp[i][j] = dp[0][j] + 6;
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                if (j - i >= i)
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - i] + 2);
                if (j == i * 2) {
                    for (int k = 0; k <= i; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[k][i] + 7);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n / 2; i++) {
            min = Math.min(min, dp[i][n]);
        }
        return min;
    }


    public static int minSumOfLengths(int[] A, int t) {
        int n = A.length;
        int[] dp = new int[n];
        int min = n;
        Map<Integer, int[]> hashMap = new HashMap<>();
        dp[0] = A[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + A[i];
        }


        return min;
    }

    public static void solution() {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        String x = in.nextLine();
    }


    public static void decode(String x) {
        int i = 0;
        int n = x.length();
        int res = 0;
        int count = 0;
        while (i < n) {
            String sub = x.substring(i, i + 4);
            int num = 0;
            int temp = sub.charAt(2) - '0';
            if (temp > 16) temp -= 7;
            num = num * 16 + temp;
            temp = sub.charAt(3) - '0';
            if (temp > 16) temp -= 7;
            num = num * 16 + temp;
            if (num > 128) num -= 128;
            res = num * (1 << count) + res;
            count += 7;
            i += 4;
        }
        System.out.println(res);
    }

    public static void encode(String n) {
        int num = Integer.parseInt(n);
        StringBuilder builder = new StringBuilder();
        while (num > 128) {
            int temp = num % 128 + 128;
            String hex = Integer.toHexString(temp);
            if (hex.length() == 1) hex = "0" + hex;
            builder.append("0X").append(hex);
            num = num >> 7;
        }
        String hex = Integer.toHexString(num);
        if (hex.length() == 1) hex = "0" + hex;
        builder.append("0X").append(hex);
        System.out.println(builder.toString().toUpperCase());
    }


    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        char[] chars = new char[n * 2];

        return result;
    }

    public void dfs(int index, List<String> list, char[] chars, int left, int right) {
        if (left * 2 == chars.length) {
            for (int i = 0; i < right; i++) {
                chars[index] = ')';
                index++;
            }
            list.add(new String(chars));
        } else if (left == right) {
            chars[index] = '(';
            dfs(index + 1, list, chars, left + 1, right);
        } else if (left > right) {
            chars[index] = '(';
            dfs(index + 1, list, chars, left + 1, right);
            chars[index] = ')';
            dfs(index + 1, list, chars, left, right + 1);
        }
    }


    public static List<Integer> findK(int[] arr) {
        int n = arr.length;
        List<Integer> left_max = new ArrayList<>();
        int leftMax = arr[0];
        List<Integer> right_min = new ArrayList<>();
        int rightMin = arr[n - 1];
        for (int i = 0; i < n; i++) {
            if (arr[i] > leftMax) leftMax = arr[i];
            left_max.add(leftMax);
        }
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < rightMin) rightMin = arr[i];
            right_min.add(rightMin);
        }
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (left_max.get(i) < arr[i] && arr[i] < right_min.get(i)) {
                resList.add(arr[i]);
            }
        }

        return resList;
    }

    public static List<Integer> findKI(int[] arr) {
        List<Integer> list = new LinkedList<>();
        int n = arr.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        dpMax[0] = arr[0];
        dpMin[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(arr[i], dpMax[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            dpMin[i] = Math.min(arr[i], dpMin[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            if (i == 0 && dpMax[i] == dpMin[i]) {
                list.add(arr[i]);
            } else if (i == n - 1 && dpMax[i] == dpMin[i]) {
                list.add(arr[i]);
            } else if (arr[i] > dpMax[i - 1] && arr[i] < dpMin[i + 1]) {
                list.add(arr[i]);
            }
        }
        return list;
    }


    public static int solve(int n, int k) {
        k = k % n;
        if (k == 0) return 0;
        if (k == 1 || n - k == 1) return 2;
        return 3;
    }




    public static String printMaxChar(String str) {
        StringBuilder builder = new StringBuilder();
        int max = 0;
        int i = 0;
        int length = str.length();
        while (i < length) {
            char c = str.charAt(i);
            i++;
            int start = i;
            while (i < length && str.charAt(i) == str.charAt(i - 1)) {
                i++;
            }
            int len = i - start + 1;
            if (len > max) {
                max = len;
                builder = new StringBuilder();
                builder.append(c).append(";");
            } else if (len == max) {
                builder.append(c).append(";");
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPipCount(5));
    }


    public static int getPipCount(int n) {
        int sum = 1;
        int[] dp = new int[3];
        dp[0] = 1;
        while (n > 0) {
            sum += dp[2];
            dp[2] += dp[1];
            dp[1] = dp[0];
            dp[0] = dp[2];
            n--;
        }


        return sum;
    }

}

