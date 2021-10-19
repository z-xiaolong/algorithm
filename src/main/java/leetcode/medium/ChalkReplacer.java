package leetcode.medium;

/**
 * @Author long
 * @Date 2021/9/10 10:11
 * @Title
 * @Description //TODO
 **/

public class ChalkReplacer {

    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0L;
        for (int c : chalk) {
            sum += c;
        }
        if (sum == 0) return -1;
        k = (int) (k % sum);
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) return i;
            k -= chalk[i];
        }
        return -1;
    }
}
