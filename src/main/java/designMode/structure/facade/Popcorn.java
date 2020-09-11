package designMode.structure.facade;

/**
 * @Author: long
 * @Date: 2020/8/27 15:41
 * @Title
 * @Description:
 */
public class Popcorn {
    private static Popcorn instance = new Popcorn();

    public static Popcorn getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(" Popcorn on");
    }

    public void off() {
        System.out.println("Popcorn off");
    }

    public void pop() {
        System.out.println("Popcorn popping");
    }
}
