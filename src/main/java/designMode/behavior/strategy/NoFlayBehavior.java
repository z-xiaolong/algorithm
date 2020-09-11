package designMode.behavior.strategy;

/**
 * @Author: long
 * @Date: 2020/9/2 11:12
 * @Title
 * @Description:
 */
public class NoFlayBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不能飞翔");
    }
}
