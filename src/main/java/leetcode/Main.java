package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int k = in.nextInt();
        int[] goods = new int[N];
        for (int i = 0; i < N; i++) {
            goods[i] = in.nextInt();
        }
        System.out.println(solution(N, k, goods));
    }


    public static int solution(int N, int k, int[] goods) {
        Arrays.sort(goods);
        int index = 0;
        int count = 0;
        int n = goods.length;
        while (index + k <= n) {
            if (goods[index] > 0) {
                goods[index]--;
                for (int i = n - 1; i > n - k; i--) {
                    goods[i]--;
                }
                Arrays.sort(goods);
                count++;
            }
            if (goods[index] == 0) index++;
        }
        return count;
    }
}
