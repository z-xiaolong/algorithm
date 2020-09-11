package designMode.creation.factory.simpleFactory;

/**
 * @Author long
 * @Date 2020/4/19 21:19
 * @Title
 * @Description //TODO
 **/
//简单工厂类
public class SimpleFactory {

    public static Pizza createPizza(String pizzaType) {
        if (pizzaType.equalsIgnoreCase("greek")) {
            return new GreekPizza(pizzaType);
        } else {
            return null;
        }
    }
}
