package designMode.structure.proxy.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: long
 * @Date: 2020/8/28 11:34
 * @Title
 * @Description:
 */
public class TestApp {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HelloService target = new HelloServiceImpl("李四");
        Method method = HelloService.class.getMethod("sayHello", String.class);
        Object obj = method.invoke(target, "张三");
        Method method1 = HelloService.class.getMethod("sayBye");
        Object o = method1.invoke(target);
        System.out.println(obj);
        System.out.println(o);
        System.out.println(target.getClass().getClassLoader());
    }
}
