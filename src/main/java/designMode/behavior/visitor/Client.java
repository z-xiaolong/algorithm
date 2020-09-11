package designMode.behavior.visitor;

/**
 * @Author: long
 * @Date: 2020/8/31 10:37
 * @Title
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        ObjectStructure structure = new ObjectStructure();
        structure.attach(new Man());
        structure.attach(new Woman());
        structure.attach(new Man());


        Success success = new Success();
        structure.display(success);

        Fail fail = new Fail();
        structure.display(fail);

        Wait wait = new Wait();
        structure.display(wait);
    }
}
