package designMode.behavior.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: long
 * @Date: 2020/9/1 15:15
 * @Title
 * @Description: 守护者对象，负责保存多个备忘录对象，使用集合管理，提高效率
 */
public class CareTaker {


    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
