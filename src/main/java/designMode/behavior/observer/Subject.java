package designMode.behavior.observer;

/**
 * @Author: long
 * @Date: 2020/8/31 17:02
 * @Title
 * @Description:
 */
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}
