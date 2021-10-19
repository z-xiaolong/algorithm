package leetcode.medium;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2021/10/16 20:46
 * @Title
 * @Description //TODO
 **/

public class Makesquare {

    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) return false;
        int edge = sum / 4;
        //TODO
        return true;
    }

}
