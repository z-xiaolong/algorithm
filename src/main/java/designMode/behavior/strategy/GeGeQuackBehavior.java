package designMode.behavior.strategy;

/**
 * @Author: long
 * @Date: 2020/9/2 11:15
 * @Title
 * @Description:
 */
public class GeGeQuackBehavior implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("咯咯叫...");
    }
}
