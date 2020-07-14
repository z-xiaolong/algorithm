package leetcode.medium;

import java.util.Random;

/**
 * @Author long
 * @Date 2020/7/8 16:16
 * @Title
 * @Description //TODO
 **/

public class Rand10 {

    public int rand10() {
        int row, col;
        int result = (rand7() - 1) * 7 + rand7();
        while (result > 40) {
            row = rand7();
            col = rand7();
            result = row + (col - 1) * 7;
        }
        return result % 10 + 1;
    }

    public int rand7() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }
}
