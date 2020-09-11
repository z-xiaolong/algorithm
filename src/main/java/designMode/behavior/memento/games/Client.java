package designMode.behavior.memento.games;

/**
 * @Author: long
 * @Date: 2020/9/1 15:37
 * @Title
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        GameRole gameRole = new GameRole();
        gameRole.setDef(100);
        gameRole.setVit(100);
        System.out.println("大战前");
        gameRole.display();


        CareTaker careTaker = new CareTaker();
        careTaker.setMemento(gameRole.createMemento());


        gameRole.setVit(30);
        gameRole.setDef(30);
        gameRole.display();

        gameRole.recover(careTaker.getMemento());
        gameRole.display();
    }
}
