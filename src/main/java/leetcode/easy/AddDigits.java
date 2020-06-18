package leetcode.easy;

/**
 * @Author long
 * @Date 2020/6/6 9:54
 * @Title 258. 各位相加
 * @Description //TODO
 **/

public class AddDigits {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
