package exam;

import java.util.*;

/**
 * @Author: long
 * @Date: 2020/8/22 20:11
 * @Title
 * @Description:
 */
public class Exam360 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] task = new int[n][2];
        for (int i = 0; i < n; i++) {
            task[i][0] = in.nextInt();
            task[i][1] = in.nextInt();
        }
        Arrays.sort(task, (o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (task[i][1] == 0) sum += task[i][0];
            else {
                if (sum <= task[i][0]) {
                    sum += task[i][0];
                } else {
                    sum = sum * 2;
                }
            }
        }
        System.out.println(sum);
    }


    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (l != r) return false;
            left++;
            right--;
        }
        return true;
    }


    public static boolean check(String name) {
        if (name.length() > 10) return false;
        int i = 0;
        name = name.toLowerCase();
        while (i < name.length()) {
            char c = name.charAt(i);
            if (c < 'a' || c > 'z') return false;
            i++;
        }
        return true;
    }
}
