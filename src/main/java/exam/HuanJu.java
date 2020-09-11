package exam;

import java.util.*;

/**
 * @Author: long
 * @Date: 2020/8/31 18:42
 * @Title
 * @Description:
 */
public class HuanJu {
    public static void main(String[] args) {
        System.out.println(nextNarcissisticNumber(8));
    }


    public static long nextNarcissisticNumber(int n) {
        long temp = n + 1;
        while (true) {
            if (isNarcissisticNumber(temp)) return temp;
            temp++;
        }
    }

    public static boolean isNarcissisticNumber(long num) {
        long temp = num;
        int count = 0;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        temp = num;
        long sum = 0;
        while (temp > 0) {
            long bit = temp % 10;
            long product = 1;
            for (int i = 0; i < count; i++) {
                product *= bit;
            }
            sum += product;
            temp /= 10;
        }
        return sum == num;
    }
}
