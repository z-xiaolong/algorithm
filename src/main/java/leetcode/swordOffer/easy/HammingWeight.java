package leetcode.swordOffer.easy;

import javax.swing.plaf.IconUIResource;

/**
 * @Author long
 * @Date 2020/3/8 20:11
 * @Title 面试题15. 二进制中1的个数
 * @Description //TODO
 **/

public class HammingWeight {
    public static void main(String[] args) {
        String s = Integer.toBinaryString(-2);
        String s1 = Integer.toBinaryString(2);
        System.out.println(s);
        System.out.println(s1);
        int i = -3;
        System.out.println(Integer.toBinaryString(i));
        i <<= 1;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(~Integer.MIN_VALUE));
    }

    //转化为字符串：执行用时 :2 ms, 在所有 Java 提交中击败了8.52%的用户
    public static int hammingWeight(int n) {
        String bs = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < bs.length(); i++) {
            if (bs.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    //1ms
    public static int hammingWeightI(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        if (n < 0) {
            n = ~n;
            while (n > 0) {
                if ((n & 1) == 1) {
                    count++;
                }
                n >>= 1;
            }
            count = 32 - count;
        }
        return count;
    }


    // 官方解I
    public int hammingWeightII(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    //官方解II
    public int hammingWeightIII(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    //汉明距离
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int mask = 1;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                sum++;
            }
            mask <<= 1;
        }
        return sum;
    }


}
