package leetcode.easy;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/2/27 11:56
 * @Title 67. 二进制求和
 * @Description 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 **/

public class AddBinary {

    public static void main(String[] args) {
        char a = '1';
        char b = '0';
        char[] chars = new char[3];
        chars[0] = '0';
        System.out.println(a ^ b);
    }

    public String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int length = Math.max(aLength, bLength) + 1;
        char[] result = new char[length];
        result[result.length - 1] = '0';
        int index = result.length;
        while (aLength > 0 && bLength > 0 && index > 0) {
            calculate(index - 1, result, a.charAt(aLength - 1), b.charAt(bLength - 1));
            index--;
            aLength--;
            bLength--;
        }
        while (aLength > 0 && index > 0) {
            calculate(index - 1, result, a.charAt(aLength - 1), '0');
            index--;
            aLength--;
        }
        while (bLength > 0 && index > 0) {
            calculate(index - 1, result, '0', b.charAt(bLength - 1));
            index--;
            bLength--;
        }
        if (result[0] == '0') {
            return new String(result).substring(1, result.length);
        }
        return new String(result);
    }


    public void calculate(int index, char[] result, char a, char b) {
        if (result[index] == '1') {
            if (a == '1' && b == '1') {
                result[index] = '1';
                result[index - 1] = '1';
            } else if (a != b) {
                result[index] = '0';
                result[index - 1] = '1';
            } else {
                result[index] = '1';
                result[index - 1] = '0';
            }
        } else if (result[index] == '0') {
            if (a == '1' && b == '1') {
                result[index] = '0';
                result[index - 1] = '1';
            } else if (a != b) {
                result[index] = '1';
                result[index - 1] = '0';
            } else {
                result[index] = '0';
                result[index - 1] = '0';
            }
        }
    }


    //官方最佳答案
    public String addBinaryI(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }
}
