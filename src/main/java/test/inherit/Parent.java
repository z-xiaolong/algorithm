package test.inherit;

/**
 * @Author long
 * @Date 2019/12/16 14:19
 * @Title
 * @Description //TODO
 **/

public abstract class Parent {

    public Parent() {
        System.out.println("Parent's construct  " + this.getClass().getSimpleName());
    }

    protected void onCreate() {
        System.out.println("Parent's onCreate");
        init();
        print(this);
    }

    public static void print(Object object) {
        System.out.println(object.getClass().getSimpleName());
    }

    public abstract void init();
}
