package leetcode.easy;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author long
 * @Date 2019/12/5 13:05
 * @Title
 * @Description 生成N个随机数，和为1
 **/

public class RandomDigit {

    public static void main(String[] args) {
        double[] numbers = createRandomDigit(10, 1);
        for (double n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println(check(1, numbers));
    }

    /**
     * create by long on 2019/12/5
     * @param: n个数，和为sum
     * @return double[]
     * @description 生成N个随机数，和为sum
    */
    public static double[] createRandomDigit(int n, double sum) {
        double[] numbers = new double[n];
        Random random = new Random();
        for (int i = 1; i < n; i++) {
            numbers[i] = random.nextDouble() * sum;
        }
        Arrays.sort(numbers);
        double summation = 0;
        for (int i = 0; i < n - 1; i++) {
            numbers[i] = numbers[i + 1] - numbers[i];
            summation = numbers[i] + summation;
        }
        numbers[n - 1] = sum - summation;
        return numbers;
    }

    public static boolean check(double sum, double[] numbers) {
        double summation = 0;
        for (double n : numbers) {
            summation = summation + n;
        }
        return sum == summation;
    }
}
