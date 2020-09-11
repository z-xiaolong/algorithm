package designMode.structure.proxy.cglib;

/**
 * @Author: long
 * @Date: 2020/8/28 15:45
 * @Title
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        TeacherDao target = new TeacherDao();

        TeacherDao proxyInstance = (TeacherDao) new ProxyFactory(target).getProxyInstance();

        String res = proxyInstance.teach();

        System.out.println(res);
    }
}
