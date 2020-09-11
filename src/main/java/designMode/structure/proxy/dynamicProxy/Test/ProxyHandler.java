package designMode.structure.proxy.dynamicProxy.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: long
 * @Date: 2020/8/28 15:02
 * @Title
 * @Description:
 */
public class ProxyHandler implements InvocationHandler {
    Object target;

    public ProxyHandler(Object object) {
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy service...");
        return method.invoke(target, args);
    }
}
