package leetcode.swordOffer.easy;

import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/3/14 21:53
 * @Title 面试题66. 构建乘积数组
 * @Description 不能使用除法。
 **/

public class ConstructArr {

    //对称遍历：执行用时 :2 ms, 在所有 Java 提交中击败了84.59%的用户
    public int[] constructArr(int[] a) {
        int length = a.length;
        int[] product = new int[length];
        int temp = 1;
        for (int i = 0; i < length; i++) {
            product[i] = temp;
            temp *= a[i];
        }
        temp = 1;
        for (int i = length - 1; i >= 0; i--) {
            product[i] *= temp;
            temp *= a[i];
        }
        return product;
    }

    //去除1：执行用时 :7 ms, 在所有 Java 提交中击败了5.50%的用户
    public int[] constructArrII(int[] a) {
        int[] product = new int[a.length];
        Arrays.fill(product, 1);
        int p = 1;
        for (int n : a) {
            p *= n;
        }
        for (int i = 0; i < product.length; i++) {
            if (a[i] == 1) {
                product[i] = p;
                continue;
            }
            for (int j = 0; j < a.length; j++) {
                if (j == i) {
                    continue;
                }
                product[i] *= a[j];
            }
        }
        return product;
    }

    //暴力法  超时
    public int[] constructArrI(int[] a) {
        int[] product = new int[a.length];
        Arrays.fill(product, 1);
        for (int i = 0; i < product.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (j == i) {
                    continue;
                }
                product[i] *= a[j];
            }
        }
        return product;
    }
}
