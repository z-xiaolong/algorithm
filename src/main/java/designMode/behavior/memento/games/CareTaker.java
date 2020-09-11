package designMode.behavior.memento.games;

import java.util.List;
import java.util.Map;

/**
 * @Author: long
 * @Date: 2020/9/1 15:29
 * @Title
 * @Description: 守护者对象，保存游戏角色的状态
 */
public class CareTaker {
    //只保存一次
    private Memento memento;
    /*//保存多次
    private List<Memento> mementos;
    //保存多个游戏角色的多个状态
    private Map<String ,List<Memento>> mementos;*/

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
