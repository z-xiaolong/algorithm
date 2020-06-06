package leetcode.swordOffer.easy;

/**
 * @Author long
 * @Date 2020/4/3 9:02
 * @Title 面试题65. 不用加减乘除做加法
 * @Description //TODO
 **/

public class Add {

    public static void main(String[] args) {
        System.out.println(add(-10, 6));
    }

    //递归: 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public static int add(int a, int b) {
        int and = a & b;
        if (and == 0) {
            return a ^ b;
        } else {
            return add(and << 1, a ^ b);
        }
    }

    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public static int addI(int a, int b) {
        int xor = a ^ b;
        int and = a & b;
        while (and != 0) {
            int carry = and << 1;
            and = carry & xor;
            xor = carry ^ xor;
        }
        return xor;
    }
}
