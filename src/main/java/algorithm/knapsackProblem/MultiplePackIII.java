package algorithm.knapsackProblem;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/4/24 23:23
 * @Title 多重背包问题III
 * @Description //TODO
 **/

public class MultiplePackIII {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int V = in.nextInt();
        int[] v = new int[N + 1];
        int[] w = new int[N + 1];
        int[] s = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
            s[i] = in.nextInt();
        }
        System.out.println(multiplePack(v, w, s, N, V));
    }


    public static int multiplePack(int[] v, int[] w, int[] s, int N, int V) {
        return 0;
    }
}
