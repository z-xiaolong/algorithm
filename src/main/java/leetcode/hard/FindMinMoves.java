package leetcode.hard;

/**
 * @Author long
 * @Date 2021/9/29 10:16
 * @Title
 * @Description //TODO
 **/

public class FindMinMoves {

    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int total = 0;
        for (int machine : machines) {
            total += machine;
        }
        if (total % n != 0) return -1;
        int avg = total / n;
        int sum = 0;
        int ans = 0;
        for (int num : machines) {
            num -= avg;
            sum += num;
            ans = Math.max(ans, Math.max(Math.abs(sum), num));
        }
        return ans;
    }
}
