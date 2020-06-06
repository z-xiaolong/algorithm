package AcWing;

import java.util.Scanner;


/**
 * @Author long
 * @Date 2020/5/14 21:35
 * @Title AcWing 气球游戏
 * @Description 滑动窗口
 **/

public class BalloonGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int[] balloons = new int[m + 1];
        balloons[0] = m + 1;
        int left = 0;
        int min = n + 1;
        int size = 0;
        for (int i = 0; i < n; i++) {
            if (balloons[nums[i]] == 0) size++;
            balloons[nums[i]]++;
            while (size == m) {
                min = Math.min(min, i - left + 1);
                if (balloons[nums[left]] == 1) size--;
                balloons[nums[left]]--;
                left++;
            }
        }
        if (min == n + 1) min = -1;
        System.out.println(min);
    }
}
