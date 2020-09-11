package designMode.behavior.mediator;

public class ClientTest {

    public static void main(String[] args) {
        //创建一个中介者对象
        Mediator mediator = new ConcreteMediator();

        //创建 Alarm 并且加入到  ConcreteMediator 对象的HashMap
        Alarm alarm = new Alarm(mediator, "alarm");

        //创建 CoffeeMachine 对象，并且加入到 ConcreteMediator 对象的HashMap
        CoffeeMachine coffeeMachine = new CoffeeMachine(mediator, "coffeeMachine");

        //创建 Curtains ,
        Curtains curtains = new Curtains(mediator, "curtains");
        TV tV = new TV(mediator, "TV");

        alarm.SendAlarm(0);
        coffeeMachine.FinishCoffee();
        alarm.SendAlarm(1);
        tV.StartTv();
        curtains.UpCurtains();
    }

}
