package designMode.behavior.strategy;

/**
 * @Author: long
 * @Date: 2020/9/2 11:13
 * @Title
 * @Description:
 */
public class NoQuackBehavior implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("不能叫...");
    }
}
