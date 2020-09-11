package designMode.structure.bridge;

/**
 * @Author: long
 * @Date: 2020/8/26 15:48
 * @Title
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new UprightPhone(new XiaoMi());
        phone.open();
        phone.call();
        phone.close();
    }
}
