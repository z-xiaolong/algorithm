package designMode.structure.bridge;

/**
 * @Author: long
 * @Date: 2020/8/26 15:41
 * @Title
 * @Description:
 */
public abstract class Phone {
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    protected void open() {
        brand.open();
    }

    protected void close() {
        brand.close();
    }

    protected void call() {
        brand.call();
    }
}
