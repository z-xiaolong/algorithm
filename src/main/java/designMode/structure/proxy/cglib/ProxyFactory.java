package designMode.structure.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: long
 * @Date: 2020/8/28 15:33
 * @Title
 * @Description:
 */
public class ProxyFactory implements MethodInterceptor {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {

        //创建工具类
        Enhancer enhancer = new Enhancer();

        //设置父类
        enhancer.setSuperclass(target.getClass());

        //设置回调函数
        enhancer.setCallback(this);
        //创建子类对象，即代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o,
                            Method method,
                            Object[] objects,
                            MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib proxy begin...");
        Object object = method.invoke(target, objects);
        System.out.println("Cglib proxy end");
        return object;
    }

}
