package exam;

import java.util.Scanner;

/**
 * @Author: long
 * @Date: 2020/9/5 20:18
 * @Title
 * @Description:
 */
public class GaoTu {

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int target = Integer.parseInt(in.nextLine());
        String[] strs = line.split(" ");
        int n = strs.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(binarySearch(nums, target));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int right = M;
        int left = 1;
        if (N == M) {
            System.out.println(1);
            return;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, N, M)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (check(left + 1, N, M)) left++;
        System.out.println(left);
    }


    public static boolean check(int mid, int N, int M) {
        while (N > 0 && mid > 0) {
            M -= mid;
            if (mid % 2 == 0) mid /= 2;
            else mid = mid / 2 + 1;
            N--;
        }
        return M >= 0;
    }


    public static int binarySearch1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] < target) left++;
        return left;
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        if (nums[left] < target) left++;
        return left;
    }
}
