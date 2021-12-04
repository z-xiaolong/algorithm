package leetcode.medium;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2021/11/18 9:48
 * @Title
 * @Description //TODO
 **/

public class FindRadius {

    public static void main(String[] args) {
        FindRadius findRadius = new FindRadius();
        findRadius.findRadius(new int[]{1}, new int[]{1, 2, 3, 4});
    }

    public int findRadius(int[] houses, int[] heaters) {
        int n = houses.length;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int left = 0;
        int right = Math.max(Math.abs(heaters[0] - houses[0]),
                Math.abs(heaters[0] - houses[n - 1]));
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (valid(houses, heaters, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean valid(int[] houses, int[] heaters, int radius) {
        int n = houses.length;
        int m = heaters.length;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (houses[i] < heaters[j] - radius) {
                return false;
            } else if (houses[i] > heaters[j] + radius) {
                j++;
            } else {
                i++;
            }
        }
        return i == n;
    }
}
