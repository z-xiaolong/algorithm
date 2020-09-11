package designMode.behavior.memento;

/**
 * @Author: long
 * @Date: 2020/9/1 15:10
 * @Title
 * @Description:  需要保存状态的对象
 */
public class Originator {

    private String state;//状态信息

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //保存状态信息
    public Memento saveStateMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
