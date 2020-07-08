package leetcode.contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author long
 * @Date 2020/6/28 9:45
 * @Title
 * @Description //TODO
 **/

public class Contest195 {


    //5448. 判断路径是否相交

    int x = 0;
    int y = 0;

    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        set.add("0,0");
        for (int i = 0; i < path.length(); i++) {
            String p = getPath(path, i);
            if (set.contains(p)) return true;
            set.add(p);
        }
        return false;
    }

    public String getPath(String path, int index) {
        char c = path.charAt(index);
        switch (c) {
            case 'N':
                x--;
                break;
            case 'S':
                x++;
                break;
            case 'E':
                y++;
                break;
            case 'W':
                y--;
                break;
        }
        return x + "," + y;
    }


    public boolean canArrange(int[] arr, int k) {
        int[] dp = new int[k];
        for (int a : arr) {
            if (a >= 0) dp[a % k]++;
            else dp[(a % k + k) % k]++;
        }
        if (dp[0] % 2 != 0) return false;
        for (int i = 1; i <= k / 2; i++) {
            if (dp[i] != dp[k - i]) return false;
        }
        return true;
    }

    public int numSubseq(int[] nums, int target) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                sum++;
                for (int j = i + 1; j < nums.length; j++) {

                }
            }
        }
        return (int) (sum % 1000000007);
    }

    public static void main(String[] args) {
        Contest195 contest195 = new Contest195();

        contest195.canArrange(new int[]{-1, 1, -2, 2, -3, 3, -4, 4}, 3);
    }
}
