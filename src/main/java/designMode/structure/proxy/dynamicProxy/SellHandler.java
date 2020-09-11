package designMode.structure.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: long
 * @Date: 2020/8/28 14:41
 * @Title
 * @Description:
 */
public class SellHandler implements InvocationHandler {
    private Object target = null;

    public SellHandler(Object object) {
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        if (result != null) {
            float price = (float) result;
            price += 2;
            result = price;
        }
        System.out.println("加价");
        return result;
    }
}
