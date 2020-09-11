package exam;

import java.util.*;

public class DaJiang {
    static class TrieNode {
        TrieNode[] next = new TrieNode[255];
        String word = null;
        int cnt = 0;
    }

    static List<String> res = new ArrayList<>();
    static int m, n;
    static int[][] dires = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static TrieNode root = new TrieNode();

    public static List<String> sothree(char[][] alp, String[] strs) {
        addStrs(strs);
        m = alp.length;
        n = alp[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (root.next[alp[i][j]] != null) {
                    dfs(alp, i, j, root);
                }
            }
        }
        return res;
    }

    public static void addStrs(String[] strs) {
        for (String str : strs) {
            TrieNode cur = root;
            for (char c : str.toCharArray()) {
                if (cur.next[c] == null) {
                    cur.cnt++;
                    cur.next[c] = new TrieNode();
                }
                cur = cur.next[c];
            }
            cur.word = str;
        }
    }

    public static void dfs(char[][] alp, int i, int j, TrieNode root) {
        char c = alp[i][j];
        TrieNode cur = root.next[c];
        if (cur != null && cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }
        alp[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int newi = i + dires[k][0];
            int newj = j + dires[k][1];
            if (newi < 0 || newi >= m || newj < 0 || newj >= n || alp[newi][newj] == '#') continue;
            if (cur != null) dfs(alp, newi, newj, cur);
        }
        alp[i][j] = c;
        if (cur != null && cur.cnt == 0) {
            root.next[c] = null;
            root.cnt--;
        }
    }

    //第三题
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] before = new String[N];
        for (int i = 0; i < N; i++) {
            before[i] = sc.nextLine();
        }
        char[][] alp = new char[N][255];
        for (int i = 0; i < N; i++) {
            char[] tmp = before[i].toCharArray();
            for (int j = 0; j < 255; j++) {
                if (j < tmp.length) alp[i][j] = tmp[j];
                else alp[i][j] = '#';
            }
        }
        int M = Integer.parseInt(sc.nextLine());
        String[] strs = new String[M];
        for (int i = 0; i < M; i++) {
            strs[i] = sc.nextLine();
        }
        List<String> ans = sothree(alp, strs);
        String[] answ = ans.toArray(new String[ans.size()]);
        Arrays.sort(answ);
        for (int i = 0; i < answ.length; i++) {
            System.out.println(answ[i]);
        }

    }
    //第一题
//    public static void sorts(String[] arr) {
//        for (int i = arr.length - 1; i > 0; i--) {
//            for (int j = 0; j < i; j++){
//                if (arr[j].compareToIgnoreCase(arr[j + 1]) > 0){
//                    String tmp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = tmp;
//                }
//            }
//            for (String s : arr){
//                System.out.println(s);
//            }
//        }
//    }
    //第二题
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int A = sc.nextInt();
//        int X = sc.nextInt();
//        int tol = 0;
//        for (int i = 0; i < N; i++){
//            tol += sc.nextInt();
//        }
//        int res = 0;
//        if (X * 60 * A >= tol) {
//            res = tol / A + (tol % A == 0 ? 0 : 1);
//        } else {
//            res = (tol - X * 60 * A) + X * 60;
//        }
//        if (res <= 480) System.out.println(res);
//        else System.out.println(0);
//    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int T = sc.nextInt();
//        int[] v = new int[N];
//        int[] I = new int[N];
//        int[] c = new int[N];
//        for (int i = 0; i < N; i++){
//            v[i] = sc.nextInt();
//            I[i] = sc.nextInt();
//            c[i] = sc.nextInt();
//        }
//        int[] dp = new int[T+1];
//        for (int i  = 0; i < N; i++) {
//            for (int j = T; j >= 0; j--){
//                for (int k = 0; k <= c[i]; k++){
//                    if (j >= k * v[i]) {
//                        dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * I[i]);
//                    }
//                }
//            }
//        }
//        System.out.println(dp[T]);
//    }
}

