package leetcode.swordOffer.medium;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 2020/3/25 23:00
 * @Title 面试题67. 把字符串转换成整数
 * @Description //TODO
 **/

public class StrToInt {

    public static void main(String[] args) {
        System.out.println(Long.parseLong("+000000000"));
        StringBuilder builder = new StringBuilder(15);
        for (int i = 0; i < 10; i++) {
            builder.append(i);
        }
        System.out.println(Long.parseLong(builder.toString()));
        System.out.println(Long.parseLong("123".substring(0, 0)));
    }

    //执行用时 :4 ms, 在所有 Java 提交中击败了22.02%的用户
    public static int strToInt(String str) {
        //去掉首尾空格
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        //判断正负
        int head = 0;
        boolean isPositive = true;
        if (str.charAt(head) == '-') {
            isPositive = false;
            head++;
        } else if (str.charAt(head) == '+') {
            head++;
        } else if (str.charAt(0) > '9' || str.charAt(0) < '0') {
            return 0;
        }
        //去掉首部0
        while (head < str.length() && str.charAt(head) == '0') {
            head++;
        }
        //找到15位有效数字
        int tail = head;
        while (tail - head < 15 && tail < str.length() && str.charAt(tail) <= '9' && str.charAt(tail) >= '0') {
            tail++;
        }
        //判断是否为空
        String sub = str.substring(head, tail);
        if ("".equals(sub)) {
            return 0;
        }
        //得到有效数字
        long num = Long.parseLong(sub);
        if (num > Integer.MAX_VALUE) {
            if (isPositive) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (isPositive) {
            return (int) num;
        } else {
            return -(int) num;
        }
    }
}
