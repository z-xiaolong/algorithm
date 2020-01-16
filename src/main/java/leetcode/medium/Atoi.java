package leetcode.medium;

/**
 * @Author long
 * @Date 16:51 2019/11/12
 * @Title 8. 字符串转换整数 (atoi)
 * @Description 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，
 * 作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，
 * 请返回 INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 **/

public class Atoi {

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.myAtoi("-"));
    }

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        //1.去首位的空格
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int head = 0;
        int length = str.length();

        //2.判断正负
        boolean isPositive;
        if (str.charAt(0) == '-') {
            isPositive = false;
            head = 1;
        } else if (str.charAt(0) == '+') {
            isPositive = true;
            head = 1;
        } else if (str.charAt(0) < '0' || str.charAt(0) > '9') {
            return 0;
        } else {
            isPositive = true;
        }

        while (head < length && str.charAt(head) == '0') {
            head++;
        }
        int tail = head;
        while (tail < length && tail - head <= 11 && str.charAt(tail) >= '0' && str.charAt(tail) <= '9') {
            tail++;
        }
        str = str.substring(head, tail);
        if ("+".equals(str) || "-".equals(str) || "".equals(str)) {
            return 0;
        }
        if (!isPositive) {
            str = "-" + str;
        }
        return strToInt(str);
    }

    public int strToInt(String str) {
        if (str.length() > 11) {
            if (str.charAt(0) == '+') {
                return Integer.MAX_VALUE;
            } else if (str.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            }
        }
        System.out.println(str);
        long result = Long.parseLong(str);
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }

    public int myAtoiBest(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int i = 0;
        //2.判断数字的符号
        int flag = 1;
        char ch = str.charAt(i);
        if (ch == '+') {
            i++;
        } else if (ch == '-') {
            flag = -1;
            i++;
        }
        //3.找出数字部分
        int res = 0;
        for (; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch < '0' || ch > '9') {
                break;
            }
            //溢出判断
            if (flag > 0 && res > Integer.MAX_VALUE / 10) {
                return Integer.MAX_VALUE;
            }
            if (flag > 0 && res == Integer.MAX_VALUE / 10 && ch - '0' > Integer.MAX_VALUE % 10) {
                return Integer.MAX_VALUE;
            }
            if (flag < 0 && -res < Integer.MIN_VALUE / 10) {
                return Integer.MIN_VALUE;
            }
            if (flag < 0 && -res == Integer.MIN_VALUE / 10 && -(ch - '0') < Integer.MIN_VALUE % 10) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + ch - '0';
        }
        return res * flag;
    }
}
