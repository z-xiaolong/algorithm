package exam;

import java.util.Scanner;

/**
 * @Author: long
 * @Date: 2020/9/13 18:53
 * @Title
 * @Description:
 */
public class WangYi2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int t = in.nextInt();
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = in.nextInt();
        }

        int[][] timeUpdate = new int[n - 1][n];
        int[][] timeCost = new int[n - 1][n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                timeUpdate[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                timeCost[i][j] = in.nextInt();
            }
        }
    }
}
