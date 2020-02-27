package leetcode.easy;

/**
 * @Author long
 * @Date 2020/2/23 9:55
 * @Title 1281. 整数的各位积和之差
 * @Description 给你一个整数 n，
 * 请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 **/

public class SubtractProductAndSum {
    public static void main(String[] args) {
        System.out.println(Math.pow(10, 2));
    }

    public int subtractProductAndSum(int n) {
        int multiplication = 1;
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            multiplication *= temp;
            sum += temp;
            n = n / 10;
        }
        return multiplication - sum;
    }

}
