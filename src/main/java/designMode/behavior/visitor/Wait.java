package designMode.behavior.visitor;

/**
 * @Author: long
 * @Date: 2020/8/31 10:41
 * @Title
 * @Description:
 */
public class Wait extends Action {
    @Override
    public void getManVote(Man man) {
        System.out.println("man vote wait.");
    }

    @Override
    public void getWomanVote(Woman woman) {
        System.out.println("woman vote wait.");
    }
}
