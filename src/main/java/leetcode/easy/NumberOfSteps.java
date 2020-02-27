package leetcode.easy;

/**
 * @Author long
 * @Date 2020/2/22 22:50
 * @Title 1342. 将数字变成 0 的操作次数
 * @Description 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。
 * 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 **/

public class NumberOfSteps {

    //位运算
    public int numberOfSteps(int num) {
        int step = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                num &= ~1;
            }
            step++;
        }
        return step;
    }

    //遍历
    public int numberOfSteps1(int num) {
        int times = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }
            times++;
        }
        return times;
    }
}
