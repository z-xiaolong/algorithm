package designMode.structure.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: long
 * @Date: 2020/8/28 14:48
 * @Title
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        UsbSell factory = new UsbKingFactory();

        InvocationHandler handler = new SellHandler(factory);

        UsbSell proxy = (UsbSell) Proxy.newProxyInstance(
                factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(),
                handler);
        float price = proxy.sell(3);
        System.out.println(price);

    }
}
