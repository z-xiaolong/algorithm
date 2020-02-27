package designMode.creation.singleton;

/**
 * @Author long
 * @Date 2020/1/31 10:35
 * @Title
 * @Description 懒汉式
 **/

public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    //线程不安全
    public static LazySingleton getInstance0() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    //加了锁，线程安全，效率降低，大部分情况下不需要加锁。
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
