package designMode.behavior.state;

public abstract class State {


    //扣积分 -50
    public abstract void deductMoney();

    //是否抽中奖品
    public abstract boolean raffle();

    //发放奖品
    public abstract void dispensePrize();

}
