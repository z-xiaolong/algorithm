package designMode.creation.singleton;

/**
 * @Author long
 * @Date 2020/1/31 11:14
 * @Title
 * @Description 枚举，不支持懒加载，线程安全
 **/

public enum EnumSingleton {
    INSTANCE;
    private String name = "hello";

    public String getName() {
        return name;
    }
}
