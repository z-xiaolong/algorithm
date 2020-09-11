package designMode.behavior.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: long
 * @Date: 2020/8/31 10:35
 * @Title
 * @Description: 数据结构，管理很多人员
 */
public class ObjectStructure {
    private List<Person> persons = new LinkedList<>();

    public void attach(Person person) {
        persons.add(person);
    }

    public void detach(Person person) {
        persons.remove(person);
    }

    public void display(Action action) {
        for (Person p : persons) {
            p.accept(action);
        }
    }
}
