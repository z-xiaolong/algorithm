package exam;

import java.util.Scanner;

/**
 * @Author long
 * @Date 2021/9/27 19:55
 * @Title
 * @Description //TODO
 **/

public class Xunlei {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int n = line.length();
        line = line.substring(1, n - 1);
        String[] nums = line.split(",");
        n = nums.length;
        int[] cnt = new int[n + 1];
        cnt[0] = Integer.MIN_VALUE;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(nums[i].trim());
            if (cnt[max] < num) {
                cnt[++max] = num;
            } else {
                int left = 0;
                int right = max;
                while (left < right) {
                    int mid = (right + left) / 2;
                    if (num > cnt[mid]) {
                        right = mid;
                    } else if (num < cnt[mid]) {
                        left = mid + 1;
                    } else {
                        left = mid;
                        break;
                    }
                }
                cnt[left] = num;
            }
        }
        System.out.println(max);
    }

}
