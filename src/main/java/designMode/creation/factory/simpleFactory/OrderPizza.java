package designMode.creation.factory.simpleFactory;

/**
 * @Author: long
 * @Date: 2020/8/23 11:37
 * @Title
 * @Description:
 */
public class OrderPizza {


    public Pizza orderPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("greek")) {
            pizza = new GreekPizza(orderType);
        } else if (orderType.equals("cheese")) {
            pizza = new GreekPizza(orderType);
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }


}
