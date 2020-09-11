package designMode.structure.proxy;

/**
 * @Author: long
 * @Date: 2020/8/28 10:42
 * @Title
 * @Description:
 */
public class Main {
    public static void main(String[] args) {

        //目标对象
        ITeacherDao target = new TeacherDao();

        //创建代理对象
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(target).getProxyInstance();

        //class com.sun.proxy.$Proxy0   内存中动态生成了代理对象
        System.out.println(proxyInstance.getClass());

        proxyInstance.teacher();

        proxyInstance.sayHello("tom");
    }
}
