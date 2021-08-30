package leetcode.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author long
 * @Date 2020/10/25 10:13
 * @Title
 * @Description //TODO
 **/

public class Contest212 {
    public static void main(String[] args) {
        Contest212 contest212 = new Contest212();
        int[][] heights = new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        contest212.minimumEffortPath(heights);
    }


    private int min = Integer.MAX_VALUE;

    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] height : heights) {
            for (int j = 0; j < c; j++) {
                min = Math.min(min, height[j]);
                max = Math.max(max, height[j]);
            }
        }
        int left = 0;
        int right = max - min;
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean[][] flag = new boolean[r][c];
            if (dfs(heights, flag, 0, 0, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        boolean[][] flag = new boolean[r][c];
        if (dfs(heights, flag, 0, 0, left + 1)) {
            left++;
        }
        return left;
    }

    public boolean dfs(int[][] heights, boolean[][] flag, int i, int j, int cost) {
        int r = heights.length;
        int c = heights[0].length;
        if (i == r - 1 && j == c - 1) {
            return true;
        }
        flag[i][j] = true;
        int height = heights[i][j];
        if (i + 1 < r && !flag[i + 1][j]) {
            if (Math.abs(height - heights[i + 1][j]) <= cost
                    && dfs(heights, flag, i + 1, j, cost)) {
                return true;
            }
        }
        if (i - 1 >= 0 && !flag[i - 1][j]) {
            if (Math.abs(height - heights[i - 1][j]) <= cost
                    && dfs(heights, flag, i - 1, j, cost)) {
                return true;
            }
        }
        if (j + 1 < c && !flag[i][j + 1]) {
            if (Math.abs(height - heights[i][j + 1]) <= cost
                    && dfs(heights, flag, i, j + 1, cost)) {
                return true;
            }
        }
        if (j - 1 >= 0 && !flag[i][j - 1]) {
            if (Math.abs(height - heights[i][j - 1]) <= cost
                    && dfs(heights, flag, i, j - 1, cost)) {
                return true;
            }
        }
        //flag[i][j] = false;
        return false;
    }

    public void dfs(boolean[][] flag, int[][] heights, int i, int j, int dif) {
        int r = heights.length;
        int c = heights[0].length;
        if (dif > min) {
            return;
        }
        if (i == r - 1 && j == c - 1) {
            min = dif;
            return;
        }
        flag[i][j] = true;
        int height = heights[i][j];
        if (i + 1 < r && !flag[i + 1][j]) {
            int tmp = Math.max(dif, Math.abs(height - heights[i + 1][j]));
            dfs(flag, heights, i + 1, j, tmp);
        }
        if (i - 1 >= 0 && !flag[i - 1][j]) {
            int tmp = Math.max(dif, Math.abs(height - heights[i - 1][j]));
            dfs(flag, heights, i - 1, j, tmp);
        }
        if (j + 1 < c && !flag[i][j + 1]) {
            int tmp = Math.max(dif, Math.abs(height - heights[i][j + 1]));
            dfs(flag, heights, i, j + 1, tmp);
        }
        if (j - 1 >= 0 && !flag[i][j - 1]) {
            int tmp = Math.max(dif, Math.abs(height - heights[i][j - 1]));
            dfs(flag, heights, i, j - 1, tmp);
        }
        flag[i][j] = false;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = l.length;
        List<Boolean> res = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int left = l[i];
            int right = r[i];
            res.add(check(getSubArray(nums, left, right)));
        }
        return res;
    }

    public int[] getSubArray(int[] nums, int left, int right) {
        int len = right - left;
        int[] newArray = new int[len + 1];
        for (int i = left, j = 0; i <= right; i++, j++) {
            newArray[j] = nums[i];
        }
        Arrays.sort(newArray);
        return newArray;
    }

    public boolean check(int[] sub) {
        int dis = sub[1] - sub[0];
        for (int i = 1; i < sub.length; i++) {
            if ((sub[i] - sub[i - 1]) != dis) {
                return false;
            }
        }
        return true;
    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char c = 0;
        int maxTime = 0;
        for (int i = 0; i < releaseTimes.length; i++) {
            int time;
            if (i > 0) {
                time = releaseTimes[i] - releaseTimes[i - 1];
            } else {
                time = releaseTimes[i];
            }
            if (maxTime < time) {
                maxTime = time;
                c = keysPressed.charAt(i);
            } else if (maxTime == time && keysPressed.charAt(i) > c) {
                c = keysPressed.charAt(i);
            }
        }
        return c;
    }
}
