package designMode.creation.singleton;

/**
 * @Author long
 * @Date 2020/1/31 10:45
 * @Title
 * @Description 双重校验，线程安全，实现延迟加载效率高。
 **/

public class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) { //给DoubleCheckSingleton类加锁
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
