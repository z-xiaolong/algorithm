package designMode.behavior.strategy;

/**
 * @Author: long
 * @Date: 2020/9/2 11:13
 * @Title
 * @Description:
 */
public class BadFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("飞翔技术一般");
    }
}
