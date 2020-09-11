package designMode.structure.bridge;

/**
 * @Author: long
 * @Date: 2020/8/26 15:45
 * @Title
 * @Description:
 */
public class XiaoMi implements Brand {
    @Override
    public void open() {
        System.out.println("XiaoMi open");
    }

    @Override
    public void close() {
        System.out.println("XiaoMi close");
    }

    @Override
    public void call() {
        System.out.println("XiaoMi call");
    }
}
