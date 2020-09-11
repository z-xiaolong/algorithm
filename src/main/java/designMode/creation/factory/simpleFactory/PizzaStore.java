package designMode.creation.factory.simpleFactory;

/**
 * @Author: long
 * @Date: 2020/8/23 11:42
 * @Title
 * @Description:
 */
public class PizzaStore {

    public static void main(String[] args) {
        OrderPizza orderPizza = new OrderPizza();
        Pizza pizza = orderPizza.orderPizza("greek");

    }
}
