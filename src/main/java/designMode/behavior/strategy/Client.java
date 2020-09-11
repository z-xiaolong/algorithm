package designMode.behavior.strategy;

/**
 * @Author: long
 * @Date: 2020/9/2 11:24
 * @Title
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();

        wildDuck.fly();
        wildDuck.quack();

        wildDuck.setFlyBehavior(new BadFlyBehavior(){
            @Override
            public void fly() {
                System.out.println("新建的行为");
            }
        });

        wildDuck.fly();

        ToyDuck toyDuck = new ToyDuck();
        toyDuck.fly();
        wildDuck.quack();

        PekingDuck pekingDuck = new PekingDuck();
        pekingDuck.fly();
        pekingDuck.quack();
    }
}
