package exam;

import java.util.Scanner;

/**
 * @Author long
 * @Date 2021/9/1 21:38
 * @Title
 * @Description //TODO
 **/

public class FinTech {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int level = 0;
        int right = 0;
        int left = 0;
        while (right < m) {
            left = right;
            right += (n - level * 2 - 1) * 4;
            if (n - level * 2 - 1 == 0) right++;
            level++;
        }
        level--;
        left++;
        int k = n - level * 2 - 1;
        int i = level + 1;
        int j = level + 1;
        if (k == 0) {
            System.out.println(i + " " + j);
            return;
        }
        int sub = m - left;
        if (sub / k == 0) {
            i += sub % k;
        } else if (sub / k == 1) {
            i = n - level;
            j += sub % k;
        } else if (sub / k == 2) {
            j = n - level;
            i = n - sub % k - level;
        } else if (sub / k == 3) {
            j = n - sub % k - level;
        }
        System.out.println(i + " " + j);
    }
}
