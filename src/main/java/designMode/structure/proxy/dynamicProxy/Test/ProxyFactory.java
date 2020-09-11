package designMode.structure.proxy.dynamicProxy.Test;

import java.lang.reflect.Proxy;

/**
 * @Author: long
 * @Date: 2020/8/28 15:04
 * @Title
 * @Description:
 */
public class ProxyFactory {


    public static Object getProxyInstance(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new ProxyHandler(target));
    }
}
