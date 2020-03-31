package leetcode.easy;

/**
 * @Author long
 * @Date 2020/3/9 10:04
 * @Title 371. 两整数之和
 * @Description 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 **/

public class GetSum {

    //它解
    public int getSum(int a, int b) {
            //进位
            int carry = a & b;
            //相加位
            a = a ^ b;
            while (carry != 0) {
                //左移进位作为新的b
                b = carry << 1;
                //进位
                carry = a & b;
                //相加位
                a = a ^ b;
            }
            return a;
    }
}
