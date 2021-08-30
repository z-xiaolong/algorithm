package exam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * @Author: long
 * @Date: 2020/9/16 20:58
 * @Title
 * @Description:
 */
public class TianYiYun {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> min = new Stack<>();
        min.push(Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            if (line.contains("push")) {
                int num = Integer.parseInt(line.split(" ")[1]);
                if (min.peek() >= num) min.push(num);
                stack.push(num);
            } else if ("getMin".equals(line)) {
                System.out.println(min.peek());
            } else if ("pop".equals(line)) {
                int num = stack.pop();
                if (min.peek() == num) min.pop();
                //System.out.println(num);
            } else if ("top".equals(line)) {
                System.out.println(stack.peek());
            }
        }
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int[] map = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map[c - 'a']++;
        }
        Set<Character> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0) continue;
            if (min > map[i]) {
                min = map[i];
                set.clear();
                set.add((char) (i + 'a'));
            } else if (min == map[i]) {
                set.add((char) (i + 'a'));
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!set.contains(c)) {
                builder.append(c);
            }
        }
        System.out.println(builder.toString());
    }


    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int a = 0;
        int b = 0;
        int c = 0;
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        System.out.println(dp[N - 1]);
    }
}
