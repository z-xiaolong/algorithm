package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: long
 * @Date: 2020/8/10 19:24
 * @Title
 * @Description:
 */
public class Dji {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        int[] alphabet = new int[128];
        String[] table = new String[N];
        for (int i = 0; i < N; i++) {
            String s = in.nextLine();
            table[i] = s;
            for (int j = 0; j < s.length(); j++) {
                alphabet[s.charAt(j)]++;
            }
        }
        int M = Integer.parseInt(in.nextLine());
        List<String> list = new ArrayList<>();
        boolean[][] indicate = new boolean[N][256];
        for (int i = 0; i < M; i++) {
            String s = in.nextLine();
            int[] temp = Arrays.copyOf(alphabet, alphabet.length);
            boolean flag = true;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (temp[c] > 0) {
                    temp[c]--;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag && check(table, indicate, s)) {
                list.add(s);
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        for (String s : res) {
            System.out.println(s);
        }
    }

    public static boolean check(String[] alphabet, boolean[][] indicate, String s) {
        char c = s.charAt(0);
        for (int i = 0; i < alphabet.length; i++) {
            String str = alphabet[i];
            for (int j = 0; j < str.length(); j++) {
                if (c == alphabet[j].charAt(j)) {
                    if (dfs(alphabet, indicate, i, j, s, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(String[] alphabet, boolean[][] indicate, int i, int j, String s, int index) {
        if (index == s.length()) return true;
        int n = alphabet.length;
        boolean res = false;
        indicate[i][j] = true;
        if (i + 1 < n) {
            String str = alphabet[i + 1];
            if (str.length() > j && str.charAt(j) == s.charAt(index) && !indicate[i + 1][j]) {
                res = res || dfs(alphabet, indicate, i + 1, j, s, index + 1);
            }
        }
        if (i - 1 >= 0) {
            String str = alphabet[i - 1];
            if (j < str.length() && str.charAt(j) == s.charAt(index) && !indicate[i - 1][j]) {
                res = res || dfs(alphabet, indicate, i - 1, j, s, index + 1);
            }
        }
        String str = alphabet[i];
        if (j + 1 < str.length() && str.charAt(j + 1) == s.charAt(index) && !indicate[i][j + 1]) {
            res = res || dfs(alphabet, indicate, i, j + 1, s, index + 1);
        }
        if (j - 1 >= 0 && str.charAt(j - 1) == s.charAt(index) && !indicate[i][j - 1]) {
            res = res || dfs(alphabet, indicate, i, j - 1, s, index + 1);
        }
        indicate[i][j] = false;
        return res;
    }


    public static int multiplePack(int[] v, int[] l, int[] c, int N, int T) {
        int[] dp = new int[T + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = T; j >= v[i]; j--) {
                for (int k = 1; k <= c[i] && k * v[i] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * l[i]);
                }
            }
        }
        return dp[T];
    }

    /*public static int multiplePack(int[] v, int[] w, int[] s, int N, int V) {
        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= v[i]; j--) {
                for (int k = 1; k <= s[i] && k * v[i] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                }
            }
        }
        return dp[V];
    }*/

    public static void solution() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int A = in.nextInt();
        int X = in.nextInt();
        int time = 0;
        int product = 60 * A;
        int bug = 0;
        for (int i = 0; i < N; i++) {
            bug += in.nextInt();
            if (X > 0 && bug >= product) {
                time += 60;
                bug -= product;
                X--;
            }
        }
        while (X > 0 && bug >= product) {
            time += 60;
            bug -= product;
            X--;
        }
        if (X > 0 && bug > 0) {
            if (bug % A == 0) {
                time += bug / A;
            } else {
                time += bug / A + 1;
            }
        } else if (bug > 0) {
            time += bug;
        }
        if (time >= 480) {
            System.out.println(0);
        } else {
            System.out.println(time);
        }
    }
}
