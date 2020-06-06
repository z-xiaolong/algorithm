package exam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/4/26 20:01
 * @Title
 * @Description //TODO
 **/

public class Tencent {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int n = in.nextInt();
            int[][] A = new int[n][2];
            int[][] B = new int[n][2];
            for (int j = 0; j < n; j++) {
                A[j][0] = in.nextInt();
                A[j][1] = in.nextInt();
            }
            for (int j = 0; j < n; j++) {
                B[j][0] = in.nextInt();
                B[j][1] = in.nextInt();
            }
            double res = minDistance(A, B);
            System.out.println(String.format("%.3f", res));
        }
    }

    public static double minDistance(int[][] A, int[][] B) {
        double distance = Double.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                double d = getDistance(A[i][0], A[i][1], B[j][0], B[j][1]);
                distance = Math.min(d, distance);
                if(distance == 0) return distance;
            }
        }
        return distance;
    }

    public static double getDistance(int x, int y, int a, int b) {
        int res = (x - a) * (x - a) + (y - b) * (y - b);
        return Math.sqrt(res);
    }


}
