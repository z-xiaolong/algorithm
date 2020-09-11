package designMode.structure.flyweight;

import java.util.HashMap;

/**
 * @Author: long
 * @Date: 2020/8/27 16:45
 * @Title
 * @Description:
 */
public class WebSiteFactory {
    private HashMap<String, ConcreteWebSite> pool = new HashMap<>();

    public WebSite getWebSiteCategory(String type) {
        if (!pool.containsKey(type)) {
            pool.put(type, new ConcreteWebSite(type));
        }
        return pool.get(type);
    }

    public int getWebSiteSize() {
        return pool.size();
    }
}
