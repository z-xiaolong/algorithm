package designMode.behavior.state;

import java.util.Random;


//发放奖品的状态
public class CanRaffleState extends State {

    RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    //已经扣除了积分
    @Override
    public void deductMoney() {
        System.out.println("已经扣取过积分");
    }

    //可以抽奖，抽完奖后，根据实际情况改变状态
    @Override
    public boolean raffle() {
        System.out.println("正在抽奖，请稍等");
        Random r = new Random();
        int num = r.nextInt(10);

        if (num == 0) {

            activity.setState(activity.getDispenseState());
            return true;
        } else {
            System.out.println("很遗憾没有抽中奖品");

            activity.setState(activity.getNoRafflleState());
            return false;
        }
    }


    //不能发放奖品
    @Override
    public void dispensePrize() {
        System.out.println("没有中奖，不能发放奖品");
    }
}
