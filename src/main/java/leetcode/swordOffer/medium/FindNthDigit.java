package leetcode.swordOffer.medium;

/**
 * @Author long
 * @Date 2020/3/30 17:24
 * @Title 面试题44. 数字序列中某一位的数字
 * @Description //TODO
 **/

public class FindNthDigit {

    public static void main(String[] args) {
        System.out.println(findNthDigit(1000000000));
    }


    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public static int findNthDigit(int n) {
        if (n == 0) return 0;
        int i = 1;
        long bit = 9;
        while (n > (bit * i)) {
            n -= bit * i;
            bit *= 10;
            i++;
        }
        int m = (n - 1) / i;
        m += (int) Math.pow(10, i - 1);
        n = (n - 1) % i;
        char num = String.valueOf(m).charAt(n);
        return num - '0';
    }
}
