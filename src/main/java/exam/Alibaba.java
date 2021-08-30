package exam;

import leetcode.entity.ListNode;
import leetcode.entity.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @Author long
 * @Date 2020/3/30 18:49
 * @Title
 * @Description //TODO
 **/

public class Alibaba {

    static int mod = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt(); //地铁线路数量
            int s = in.nextInt(); //地点
            int t = in.nextInt(); //终点
            HashSet<Integer>[] trains = new HashSet[n];
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                trains[j] = new HashSet<>();
                int m = in.nextInt();
                for (int k = 0; k < m; k++) {
                    int station = in.nextInt();
                    trains[j].add(station);
                    if (!map.containsKey(station)) {
                        map.put(station, new HashSet<>());
                    }
                    map.get(station).add(j);
                }
            }
            System.out.println(solution1(trains, map, s, t));
        }
    }

    public static int solution1(HashSet<Integer>[] trains, Map<Integer, Set<Integer>> map, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int count = 0;
        Set<Integer> flag = new HashSet<>();
        flag.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int station = queue.poll();
                Set<Integer> paths = map.get(station);
                if (paths == null) {
                    continue;
                }
                for (int path : paths) {
                    HashSet<Integer> set = trains[path];
                    if (set.contains(end)) {
                        return count;
                    }
                    for (int s : set) {
                        if (!flag.contains(s)) {
                            flag.add(s);
                            queue.add(s);
                        }
                    }
                }
                size--;
            }
            count++;
        }
        return -1;
    }

    /*public static int solution() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.println();
        }
        return 0;
    }*/


    //内存空间O（n）
    public static void maxExpectation() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        double e = 0;
        double p = 2.0 / (((double) n + 1) * (double) n);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            dp[i] = nums[i];
            e += nums[i] * p;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j] = Math.max(dp[j], dp[j + 1]);
                e += dp[j] * p;
            }
        }
        System.out.println(String.format("%.6f", e));//四舍五入
    }

    //子序列的最大值的期望
    //内存空间O(n^2)
    public static void maxExpectationI() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            dp[i][i] = nums[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][j + i] = Math.max(dp[j + 1][j + i], dp[j][j + i - 1]);
            }
        }
        double e = 0;
        double p = 2.0 / (((double) n + 1) * (double) n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                e += dp[j][j + i] * p;
            }
        }
        System.out.println(String.format("%.6f", e));//四舍五入
    }


    //2020年7月20日
    @Test
    public void solutionI() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long n = in.nextLong();
            long k = in.nextLong();
            solution(n, k);
        }
    }

    public static void solution(long n, long k) {
        if (n % k != 0) {
            System.out.println(-1);
        }
        long common = n / k;
        if (common <= 3) {
            System.out.println(-1);
        }

    }

    public boolean isCommon(long a, long b) {
        return false;
    }


    @Test
    public static void solutionII() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int left = in.nextInt();
            int right = in.nextInt();
            solution(left, right);
        }
    }

    static int[] dp = new int[1000];

    public static void dp() {
        int cnt = 0;
        for (int i = 1; i <= dp.length; i++) {
            if (isLucky(i)) {
                cnt++;
                dp[i] = cnt;
            }
        }
    }

    public static void solution(int left, int right) {
        int cnt = dp[right] - dp[left];
        System.out.println(cnt);
    }

    public static boolean isLucky(int num) {
        while (num > 10) {
            num = nextNum(num);
        }
        return num == 7;
    }

    public static int nextNum(int num) {
        int newNum = 0;
        String str = String.valueOf(num);
        for (int i = 1; i < str.length(); i++) {
            int bit = str.charAt(i) - str.charAt(i - 1);
            newNum = newNum * 10 + Math.abs(bit);
        }
        return newNum;
    }


    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int k = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.right == null && node.left == null) {
                    return k;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            k++;
        }
        return k;
    }


    class EmailSystem {
        List<Email> emailList = new ArrayList<>(1024);
        Map<String, Set<Email>> emailMap = new HashMap<>();

        public List<Email> findEmails(String name, String key, Long startTime, Long endTime) {
            List<Email> list = emailList;
            if (startTime != null && endTime != null) {
                list = findEmailsByTimestamp(startTime, endTime);
            }
            if (name != null) {
                list = findEmailByName(list, name);
            }
            if (key != null) {
                list = findEmailByKey(list, key);
            }
            return list;
        }

        public List<Email> findEmailByName(List<Email> list, String name) {
            if (!emailMap.containsKey(name)) {
                return null;
            }
            if (list == emailList) {
                list = new ArrayList<>(emailMap.get(name));
            }
            List<Email> res = new ArrayList<>();
            for (Email email : list) {
                if (email.name.contains(name)) {
                    res.add(email);
                }
            }
            return res;
        }

        public List<Email> findEmailByKey(List<Email> list, String key) {
            List<Email> res = new ArrayList<>();
            for (Email email : list) {
                if (email.key.indexOf(key) > 0) {
                    res.add(email);
                }
            }
            return res;
        }

        public List<Email> findEmailsByTimestamp(long startTime, long endTime) {
            if (startTime > endTime) return null;
            int start = binarySearchEmail(startTime);
            int size = emailList.size();
            List<Email> list = new ArrayList<>();
            long cur = emailList.get(start).timestamp;
            while (cur >= startTime && cur <= endTime) {
                list.add(emailList.get(start));
                start++;
                if (start == size) break;
                cur = emailList.get(start).timestamp;
            }
            return list;
        }


        public int binarySearchEmail(long startTime) {
            int left = 0;
            int right = emailList.size() - 1;
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (emailList.get(mid).timestamp > startTime) {
                    right = mid - 1;
                } else if (emailList.get(mid).timestamp < startTime) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }


        public void addEmail(String name, String key, long timestamp) {
            Email email = new Email(name, key, timestamp);
            emailList.add(email);
            if (!emailMap.containsKey(name)) {
                emailMap.put(name, new HashSet<>());
            }
            Set<Email> set = emailMap.get(name);
            set.add(email);
        }


        class Email {
            String name;
            String key;
            long timestamp;

            public Email(String name, String key, long timestamp) {
                this.name = name;
                this.key = key;
                this.timestamp = timestamp;
            }

        }
    }


    public static void solution() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] coins = new int[n];
        int[][] houses = new int[m][2];

        for (int i = 0; i < n; i++) {
            coins[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            houses[i][0] = in.nextInt();
            houses[i][1] = in.nextInt();
        }
        Arrays.sort(houses, (o1, o2) -> o2[0] - o1[0]);
        Arrays.sort(coins);
        long sum = 0;
        boolean[] flag = new boolean[n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            int cost = houses[i][1];
            int index = binarySearch(coins, cost);
            while (index < n && (coins[index] < cost || flag[index])) {
                index++;
            }
            if (index == n) continue;
            sum += cost;
            flag[index] = true;
            count++;
            if (count == n) break;
        }
        System.out.println(sum);
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid;
            }
        }
        return left;
    }

    public static void solutionIII() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] coins = new int[n];
        int[][] houses = new int[m][2];

        for (int i = 0; i < n; i++) {
            coins[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            houses[i][0] = in.nextInt();
            houses[i][1] = in.nextInt();
        }
        Arrays.sort(houses, (o1, o2) -> o2[0] - o1[0]);
        Arrays.sort(coins);
        long sum = 0;
        boolean[] flag = new boolean[n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            int cost = houses[i][1];
            int index = binarySearchI(coins, cost);
            while (index < n && (coins[index] <= cost || flag[index])) {
                index++;
            }
            if (index == n) continue;
            sum += cost;
            flag[index] = true;
            count++;
            if (count == n) break;
        }
        System.out.println(sum);
    }

    public static int binarySearchI(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid;
            }
        }
        return left;
    }
}
