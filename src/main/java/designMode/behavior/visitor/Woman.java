package designMode.behavior.visitor;

/**
 * @Author: long
 * @Date: 2020/8/31 10:27
 * @Title
 * @Description:
 */
public class Woman extends Person {
    @Override
    public void accept(Action action) {
        action.getWomanVote(this);
    }
}
