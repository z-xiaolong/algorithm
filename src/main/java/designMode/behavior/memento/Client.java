package designMode.behavior.memento;

/**
 * @Author: long
 * @Date: 2020/9/1 15:17
 * @Title
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("状态#1");
        //保存当前状态
        careTaker.add(originator.saveStateMemento());

        originator.setState("状态#2");

        careTaker.add(originator.saveStateMemento());
        originator.setState("状态#3");
        careTaker.add(originator.saveStateMemento());
        originator.setState("状态#4");
        careTaker.add(originator.saveStateMemento());

        System.out.println("当前状态是=" + originator.getState());

        originator.getStateFromMemento(careTaker.get(0));

        System.out.println("恢复状态：" + originator.getState());
    }
}
