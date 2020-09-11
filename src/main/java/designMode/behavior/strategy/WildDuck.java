package designMode.behavior.strategy;

/**
 * @Author: long
 * @Date: 2020/9/2 11:20
 * @Title
 * @Description:
 */
public class WildDuck extends Duck {

    public WildDuck() {
        flyBehavior = new GoodFlyBehavior();
        quackBehavior = new GaGaQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println("野鸭...");
    }
}
