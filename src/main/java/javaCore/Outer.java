package javaCore;

/**
 * @Author: long
 * @Date: 2020/9/7 13:41
 * @Title
 * @Description:
 */
public class Outer {
    private int privateAge;
    private String privateName;
    public int publicAge;
    public String publicName;
    Inner inner = new Inner();

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.new Inner();
        System.out.println(outer.inner == inner);

        StaticInner staticInner = new StaticInner();
    }

    public Outer() {

        //StaticInner staticInner = new StaticInner();

        System.out.println(this);
        System.out.println("Outer Struct");
    }

    public void outerMethod() {
        System.out.println("outerMethod");
    }

    public static void staticOuterMethod() {

    }

    static class StaticInner {

        public StaticInner() {
            System.out.println("StaticInner Struct");
        }

        public void staticMethod() {
            System.out.println("staticInnerMethod");
            System.out.println();
            //outerMethod();
        }

        public static void staticInnerMethod() {
            staticOuterMethod();

            System.out.println();
        }
    }

    public class Inner {

        public int age;

        public Inner() {

            System.out.println("Inner");
            System.out.println(Outer.this);
        }

        public void innerMethod() {
            System.out.println(publicName);
            outerMethod();

            System.out.println("Inner Method...");
        }

        //非静态内部类不能有静态方法
        /*public static void staticMethod() {

        }*/
    }

}
