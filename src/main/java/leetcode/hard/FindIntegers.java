package leetcode.hard;

/**
 * @Author long
 * @Date 2020/5/3 21:37
 * @Title 600. 不含连续1的非负整数
 * @Description //TODO
 **/

public class FindIntegers {

    public int findIntegers(int num) {
        return 0;
    }


    //暴力法：超时
    public int findIntegersI(int num) {
        int count = 0;
        for (int i = 0; i <= num; i++) {
            if (check(i)) count++;
        }
        return count;
    }


    public boolean check(int num) {
        while (num >= 3) {
            if ((num & 3) == 3) {
                return false;
            }
            num = num >> 1;
        }
        return true;
    }
}
