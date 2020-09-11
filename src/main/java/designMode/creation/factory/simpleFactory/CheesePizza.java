package designMode.creation.factory.simpleFactory;

/**
 * @Author: long
 * @Date: 2020/8/23 11:36
 * @Title
 * @Description:
 */
public class CheesePizza extends Pizza {


    public CheesePizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println("Prepare CheesePizza");
    }
}
