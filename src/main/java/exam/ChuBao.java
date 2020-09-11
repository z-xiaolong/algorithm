package exam;

import java.util.*;

/**
 * @Author: long
 * @Date: 2020/8/25 18:56
 * @Title
 * @Description:
 */
public class ChuBao {
    public static void main(String[] args) {
        double ms = 1000.0 / 3600.0;
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int[][] signal = new int[n][2];
        for (int i = 0; i < n; i++) {
            signal[i][0] = in.nextInt();
            signal[i][1] = in.nextInt();
        }
        while (s > 0) {
            if (isPass(signal, s * ms)) {
                System.out.println(s);
                return;
            }
            s--;
        }
        System.out.println(-1);
    }

    public static boolean isPass(int[][] signal, double speed) {
        for (int[] doubles : signal) {
            int distance = doubles[0];
            double costTime = distance / speed;
            if (costTime > Math.floor(costTime)) {
                costTime = Math.floor(costTime) + 1;
            }
            int time = doubles[1];
            if (costTime % (2 * time) >= time) return false;
        }
        return true;
    }

    public static void solution4() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(" ");
        int[] xy = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            xy[i] = Integer.parseInt(strs[i]);
        }
        str = in.nextLine();
        strs = str.split(" ");
        int[] yx = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            yx[i] = Integer.parseInt(strs[i]);
        }
        if (yx.length < 2) {
            System.out.println(-1);
            return;
        }
        int min = Integer.MAX_VALUE;
        int[] minYX = new int[yx.length];

        minYX[yx.length - 1] = yx[yx.length - 1];

        for (int i = yx.length - 2; i >= 0; i--) {
            minYX[i] = Math.min(yx[i], minYX[i + 1]);
        }
        for (int i = 0; i < xy.length - 1; i++) {
            min = Math.min(min, minYX[i + 1] + xy[i]);
        }
        System.out.println(min);
    }

    public static void solution() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] cost = new int[N];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = in.nextInt();
        }
        int M = in.nextInt();
        Arrays.sort(cost);
        int count = 0;
        for (int i = N - 1; i > 0; i--) {
            count += cost[i];
        }
        count += cost[0];
        if (count <= M) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
