package leetcode.easy;

/**
 * @Author long
 * @Date 2020/7/8 10:13
 * @Title 面试题 16.11. 跳水板
 * @Description //TODO
 **/

public class DivingBoard {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] res = new int[k + 1];
        res[0] = shorter * k;
        int dif = longer - shorter;
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + dif;
        }
        return res;
    }
}
