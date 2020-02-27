package designMode.creation.singleton;

/**
 * @Author long
 * @Date 2020/1/31 10:40
 * @Title
 * @Description 饿汉式，基于类加载机制保护，线程安全，未达到懒加载的效果。浪费内存，会一直存在内存中。
 **/

public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
