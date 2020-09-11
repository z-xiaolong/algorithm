package designMode.behavior.state;


public class DispenseState extends State {


    RaffleActivity activity;

    public DispenseState(RaffleActivity activity) {
        this.activity = activity;
    }
    
    //

    @Override
    public void deductMoney() {
        System.out.println("���ܿ۳�����");
    }

    @Override
    public boolean raffle() {
        System.out.println("���ܳ齱");
        return false;
    }


    @Override
    public void dispensePrize() {
        if(activity.getCount() > 0){
            System.out.println("��ϲ�н���");
            activity.setState(activity.getNoRafflleState());
        }else{
            System.out.println("���ź�����Ʒ��������");
            activity.setState(activity.getDispensOutState());

        }

    }
}
