package exam;

import org.junit.Test;

import java.util.*;

/**
 * @Author: long
 * @Date: 2020/7/29 14:15
 * @Title
 * @Description:
 */
public class Shopee {

    static List<Integer> list = new ArrayList<>();
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        line = line.substring(1, line.length() - 1);
        String[] strs = line.split(",");
        int n = strs.length;
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        Integer[] map = new Integer[n];
        for (int i = 0; i < n; i++) {
            map[i] = i;
        }


        Arrays.sort(map, Comparator.comparingInt(a -> nums[a]));

        dfs(nums, map, 0);
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        int i = 0;
        while (i < ans.size()) {
            List<Integer> t = ans.get(i);
            builder.append("[");
            for (int num : t) {
                builder.append(num).append(",");
            }
            if (t.size() > 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
            builder.append("]");
            builder.append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        System.out.println(builder);
    }

    public static void dfs(Integer[] nums, Integer[] map, int cur) {
        if (list.size() == nums.length - 1) {
            ans.add(new ArrayList<>(list));
            return;
        }
        int num = nums[cur];
        list.add(num);
        dfs(nums, map, cur + 1);
        list.remove(list.size() - 1);


        dfs(nums, map, cur + 1);
    }


    public static void solutionIII() {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int len = line.length();
        if (!"\\n".equals(line.substring(len - 2, len))) {
            line += "\\n";
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;

        while (i < len) {
            StringBuilder product = new StringBuilder();
            while (line.charAt(i) != '\\') {
                product.append(line.charAt(i));
                i++;
            }
            i++;
            builder.append(product.toString()).append(",");
            if (line.charAt(i) != 't') {
                System.out.println("null");
                return;
            }
            i++;
            int start = i;
            while (start < len && line.charAt(start) != '\\') {
                start++;
            }
            String num = line.substring(i, start);
            String amount = formatNumber(num);
            if (amount == null) {
                System.out.println("null");
                return;
            }
            builder.append(amount).append("\n");
            i = start + 1;
            if (line.charAt(i) != 'n') {
                System.out.println("null");
                return;
            }
            i++;
        }
        System.out.println(builder.toString());
    }

    public static String formatNumber(String num) {
        int len = num.length();
        int number = 0;
        if (len >= 2 && "0x".equals(num.substring(0, 2))) {
            int i = 2;
            if (num.charAt(i) == '0') {
                return null;
            }
            while (i < len) {
                char c = num.charAt(i);
                if (c >= '0' && c < '9') {
                    number = number * 16 + c - '0';
                } else if (c >= 'A' && c <= 'F') {
                    number = number * 16 + c - 'A';
                } else if (c >= 'a' && c <= 'f') {
                    number = number * 16 + c - 'a';
                } else {
                    return null;
                }
                i++;
            }
            return String.valueOf(number);
        }
        if (num.charAt(0) == '0') {
            return null;
        }
        int i = 0;
        while (i < len) {
            char c = num.charAt(i);
            if (c < '0' || c > '9') {
                return null;
            }
            i++;
        }
        return num;
    }


    public static void solutionII() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] dp = new int[n + 1][4];

            for (int j = 1; j <= n; j++) {
                int k = in.nextInt();

                if (j == 1) {
                    int min = in.nextInt();
                    int max = min;
                    for (int l = 2; l <= k; l++) {
                        max = in.nextInt();
                    }
                    dp[1][0] = max - min + 1;
                    dp[1][1] = dp[1][0];
                    dp[1][2] = min;
                    dp[1][3] = max;
                    continue;
                }
                if (k == 0) {
                    dp[j][0] = dp[j - 1][0] + 1;
                    dp[j][1] = dp[j - 1][1] + 1;
                    dp[j][2] = dp[j - 1][2];
                    dp[j][3] = dp[j - 1][3];
                    continue;
                }
                int min = in.nextInt();
                int max = min;
                for (int l = 2; l <= k; l++) {
                    max = in.nextInt();
                }

                int preMin = dp[j - 1][2];
                int preMax = dp[j - 1][3];
                dp[j][0] = max - min + 1;
                dp[j][1] = max - min + 1;
                if (Math.abs(max - preMin) < Math.abs(max - preMax)) {
                    dp[j][0] += dp[j - 1][0];
                } else {
                    dp[j][0] += dp[j - 1][1];
                }
                if (Math.abs(min - preMin) < Math.abs(min - preMax)) {
                    dp[j][1] += dp[j - 1][0];
                } else {
                    dp[j][1] += dp[j - 1][1];
                }
                dp[j][2] = min;
                dp[j][3] = max;
            }
            System.out.println(Math.min(dp[n][0], dp[n][1]));
        }

    }

    static int mod = 20212021;

    public static int solution() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] dp = new int[n + 1];
        int d = in.nextInt();
        int m = in.nextInt();
        Set<Integer> mines = new HashSet<>();
        for (int i = 0; i < d; i++) {
            mines.add(in.nextInt());
        }
        Map<Integer, Set<Integer>> doors = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            if (!doors.containsKey(end)) {
                doors.put(end, new HashSet<>());
            }
            doors.get(end).add(start);
        }
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            if (mines.contains(i)) {
                dp[i] = 0;
                continue;
            }
            if (doors.containsKey(i)) {
                for (int start : doors.get(i)) {
                    if (!mines.contains(start)) {
                        dp[i] = (dp[i] + dp[start]) % mod;
                    }
                }
            }
            if (i - 1 >= 0 && !mines.contains(i - 1)) {
                dp[i] = (dp[i] + dp[i - 1]) % mod;
            }
            if (i - 2 >= 0 && !mines.contains(i - 2)) {
                dp[i] = (dp[i] + dp[i - 2]) % mod;
            }
            if (doors.containsKey(i)) {
                if (doors.get(i).contains(i)) {
                    dp[i] = (dp[i] * 2) % mod;
                }
            }
        }

        return dp[n] + dp[n - 1];
    }


    public static int compare(String v1, String v2) {
        String[] str1 = v1.split("\\.");
        String[] str2 = v2.split("\\.");
        int i = 0;
        int j = 0;
        while (i < str1.length && j < str2.length) {
            int num1 = Integer.parseInt(str1[i]);
            int num2 = Integer.parseInt(str2[j]);
            if (num1 != num2) {
                if (num1 > num2) {
                    return 1;
                } else {
                    return -1;
                }
            }
            i++;
            j++;
        }
        while (i < str1.length) {
            int num = Integer.parseInt(str1[i]);
            if (num > 0) {
                return 1;
            }
            i++;
        }
        while (j < str2.length) {
            int num = Integer.parseInt(str2[j]);
            if (num > 0) {
                return -1;
            }
            j++;
        }
        return 0;
    }


    public static int compareInt(String num1, String num2) {
        return 0;
    }

    public static int longest(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() < 2) {
            return s.length();
        }
        int len = s.length();
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                    }
                }
            }
        }
        return maxLen;
    }


    public static void solution111() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(" ");
        int[] nodes = new int[strs.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = Integer.parseInt(strs[i]);
        }
        for (int i = 0; i < nodes.length - 1; i++) {
            if (nodes[i] < nodes[i + 1]) {
                System.out.print(nodes[i] + " ");
            }
        }
        System.out.print(nodes[nodes.length - 1]);
    }

    public static String getNum(String num, int n) {
        String temp = num;
        int i = 0;
        while (!"0".equals(temp) && !isOdd(temp)) {
            temp = divide(temp);
            i++;
        }
        while (!"0".equals(temp) && isOdd(temp)) {
            temp = divide(temp);
            i++;
        }
        if (i > n) {
            return "0";
        }
        return sub(add(num, i), i - 1);
    }

    public static String add(String num, int i) {
        String n = String.valueOf(1 << i);
        StringBuilder builder = new StringBuilder();
        int j = num.length() - 1;
        int k = n.length() - 1;
        int carry = 0;
        while (j >= 0 && k >= 0) {
            int a = num.charAt(j) - '0';
            int b = n.charAt(k) - '0';
            int sum = a + b + carry;
            carry = sum / 10;
            builder.append(sum % 10);
            j--;
            k--;
        }
        while (j >= 0) {
            int a = num.charAt(j) - '0';
            int sum = a + carry;
            carry = sum / 10;
            builder.append(sum % 10);
            j--;
        }
        return builder.reverse().toString();
    }

    public static String sub(String num, int i) {
        String n = String.valueOf(1 << i);
        StringBuilder builder = new StringBuilder();
        int j = num.length() - 1;
        int k = n.length() - 1;
        int carry = 0;
        while (j >= 0 && k >= 0) {
            int a = num.charAt(j) - '0' - carry;
            int b = n.charAt(k) - '0';
            if (a >= b) {
                builder.append(a - b);
                carry = 0;
            } else {
                builder.append(a + 10 - b);
                carry = 1;
            }
            j--;
            k--;
        }
        while (j >= 0) {
            int a = num.charAt(j) - '0' - carry;
            builder.append(a);
            carry = 0;
            j--;
        }
        return builder.reverse().toString();
    }


    public static boolean isOdd(String num) {
        int n = num.length() - 1;
        int c = num.charAt(n) - '0';
        return c % 2 == 1;
    }

    public static String divide(String num) {
        int[] res = new int[num.length()];
        int carry = 0;
        int i = 0;
        while (i < num.length()) {
            char c = num.charAt(i);
            int n = c - '0' + carry * 10;
            carry = n % 2;
            res[i] = n / 2 + '0';
            i++;
        }
        i = 0;
        while (i < res.length && res[i] == '0') {
            i++;
        }
        if (i == res.length) {
            return "0";
        }
        return new String(res, i, res.length - i);
    }


    @Test
    public void test() {
        System.out.println(isOdd("1112"));
        System.out.println(add("1234", 5));
        System.out.println(sub("1234", 3));
    }


    public static int[] solution(int[] books, int[] acmers) {
        Arrays.sort(books);
        boolean[] flag = new boolean[books.length];
        int[] res = new int[acmers.length];
        for (int i = 0; i < acmers.length; i++) {
            int index = binarySearch(books, acmers[i]);
            if (index == books.length) {
                res[i] = -1;
            } else if (!flag[index] && books[index] >= acmers[i]) {
                res[i] = books[index];
                flag[index] = true;
            } else {
                res[i] = -1;
            }
        }
        return res;
    }

    public static int binarySearch(int[] books, int acmer) {
        int left = 0;
        int right = books.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (books[mid] < acmer) {
                left = mid + 1;
            } else if (books[mid] >= acmer) {
                right = mid;
            }
        }
        return left;
    }
}

