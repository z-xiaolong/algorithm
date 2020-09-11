package designMode.behavior.strategy;

/**
 * @Author: long
 * @Date: 2020/9/2 11:12
 * @Title
 * @Description:
 */
public class GoodFlyBehavior implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("飞翔技术高超");
    }
}
