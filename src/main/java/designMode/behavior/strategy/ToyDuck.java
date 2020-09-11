package designMode.behavior.strategy;

/**
 * @Author: long
 * @Date: 2020/9/2 11:20
 * @Title
 * @Description:
 */
public class ToyDuck extends Duck {

    public ToyDuck() {
        flyBehavior = new NoFlayBehavior();
        quackBehavior = new GaGaQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println("玩具鸭...");
    }
}
