package designMode.behavior.visitor;

/**
 * @Author: long
 * @Date: 2020/8/31 10:27
 * @Title
 * @Description:
 */
public class Man extends Person {
    @Override
    public void accept(Action action) {
        action.getManVote(this);
    }
}
