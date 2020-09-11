package designMode.structure.bridge;

/**
 * @Author: long
 * @Date: 2020/8/26 15:46
 * @Title
 * @Description:
 */
public class Vivo implements Brand {
    @Override
    public void open() {
        System.out.println("Vivo open");
    }

    @Override
    public void close() {
        System.out.println("Vivo close");
    }

    @Override
    public void call() {
        System.out.println("Vivo call");
    }
}
