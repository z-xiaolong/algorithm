package designMode.structure.proxy.dynamicProxy.Test;

/**
 * @Author: long
 * @Date: 2020/8/28 15:06
 * @Title
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        InterfaceService service = new InterfaceServiceImpl();

        InterfaceService proxy = (InterfaceService) ProxyFactory.getProxyInstance(service);
        proxy.service("tom");
        System.out.println(proxy.getName());
    }
}
