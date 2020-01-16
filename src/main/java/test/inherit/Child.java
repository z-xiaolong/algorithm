package test.inherit;

/**
 * @Author long
 * @Date 2019/12/16 14:21
 * @Title
 * @Description //TODO
 **/

public class Child extends Parent {

    public Child() {
        System.out.println("Child's constructor  " + this.getClass().getSimpleName());
    }

    @Override
    public void init() {
        System.out.println("Child init");
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        System.out.println("Child's onCreate");
    }
}
