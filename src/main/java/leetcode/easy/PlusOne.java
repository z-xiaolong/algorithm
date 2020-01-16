package leetcode.easy;

/**
 * @Author long
 * @Date 2019/12/25 17:03
 * @Title 66. 加一
 * @Description 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 **/

public class PlusOne {
    public int[] plusOne1(int[] digits) {
        int length = digits.length;
        int carry = 0;
        digits[length - 1]++;
        for (int i = length - 1; i >= 0; i--) {
            int bit = digits[i] + carry;
            digits[i] = bit % 10;
            carry = bit / 10;
        }
        if (carry > 0) {
            int[] array = new int[length + 1];
            array[0] = 1;
            return array;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 9, 9, 9, 9};
        PlusOne plusOne = new PlusOne();
        int[] a = plusOne.plusOne(array);
        for (int i : a) {
            System.out.print(i);
        }

    }

    public int[] plusOne(int[] digits) {
        int length = digits.length - 1;
        digits[length]++;
        int carry = digits[length] / 10;
        digits[length] = digits[length] % 10;
        while (length > 0 && carry > 0) {
            length--;
            digits[length] = digits[length] + carry;
            carry = digits[length] / 10;
            digits[length] = digits[length] % 10;
        }
        if (carry > 0) {
            int[] array = new int[digits.length + 1];
            array[0] = 1;
            return array;
        }
        return digits;
    }

    class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i]++;
                digits[i] = digits[i] % 10;
                if (digits[i] != 0) {
                    return digits;
                }
            }
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
    }
}
