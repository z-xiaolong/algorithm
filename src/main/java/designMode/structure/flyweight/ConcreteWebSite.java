package designMode.structure.flyweight;

/**
 * @Author: long
 * @Date: 2020/8/27 16:44
 * @Title
 * @Description:
 */
public class ConcreteWebSite extends WebSite {

    private String type;

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use() {
        System.out.println("网站发布形式为： " + type);
    }
}
