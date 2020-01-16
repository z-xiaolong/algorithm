package javaCore.test;

/**
 * @Author long
 * @Date 19:21 2019/11/18
 * @Title
 * @Description
 **/

public class IntegerTest {
    public static void main(String[] args) {
        Object a = 128;
        Object b = 128;
        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());
        System.out.println(a == b);
        Object a1 = 127;
        Object b1 = 127;
        System.out.println(a1.getClass().getName());
        System.out.println(b1.getClass().getName());
        System.out.println(a1 == b1);
        int a2 = 128;
        int b2 = 128;
        System.out.println(a2 == b2);
    }
}
