package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author long
 * @Date 2020/4/30 8:55
 * @Title 202. 快乐数
 * @Description //TODO
 **/

public class IsHappy {

    public static void main(String[] args) {

    }


    //执行用时 :2 ms, 在所有 Java 提交中击败了51.98%的用户
    public boolean isHappyI(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = nextNum(n);
        }
        return n == 1;
    }


    public int nextNum(int num) {
        int sum = 0;
        while (num > 0) {
            int temp = num % 10;
            sum += temp * temp;
            num /= 10;
        }
        return sum;
    }
}
