package leetcode.hard;

/**
 * @Author: long
 * @Date: 2020/8/3 10:42
 * @Title 65. 有效数字
 * @Description:
 */
public class IsNumber {

    public static void main(String[] args) {
        IsNumber number = new IsNumber();
        number.isNumber(" 005047e+6");
    }


    public boolean isNumber(String s) {
        s = s.trim();
        int n = s.length();
        int i = 0;
        boolean isDecimal = false;
        boolean isExponent = false;
        boolean isNum = false;
        while (i < n) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                isNum = true;
            } else if (c == '.') {
                if (isDecimal || isExponent) {
                    return false;
                }
                isDecimal = true;
            } else if (c == 'E' || c == 'e') {
                if (isExponent || !isNum) {
                    return false;
                }
                isExponent = true;
                isNum = false;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else {
                return false;
            }
            i++;
        }
        return isNum;
    }

    public boolean decimal(String s, int index) {

        return true;
    }

    public boolean exponent(String s, int index) {

        return true;
    }
}
