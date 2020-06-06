package designMode.creation.factory.simpleFactory;

/**
 * @Author long
 * @Date 2020/4/19 21:21
 * @Title
 * @Description //TODO
 **/

public abstract class Pizza {

    String name;

    public Pizza(String name) {
        this.name = name;
    }

    public void bake() {
        System.out.println("baking");
    }

    public void cut() {
        System.out.println("cut");
    }
}
