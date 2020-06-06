package exam;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/4/23 18:53
 * @Title
 * @Description //TODO
 **/

public class MeiTuan {


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


    public static void main(String[] args) {
        match();
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
