package exam;

import java.util.*;

/**
 * @Author: long
 * @Date: 2020/8/8 14:26
 * @Title
 * @Description:
 */
public class WangYi {

    public static void main(String[] args) {
        solution2();
        //solution3();
        //solution4();
    }

    //第一题:素数个数
    public static void solution1() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long count = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (num > 1) {
                count += num / 2;
            }
        }
        System.out.println(count);
    }


    //第二题：排列
    public static void solution2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        boolean[] flag = new boolean[n + 2];
        int[] res = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int num = in.nextInt();
            list.add(num);
            flag[num] = true;
        }
        list.add(n + 1);
        int i = 1;
        int j = 1;
        int num = list.peekFirst();
        while (j <= n + 1 && i <= n && list.size() > 0) {
            while (j <= n + 1 && flag[j]) j++;
            if (j <= n + 1 && num < j) {
                res[i++] = num;
                list.poll();
                num = list.peekFirst();
            } else if (j <= n + 1) {
                res[i++] = j;
                flag[j] = true;
            }
        }
        for (int k = 1; k <= n - 1; k++) {
            System.out.print(res[k] + " ");
        }
        System.out.print(res[n]);
    }

    //第三题
    public static void solution3() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int[] goods = new int[n];
            for (int j = 0; j < n; j++) {
                goods[j] = in.nextInt();
            }
            System.out.println(abandon(goods));
        }
    }

    public static int abandon(int[] goods) {
        Arrays.sort(goods);
        int n = goods.length;
        boolean[] flag = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            if (!flag[i]) {
                if (dfs(goods, flag, i - 1, goods[i])) {
                    flag[i] = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!flag[i]) {
                count += goods[i];
            }
        }
        return count;
    }

    public static boolean dfs(int[] goods, boolean[] flag, int index, int value) {
        if (index < 0) return false;
        for (int i = index; i >= 0; i--) {
            if (goods[i] == value && !flag[i]) {
                flag[i] = true;
                return true;
            } else if (goods[i] < value && !flag[i]) {
                boolean res = dfs(goods, flag, i - 1, value - goods[i]);
                if (res) {
                    flag[i] = true;
                    return true;
                }
            }
        }
        return false;
    }


    //第四题
    public static void solution4() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] map = new int[n + 1][n + 1];
        for (int k = 0; k < m; k++) {
            int i = in.nextInt();
            int j = in.nextInt();
            map[i][j] = in.nextInt();
        }
    }
}
