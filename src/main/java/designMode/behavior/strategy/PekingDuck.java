package designMode.behavior.strategy;

/**
 * @Author: long
 * @Date: 2020/9/2 11:17
 * @Title
 * @Description:
 */
public class PekingDuck extends Duck {

    public PekingDuck() {
        flyBehavior = new NoFlayBehavior();
        quackBehavior = new GeGeQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println("北京鸭...");
    }
}
