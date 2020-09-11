package exam;

import java.util.*;

/**
 * @Author long
 * @Date 2020/4/23 18:53
 * @Title
 * @Description //TODO
 **/

public class MeiTuan {


    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int count = 0;
        String start = null;
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            str = str.trim();
            String[] city = str.split("\\s+");
            if (start == null) start = city[0];
            else if (start.equals(city[1])) {
                count++;
                start = null;
            }
        }
        System.out.println(count);
    }*/


    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            union(parent, in.nextInt(), in.nextInt());
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (parent[i] == i) {
                map.put(i, new ArrayList<>());
            }
        }
        for (int i = 1; i <= n; i++) {
            int p = find(parent, i);
            map.get(p).add(i);
        }
        System.out.println(map.size());
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(i)) {
                List<Integer> list = map.get(i);
                Collections.sort(list);
                for (int num : list) {
                    System.out.print(num + " ");
                }
            }
        }
    }*/

    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int[][] profits = new int[n][2];
        for (int i = 0; i < n; i++) {
            profits[i][0] = in.nextInt();
            profits[i][1] = in.nextInt();
        }
        int max = 0;
        Arrays.sort(profits, (o1, o2) -> o2[0] - o1[0]);
        boolean[] flag = new boolean[n];
        int i = 0;
        while (i < n && a > 0) {
            if (profits[i][0] >= profits[i][1]) {
                max += profits[i][0];
                a--;
                flag[i] = true;
            }
            i++;
        }
        while (b > 0) {
            int subMax = Integer.MIN_VALUE;
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (!flag[j]) {
                    if (profits[j][1] > subMax) {
                        subMax = profits[j][1];
                        index = j;
                    }
                }
            }
            flag[index] = true;
            max += subMax;
            b--;
        }
        System.out.println(max);
    }*/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int count = 0;
        int mod = 998244353;
        for (int i = 1; i <= n; i++) {

        }

        System.out.println(count);
    }

    public static void union(int[] parent, int p, int q) {
        if (p == q) return;
        int rootP = find(parent, p);
        int rootQ = find(parent, q);
        if (rootP == rootQ) return;
        if (rootP > rootQ) {
            parent[rootQ] = rootP;
            parent[p] = rootP;
            parent[q] = rootP;
        } else {
            parent[rootP] = rootQ;
            parent[p] = rootQ;
            parent[q] = rootQ;
        }
    }

    public static int find(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public static boolean check(int num1, int num2) {
        if (num1 % 10 == 0 || num2 % 10 == 0) return false;
        StringBuilder builder = new StringBuilder();
        builder.append(num2);
        builder.reverse();
        return String.valueOf(num1).equals(builder.toString());
    }


    public static void star() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] coordinate = new int[n][2];
        for (int i = 0; i < n; i++) {
            coordinate[i] = new int[]{in.nextInt(), in.nextInt()};
        }
    }

    public static void coin() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            System.out.println(format(in.nextLine()));
        }
    }

    public static String format(String str) {
        String[] numbers = str.split("\\.");
        StringBuilder stringBuilder = new StringBuilder();
        String positive = numbers[0];
        String decimal = null;
        if (numbers.length > 1) decimal = numbers[1];
        if (decimal != null) {
            int len = decimal.length();
            while (len > 2) len--;
            if (len == 2) stringBuilder.append(decimal.charAt(1)).append(decimal.charAt(0)).append('.');
            else if (len == 1) stringBuilder.append('0').append(decimal).append('.');
        } else {
            stringBuilder.append("00.");
        }
        int len = positive.length();
        int index = len - 1;
        int count = 1;
        while (index > 0) {
            if (count % 3 == 0) {
                stringBuilder.append(positive.charAt(index)).append(',');
            } else {
                stringBuilder.append(positive.charAt(index));
            }
            index--;
            count++;
        }
        boolean isPositive = true;
        if (positive.charAt(0) == '-') {
            isPositive = false;
            if (len % 3 == 1) stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append('$').append('(');
        } else {
            stringBuilder.append(positive.charAt(0)).append('$');
        }
        stringBuilder.reverse();
        if (!isPositive) {
            stringBuilder.append(')');
        }
        return stringBuilder.toString();
    }


    public static void match() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] == 0) {
                for (int j = 0; j < n; j++) {
                    if (j != i && (array[i] & array[j]) == 0) {
                        dp[i] = 1;
                        dp[j] = 1;
                    }
                }
                if (dp[i] == 0) dp[i] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
    }


    public static boolean and(int i, int j) {
        return (i & j) == 0;
    }
}
