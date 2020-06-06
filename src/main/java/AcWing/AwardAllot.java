package AcWing;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/5/14 22:17
 * @Title 奖品分配  头条2019
 * @Description //TODO
 **/

public class AwardAllot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }
            int[] awards = new int[n];
            for (int j = 0; j < n; j++) {
                dfs(a, awards, j);
            }
            int sum = 0;
            for (int award : awards) {
                sum += award;
            }
            System.out.println(sum);
        }
    }

    public static int dfs(int[] a, int[] award, int m) {
        int n = a.length;
        if (award[m] != 0) return award[m];
        if (a[(n + m - 1) % n] >= a[m] && a[(n + m + 1) % n] >= a[m]) {
            award[m] = 1;
            return award[m];
        }
        int v = 0;
        if (a[(n + m - 1) % n] < a[m])
            v = dfs(a, award, (n + m - 1) % n);
        if (a[(n + m + 1) % n] < a[m])
            v = Math.max(v, dfs(a, award, (n + m + 1) % n));
        award[m] = v + 1;
        return award[m];
    }
}
