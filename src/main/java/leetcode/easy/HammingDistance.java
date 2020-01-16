package leetcode.easy;

/**
 * @Author long
 * @Date 14:44 2019/10/31
 * @Title 461. 汉明距离
 * @Description 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 2的31次方.
 **/

public class HammingDistance {
    public static void main(String[] args) {
        int x = 100;
        int y = 200;
        Integer.bitCount(x^y);
    }
    public int hammingDistance(int x, int y) {
        int count = 0;
        int result = x ^ y;
        while (result != 0) {
            count += result & 1;
            result >>= 1;
        }
        return count;
    }
}
