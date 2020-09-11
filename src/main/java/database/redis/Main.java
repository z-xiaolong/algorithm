package database.redis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.ArrayList;
import java.util.*;

/**
 * @Author: long
 * @Date: 2020/9/8 15:31
 * @Title
 * @Description:
 */
public class Main {

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> output = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                output.add(num);
                continue;
            }
            set.add(num);
        }
        for (int num : output) {
            System.out.print(num + " ");
        }
    }


    public static void main1(String[] args) {
        /*Integer a = new Integer(100);
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.remove(1);
        Jedis jedis = new Jedis("192.168.1.87", 6379);
        jedis.auth("long297993231");
        System.out.println(jedis.ping());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "world");
        jsonObject.put("long", "long");

        String str = jsonObject.toJSONString();
        System.out.println(str);
        Transaction multi = jedis.multi();

        multi.set("user1", str);
        multi.set("user2", str);
        multi.exec();

        System.out.println(jedis.get("user1"));
        jedis.close();*/

        String a = "a";
        String b = "b";
        String c = "c";
        String s = "abc";
        String f = "ab" + c;
        String g = "abc";
        String str = "abc" + "def";
        String d = a + b + c;
        System.out.println(s == d);
        System.out.println(f == s);
        System.out.println(s == g);
    }


    public String strFlip(String str) {
        String[] strs = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = strs.length - 1; i > 0; i--) {
            builder.append(strs[i]).append(" ");
        }
        builder.append(strs[0]);
        return builder.toString();
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.nQueens(1));
    }


    public int nQueens(int n) {
        int[] rows = new int[n];
        int[] hills = new int[4 * n - 1];
        int[] dales = new int[2 * n - 1];
        return dfs(0, 0, n, rows, hills, dales);
    }


    public int dfs(int row, int count, int n, int[] rows, int[] hills, int[] dales) {
        for (int col = 0; col < n; col++) {
            if (check(row, col, n, rows, hills, dales)) {
                rows[col] = 1;
                hills[row - col + 2 * n] = 1;
                dales[row + col] = 1;

                if (row + 1 == n) count++;
                else count = dfs(row + 1, count, n, rows, hills, dales);
                rows[col] = 0;
                hills[row - col + 2 * n] = 0;
                dales[row + col] = 0;
            }
        }
        return count;
    }


    public boolean check(int row, int col, int n, int[] rows, int[] hills, int[] dales) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return res == 0;
    }


    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; i++) {
            res = res ^ (start + 2 * i);
        }
        return res;
    }


    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - 'a';
        }
        long mod = (long) Math.pow(2, 32);
        int left = 1;
        int right = n;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (search(mid, mod, n, nums) != -1)
                left = mid + 1;
            else right = mid;
        }
        int start = search(left - 1, mod, n, nums);
        if (start == -1) return 0;
        else return left - 1;
    }


    public int search(int mid, long mod, int n, int[] nums) {
        long h = 0;
        for (int i = 0; i < mid; i++) {
            h = (h * 26 + nums[i]) % mod;
        }
        Set<Long> set = new HashSet<>();
        set.add(h);
        long m = 1;
        for (int i = 1; i <= mid; i++) {
            m = (m * 26) % mod;
        }
        for (int start = 1; start < n - mid; start++) {
            h = (h * 26 - nums[start - 1] * m % mod + mod) % mod;
            h = (h + nums[start + mid - 1]) % mod;
            if (set.contains(h)) return start;
            set.add(h);
        }
        return -1;
    }


    public int numFriendRequests(int[] ages) {
        int count = 0;
        for (int i = 0; i < ages.length; i++) {
            for (int j = i + 1; j < ages.length; j++) {
                if (check(i, j, ages)) count++;
                if (check(j, i, ages)) count++;
            }
        }
        return count;
    }

    public boolean check(int A, int B, int[] ages) {
        return ages[B] > ages[A] / 2 + 7 && ages[B] <= ages[A] && (ages[B] <= 100 || ages[A] >= 100);
    }

}
