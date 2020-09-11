package designMode.behavior.memento;

/**
 * @Author: long
 * @Date: 2020/9/1 15:12
 * @Title
 * @Description: 负责保存记录，即Originator内部状态
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
