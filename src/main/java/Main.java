import algorithm.chapter10.MyStack;
import leetcode.entity.ListNode;
import leetcode.entity.TreeNode;

import java.util.*;

public class Main {



    

    public static void main(String[] args) {

    }










    static int K;

    public int maxValue(TreeNode root, int k) {
        K = k;
        Map<TreeNode, int[]> map = new HashMap<>();
        return dfs(map, root, k);
    }

    public int dfs(Map<TreeNode, int[]> map, TreeNode node, int k) {
        if (node == null) {
            return 0;
        }
        if (map.containsKey(node)) {
            int[] dp = map.get(node);
            if (dp[k] != -1) {
                return dp[k];
            }
        } else {
            int[] dp = new int[11];
            Arrays.fill(dp, -1);
            map.put(node, dp);
        }
        int max = Integer.MIN_VALUE;
        int val = node.val;
        max = Math.max(max, dfs(map, node.left, K) + dfs(map, node.right, K));
        if (k != 0) {
            for (int i = 0; i < k; i++) {
                max = Math.max(max, val + dfs(map, node.left, i) + dfs(map, node.right, k - i - 1));
            }
        }
        map.get(node)[k] = max;
        return max;
    }


    public static int storeWater(int[] bucket, int[] vat) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (a, b) -> (vat[b] + bucket[b] - 1) / bucket[b]
                        - (vat[a] + bucket[a] - 1) / bucket[a]);
        int n = bucket.length;
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (bucket[i] == 0 && vat[i] != 0) {
                bucket[i]++;
                queue.add(i);
                count++;
            } else if (vat[i] != 0) {
                queue.add(i);
            }
        }
        if (queue.isEmpty()) {
            return 0;
        }
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int max = (vat[index] + bucket[index] - 1) / bucket[index];
            min = Math.min(min, max + count);
            int change = (vat[index] + bucket[index]) / (bucket[index] + 1);
            if (change + 1 > max) {
                break;
            } else {
                bucket[index]++;
                count++;
                queue.add(index);
            }
        }
        return min;
    }


    public static ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tmp = new ListNode(1);
        tmp.next = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return tmp.next;
    }


    public int magicTower(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < 0) {
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            queue.add(num);
            if (sum < 0) {
                count++;
                sum -= queue.poll();
            }
        }
        return count;
    }

    public int orchestraLayout(int num, int xPos, int yPos) {

        int level = Math.min(Math.min(xPos + 1, num - xPos),
                Math.min(yPos + 1, num - yPos));
        long sum = 4L * (num - 1 + (num - 1 - (level - 1) * 2L)) * level / 2;
        sum -= 4L * (num - 1 - (level - 1) * 2L);
        int min = level - 1;
        int max = num - level;
        if (xPos == min) {
            sum += yPos - min + 1;
        } else if (yPos == max) {
            sum += max - min + 1 + xPos - min;
        } else if (xPos == max && yPos > min) {
            sum += 2L * (max - min + 1) - 1 + max - yPos;
        } else if (yPos == min) {
            sum += (max - min + 1) * 3L - 2 + max - xPos;
        }
        if (sum % 9 == 0) {
            return 9;
        }
        return (int) (sum % 9);
    }

    static int mod = 1000000007;


    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] * 2 > target) {
                break;
            }
            int left = i;
            int right = nums.length - 1;
            int t = target - nums[i];
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] > t) {
                    right = mid - 1;
                } else if (nums[mid] <= t) {
                    left = mid;
                }
            }
            if (left > i && nums[left] <= t) {
                sum = (sum + left - i) % mod;
            }
        }
        return (int) (sum % mod);
    }


    public static void main11(String[] args) {
        ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
        ThreadLocal<String> threadLocal2 = new ThreadLocal<>();

        new Thread(() -> {
            threadLocal1.set("ThreadA");
            threadLocal2.set("ThreadAB");
            System.out.println(threadLocal1.get());
            threadLocal1.set("ThreadA +++");
            System.out.println(threadLocal1.get());
            threadLocal1.remove();
            System.out.println(threadLocal1.get());
            System.out.println(threadLocal2.get());
        }, "ThreadA").start();
    }

    public static void main4(String[] args) {
        long re = 0;
        double b = 0;

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[][] peoples = new int[N][2];
        for (int i = 0; i < N; i++) {
            peoples[i][0] = in.nextInt();
            peoples[i][1] = in.nextInt();
        }
        int[][] stations = new int[M][2];
        for (int i = 0; i < M; i++) {
            stations[i][0] = in.nextInt();
            stations[i][1] = in.nextInt();
        }
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            int dis = 0;
            int x = stations[i][0];
            int y = stations[i][1];
            for (int j = 0; j < N; j++) {
                dis += Math.abs(peoples[j][0] - x) + Math.abs(peoples[j][1] - y);
            }
            if (dis < min) {
                min = dis;
                index = i;
            }
        }
        System.out.println(stations[index][0] + " " + stations[index][1]);
    }


    static int Mod = 1000000007;

    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            String[] strs = line.split(" ");
            long a = Integer.parseInt(strs[0]) % mod;
            long b = Integer.parseInt(strs[1]) % mod;
            char op = strs[2].charAt(0);
            System.out.println(getResult(a, b, op));
        }
    }

    public static long getResult(long a, long b, char op) {
        long res = 0;
        if (op == '-') {
            res = a - b;
        } else if (op == '+') {
            res = a + b;
        } else if (op == '*') {
            res = a * b;
        } else if (op == '^') {
            long temp = a;
            res = 1;
            while (b > 0) {
                if ((b & 1) == 1) {
                    res = res * temp % mod;
                }
                temp = temp * temp % mod;
                b = b >> 1;
            }
        }
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(0);

        return res % mod;
    }

    public static void main2(String[] args) {
        //HashMap<Integer, Integer> map = new HashMap<>();
        //map.put(null, null);
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int[] map = new int[256];
        char[] chars = str.toCharArray();
        for (char c : chars) {
            map[c]++;
        }
        int count = 0;
        int len = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                if (count == 0) {
                    count = map[i];
                    continue;
                }
                if (count % map[i] == 0 || map[i] % count == 0) {
                    count = Math.min(count, map[i]);
                } else {
                    System.out.println(str);
                    return;
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                len += map[i] / count;
            }
        }
        String sub = str.substring(0, len);
        if (check(str, sub)) {
            System.out.println(sub);
        } else {
            System.out.println(str);
        }
    }

    public static boolean check(String str, String sub) {
        int len = sub.length();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != sub.charAt(i % len)) {
                return false;
            }
        }
        return true;
    }


    public static int find(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i] - nums[i - 1], max);
        }
        return max;
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = partition(nums, left, right);
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }


    public static int partition(int[] nums, int left, int right) {
        if (left >= right) return left;
        int flag = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= flag)
                right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= flag)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = flag;
        return left;
    }


    public static void main1(String[] args) {
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
        if (!search(word)) {
            return;
        }
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