package designMode.behavior.visitor;

/**
 * @Author: long
 * @Date: 2020/8/31 10:21
 * @Title
 * @Description:
 */
public class Success extends Action {
    @Override
    public void getManVote(Man man) {
        System.out.println("man vote success.");
    }

    @Override
    public void getWomanVote(Woman woman) {
        System.out.println("woman vote success.");
    }
}
