package designMode.creation.factory.simpleFactory;

/**
 * @Author long
 * @Date 2020/4/19 21:22
 * @Title
 * @Description //TODO
 **/

public class GreekPizza extends Pizza {

    public GreekPizza(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println("Prepare GreekPizza");
    }
}
