package designMode.structure.flyweight;

/**
 * @Author: long
 * @Date: 2020/8/27 16:49
 * @Title
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();
        WebSite webSite = factory.getWebSiteCategory("新闻");
        webSite.use();
    }

}
