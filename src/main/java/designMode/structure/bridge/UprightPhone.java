package designMode.structure.bridge;

/**
 * @Author: long
 * @Date: 2020/8/26 15:44
 * @Title
 * @Description:
 */
public class UprightPhone extends Phone {
    public UprightPhone(Brand brand) {
        super(brand);
    }


    @Override
    protected void open() {
        super.open();
        System.out.println("UprightPhone");
    }

    @Override
    protected void close() {
        super.close();
        System.out.println("UprightPhone");
    }

    @Override
    protected void call() {
        super.call();
        System.out.println("UprightPhone");
    }
}
