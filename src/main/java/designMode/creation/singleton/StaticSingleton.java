package designMode.creation.singleton;

/**
 * @Author long
 * @Date 2020/1/31 11:05
 * @Title
 * @Description //TODO
 **/

public class StaticSingleton {
    private static class SingleHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    private StaticSingleton() {
    }

    public static StaticSingleton getInstance() {
        return SingleHolder.instance;
    }
}
