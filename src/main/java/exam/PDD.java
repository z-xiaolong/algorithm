package exam;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author: long
 * @Date: 2020/8/2 18:41
 * @Title
 * @Description:
 */
public class PDD {

    public static void main(String[] args) {
        solution2();
    }


    public static void solution3() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] matrix = new int[M];
        for (int i = 0; i < M; i++) {
            matrix[i] = in.nextInt();
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int value : matrix) {
                if (i % value == 0) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }


    public static void solution2() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] c = new int[N + 1];
        int[] v = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            c[i] = in.nextInt();
            v[i] = in.nextInt();
        }

        int[] dp = new int[5050];
        int maxM = M;
        for (int i = 1; i <= N; i++) {
            if (c[i] < 0) {
                for (int j = maxM; j >= 0; j--) {
                    dp[j] = Math.max(dp[j], dp[j - c[i]] + v[i]);
                    maxM = Math.max(maxM, maxM - c[i]);
                }
            } else {
                for (int j = maxM; j >= c[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - c[i]] + v[i]);
                    maxM = Math.max(maxM, maxM - c[i]);
                }
            }

        }
        for (int a : dp) {
            System.out.println(a + " ");
        }
    }

    public static void solution1() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

    }


    public static void solution() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i; j++) {
                if (j < n / 2) matrix[i][j] = 2;
                else matrix[i][j] = 1;
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i; j++) {
                if (j < n / 2) matrix[j][i] = 3;
                else matrix[j][i] = 4;
            }
        }

        for (int i = n / 2 + 1; i < n; i++) {
            for (int j = n - i; j < i; j++) {
                if (j < n / 2) matrix[i][j] = 5;
                else matrix[i][j] = 6;
            }
        }

        for (int i = n / 2 + 1; i < n; i++) {
            for (int j = n - i; j < i; j++) {
                if (j < n / 2) matrix[j][i] = 8;
                else matrix[j][i] = 7;
            }
        }
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                matrix[n / 2][i] = 0;
                matrix[i][n / 2] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 0;
            matrix[n - i - 1][i] = 0;
        }

        for (int[] col : matrix) {
            for (int num : col) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void fill(int[][] matrix, int c, int r, int a, int b) {

    }

    public static void solution11() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] num = new int[N][6];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 6; j++) {
                num[i][j] = in.nextInt();
            }
        }

    }

    public static void solution10() {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        int N = in.nextInt();
        int[] D = new int[N];
        for (int i = 0; i < N; i++) {
            D[i] = in.nextInt();
        }
        int count = 0;
        for (int d : D) {
            K -= d;
            if (K == 0) {
                System.out.println("paradox");
                return;
            }
            if (K < 0) {
                K = -K;
                count++;
            }
        }
        System.out.println(K + " " + count);
    }


    public static void solution12() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int T = in.nextInt();

        int[][] Vn = new int[N][2];
        int[][] costVn = new int[N][2];
        int[][] Vm = new int[M][2];
        int[][] costVm = new int[M][2];


        for (int i = 0; i < N; i++) {
            Vn[i][0] = in.nextInt();
            costVn[i][0] = Vn[i][0];
            Vn[i][1] = in.nextInt();
            costVn[i][1] = Vn[i][1];
        }
        for (int i = 0; i < M; i++) {
            Vm[i][0] = in.nextInt();
            costVm[i][0] = Vm[i][0];
            costVm[i][1] = Vm[i][1];
            Vm[i][1] = in.nextInt();
        }
        if (T == 0) {
            System.out.println(0);
            return;
        }
        Arrays.sort(Vn, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(costVn, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(Vm, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(costVm, Comparator.comparingInt(o -> o[0]));
        if (Vm[M - 1][1] + Vn[N - 1][1] < T) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < N; i++) {
            int cost = costVn[i][0];
            int s = costVn[i][1];

        }

        int min = dinner(Vm, T);
        for (int i = N - 1; i >= 0; i--) {
            int cost = Vn[i][0];
            if (T > Vn[i][1] && T - Vn[i][1] <= Vm[M - 1][1]) {
                cost += dinner(Vm, T - Vn[i][1]);
            }
            min = Math.min(min, cost);
        }
        System.out.println(min);
    }

    public static int dinner(int[][] V, int k) {
        int mid = binarySearch(V, k);
        int min = Integer.MAX_VALUE;
        for (int i = mid; i < V.length; i++) {
            if (V[i][1] >= k) {
                min = Math.min(min, V[i][0]);
            }
        }
        return min;
    }

    public static int binarySearch(int[][] V, int k) {
        int left = 0;
        int right = V.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (V[mid][1] < k) {
                left = mid + 1;
            } else if (V[mid][1] >= k) {
                right = mid;
            }
        }
        return left;
    }

    static int mod = 1000000009;
    static long res = 1;

    public static void solution13() {

        Scanner in = new Scanner(System.in);
        String[] data = new String[6];
        for (int i = 0; i < data.length; i++) {
            data[i] = in.nextLine();
        }
        char[][] map = new char[6][6];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = data[i].charAt(j);
            }
        }
        int[] dp = new int[6];
        for (int i = 0; i < 6; i++) {
            if (map[0][i] == '#') {
                int count = 0;
                if (i > 0 && map[i][i - 1] == '#') count++;
                dp[i] = 6 - count;
            } else dp[i] = 1;
        }
        product(dp);
        for (int i = 1; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == '#') {
                    int count = 0;
                    if (j > 0 && map[i][j - 1] == '#') count++;
                    if (map[i - 1][j] == '#') count++;
                    dp[j] = 6 - count;
                } else dp[i] = 1;
            }
            product(dp);
        }
        System.out.println(res);
    }

    public static void product(int[] num) {
        for (int value : num) {
            res *= value;
            res = res % mod;
        }
    }

    public static void dfs(char[][] map, boolean[][] flag, int i, int j) {
        int count = 0;
        flag[i][j] = true;
        if (i + 1 < 6 && map[i + 1][j] == '#') {
            if (!flag[i + 1][j])
                dfs(map, flag, i + 1, j);
            else count++;
        }
        if (i - 1 >= 0 && map[i - 1][j] == '#') {
            if (!flag[i - 1][j])
                dfs(map, flag, i - 1, j);
            else count++;
        }
        if (j + 1 < 6 && map[i][j + 1] == '#') {
            if (!flag[i][j + 1]) {
                dfs(map, flag, i, j + 1);
            } else count++;
        }
        if (j - 1 >= 0 && map[i][j - 1] == '#') {
            if (!flag[i][j - 1]) {
                dfs(map, flag, i, j - 1);
            } else count++;
        }
        res *= (6 - count);
        res = res % mod;
    }
}
