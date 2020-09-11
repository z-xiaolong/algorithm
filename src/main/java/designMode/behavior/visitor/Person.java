package designMode.behavior.visitor;

/**
 * @Author: long
 * @Date: 2020/8/31 10:22
 * @Title
 * @Description:
 */
public abstract class Person {
    public abstract void accept(Action action);
}
